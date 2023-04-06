package com.example.dictionarydemo;

import com.example.dictionarydemo.Models.APIResponse;

public interface OnFetchDataListener {
    void onFetchData(APIResponse apiResponse, String message);
    void onError(String message);
}
