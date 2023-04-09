package com.example.dictionarydemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionarydemo.Adapters.DefinitionAdapter;
import com.example.dictionarydemo.Adapters.MeaningAdapter;
import com.example.dictionarydemo.Adapters.PhoneticAdapter;
import com.example.dictionarydemo.Models.APIResponse;
import com.example.dictionarydemo.Models.Meanings;
import com.example.dictionarydemo.Models.Phonetics;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SearchView search_view;
    TextView textView_word;
    RecyclerView recycler_phonetics, recycler_meanings;
    ProgressDialog dialog;
    PhoneticAdapter phoneticAdapter;
    MeaningAdapter meaningAdapter;
    Toolbar toolbar;
    private PackageInfo mPackageInfo;
    ArrayList<Phonetics> phoneticsList = new ArrayList<>();
    ArrayList<Meanings> meaningsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view = findViewById(R.id.search_view);
        textView_word = findViewById(R.id.textView_word);
        recycler_phonetics = findViewById(R.id.recycler_phonetics);
        recycler_meanings = findViewById(R.id.recycler_meanings);
        dialog = new ProgressDialog(this);



        recycler_meanings.setHasFixedSize(true);
        recycler_meanings.setLayoutManager(new GridLayoutManager(this, 1));
        meaningAdapter = new MeaningAdapter(this, meaningsList);
        recycler_meanings.setAdapter(meaningAdapter);

        dialog.setTitle("Loading...");
        dialog.show();
        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getWordMeaning(listener, "hello");

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Fetching response for " + query);
                dialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getWordMeaning(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            dialog.dismiss();
            if (apiResponse==null){
                Toast.makeText(MainActivity.this, "No Data Found!", Toast.LENGTH_SHORT).show();
                return;
            }
            showResult(apiResponse);

        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showResult(APIResponse response){
        textView_word.setText("Word: " + response.getWord());


        meaningsList.clear();
        meaningsList.addAll(response.getMeanings());
        meaningAdapter.notifyDataSetChanged();
    }


    }