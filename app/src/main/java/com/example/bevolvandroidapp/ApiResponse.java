package com.example.bevolvandroidapp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApiResponse {
    @SerializedName("totalItems")
    private int totalItems;

    @SerializedName("endIndex")
    private int endIndex;

    @SerializedName("startIndex")
    private int startIndex;

    @SerializedName("itemsPerPage")
    private int itemsPerPage;

    @SerializedName("items")
    private List<Publication> items;

    // Constructor
    public ApiResponse(int totalItems, int endIndex, int startIndex, int itemsPerPage, List<Publication> items) {
        this.totalItems = totalItems;
        this.endIndex = endIndex;
        this.startIndex = startIndex;
        this.itemsPerPage = itemsPerPage;
        this.items = items;
    }
    public int getTotalItems() {
        return totalItems;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public List<Publication> getItems() {
        return items;
    }
}


