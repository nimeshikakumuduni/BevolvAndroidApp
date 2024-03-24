package com.example.bevolvandroidapp;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Publication {
    @SerializedName("placeOfPublication")
    private String placeOfPublication;

    @SerializedName("startYear")
    private int startYear;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("county")
    private List<String> county;

    private String imageUrl;

    public Publication(String placeOfPublication, int startYear, String publisher, List<String> county) {
        this.placeOfPublication = placeOfPublication;
        this.startYear = startYear;
        this.publisher = publisher;
        this.county = county;
        generateRandomImageUrl();
    }

    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    public int getStartYear() {
        return startYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public List<String> getCounty() {
        return county;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    private  void generateRandomImageUrl(){
        int width = 200+(int) (Math.random()*400);
        int height = 200+ (int) (Math.random()* 400);
        imageUrl = "http://picsum.photos" + width + "/" + height;

    }
}


