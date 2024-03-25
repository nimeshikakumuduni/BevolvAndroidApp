package com.example.bevolvandroidapp;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.UUID;

public class Publication implements Parcelable {
    private String placeOfPublication;
    private int startYear;
    private String publisher;
    private List<String> county;
    private String imageUrl;

    public Publication(String placeOfPublication, int startYear, String publisher, List<String> county) {
        this.placeOfPublication = placeOfPublication;
        this.startYear = startYear;
        this.publisher = publisher;
        this.county = county;
        generateRandomImageUrl();
    }

    protected Publication(Parcel in) {
        placeOfPublication = in.readString();
        startYear = in.readInt();
        publisher = in.readString();
        county = in.createStringArrayList();
        imageUrl = in.readString();
    }

    public static final Creator<Publication> CREATOR = new Creator<Publication>() {
        @Override
        public Publication createFromParcel(Parcel in) {
            return new Publication(in);
        }

        @Override
        public Publication[] newArray(int size) {
            return new Publication[size];
        }
    };

    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    public void setPlaceOfPublication(String placeOfPublication) {
        this.placeOfPublication = placeOfPublication;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<String> getCounty() {
        return county;
    }

    public void setCounty(List<String> county) {
        this.county = county;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private void generateRandomImageUrl() {
        String uniqueIdentifier = UUID.randomUUID().toString();
        imageUrl = "https://picsum.photos/seed/" + uniqueIdentifier + "/200/300";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(placeOfPublication);
        dest.writeInt(startYear);
        dest.writeString(publisher);
        dest.writeStringList(county);
        dest.writeString(imageUrl);
    }
}
