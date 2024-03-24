package com.example.bevolvandroidapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/search/titles/results/?format=json")
    Call<ApiResponse> getPublications(@Query("terms") String terms, @Query("page") int page);
}


