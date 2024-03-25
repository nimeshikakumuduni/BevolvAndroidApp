package com.example.bevolvandroidapp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApiResponse {

    @SerializedName("items")
    private final List<Publication> items;

    public ApiResponse(List<Publication> items) {
        this.items = items;
    }

    public List<Publication> getItems() {
        return items;
    }
}


