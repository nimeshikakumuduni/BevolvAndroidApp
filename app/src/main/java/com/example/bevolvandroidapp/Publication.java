package com.example.bevolvandroidapp;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.UUID;

public class Publication implements Parcelable {
    private final List<String> essay;
    private final String placeOfPublication;
    private final int startYear;
    private final String publisher;
    private final List<String> county;
    private final String edition;
    private final String frequency;
    private final String url;
    private final String id;
    private final List<String> subject;
    private final List<String> city;
    private final List<String> language;
    private final String title;
    private final List<String> holdingType;
    private final int endYear;
    private final List<String> altTitle;
    private final List<String> note;
    private final String lccn;
    private final List<String> state;
    private final List<String> place;
    private final String country;
    private final String type;
    private final String titleNormal;
    private final String oclc;
    private String imageUrl;

    protected Publication(Parcel in) {
        essay = in.createStringArrayList();
        placeOfPublication = in.readString();
        startYear = in.readInt();
        publisher = in.readString();
        county = in.createStringArrayList();
        edition = in.readString();
        frequency = in.readString();
        url = in.readString();
        id = in.readString();
        subject = in.createStringArrayList();
        city = in.createStringArrayList();
        language = in.createStringArrayList();
        title = in.readString();
        holdingType = in.createStringArrayList();
        endYear = in.readInt();
        altTitle = in.createStringArrayList();
        note = in.createStringArrayList();
        lccn = in.readString();
        state = in.createStringArrayList();
        place = in.createStringArrayList();
        country = in.readString();
        type = in.readString();
        titleNormal = in.readString();
        oclc = in.readString();
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

    public int getStartYear() {
        return startYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public List<String> getCity() {
        return city;
    }

    public List<String> getLanguage() {
        return language;
    }

    public String getTitle() {
        return title;
    }

    public int getEndYear() {
        return endYear;
    }

    public List<String> getNote() {
        return note;
    }

    public String getCountry() {
        return country;
    }

    public String generateRandomImageUrl() {
        String uniqueIdentifier = UUID.randomUUID().toString();
        imageUrl = "https://picsum.photos/seed/" + uniqueIdentifier + "/200/300";
        return imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(essay);
        dest.writeString(placeOfPublication);
        dest.writeInt(startYear);
        dest.writeString(publisher);
        dest.writeStringList(county);
        dest.writeString(edition);
        dest.writeString(frequency);
        dest.writeString(url);
        dest.writeString(id);
        dest.writeStringList(subject);
        dest.writeStringList(city);
        dest.writeStringList(language);
        dest.writeString(title);
        dest.writeStringList(holdingType);
        dest.writeInt(endYear);
        dest.writeStringList(altTitle);
        dest.writeStringList(note);
        dest.writeString(lccn);
        dest.writeStringList(state);
        dest.writeStringList(place);
        dest.writeString(country);
        dest.writeString(type);
        dest.writeString(titleNormal);
        dest.writeString(oclc);
        dest.writeString(imageUrl);
    }
}
