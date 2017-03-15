package com.example.ajit.myblogapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ajit on 15/3/17.
 */

public class MessageResponse {
    @SerializedName("message")
    String message;

    public String getMessage() {
        return message;
    }

}
