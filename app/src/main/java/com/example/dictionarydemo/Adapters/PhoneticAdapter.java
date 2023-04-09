package com.example.dictionarydemo.Adapters;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionarydemo.Models.Phonetics;
import com.example.dictionarydemo.R;
import com.example.dictionarydemo.ViewHolder.PhoneticViewHolder;

import java.io.IOException;
import java.util.List;

public class PhoneticAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
