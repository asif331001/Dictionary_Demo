package com.example.dictionarydemo.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionarydemo.R;

public class DefinitionsViewHolder extends RecyclerView.ViewHolder {

    public TextView textView_definition, textView_example,
            textView_synonyms, textView_antonyms;
    public DefinitionsViewHolder(@NonNull View itemView) {
        super(itemView);

        textView_antonyms = itemView.findViewById(R.id.textView_antonyms);
        textView_synonyms = itemView.findViewById(R.id.textView_synonyms);
        textView_example = itemView.findViewById(R.id.textView_example);
        textView_definition = itemView.findViewById(R.id.textView_definition);
    }
}
