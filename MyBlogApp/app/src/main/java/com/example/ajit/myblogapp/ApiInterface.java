package com.example.ajit.myblogapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import static com.example.ajit.myblogapp.NetworkURL.GET_ARTICLES;

/**
 * Created by ajit on 15/3/17.
 */

public interface ApiInterface {
    @POST(NetworkURL.LOGIN)
    Call<MessageResponse> login(@Body AuthenticationRequest body);
    @POST(NetworkURL.REGISTRATION)
    Call<MessageResponse> registration(@Body  AuthenticationRequest body);
    @GET(NetworkURL.GET_ARTICLES)
    Call<List<Article>>getArticles();
}
