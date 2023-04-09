package com.example.dictionarydemo.ViewHolder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionarydemo.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {
    public TextView textView_phonetic;
    public ImageButton imageButton_audio;
    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);

    }

}
