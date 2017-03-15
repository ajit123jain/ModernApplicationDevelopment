package com.example.ajit.myblogapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ajit on 15/3/17.
 */

public class AuthenticationRequest {
    @SerializedName("username")
    String username;
    @SerializedName("password")
    String password;


    public AuthenticationRequest(String username,String password) {
        this.username = username;
        this.password= password;

    }
}
