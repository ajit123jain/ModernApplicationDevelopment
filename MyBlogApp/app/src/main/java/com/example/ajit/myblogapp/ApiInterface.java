package com.example.ajit.myblogapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by ajit on 15/3/17.
 */

public interface ApiInterface {
    @POST(NetworkURL.LOGIN)
    Call<MessageResponse> login(@Body AuthenticationRequest body);
    @POST(NetworkURL.REGISTRATION)
    Call<MessageResponse> registration(@Body  AuthenticationRequest body);
}
