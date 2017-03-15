package com.example.ajit.myblogapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ajit on 15/3/17.
 */

public class ErrorResponse {
    @SerializedName("error")
    String error;

    public String getError() {
        return error;
    }
}
