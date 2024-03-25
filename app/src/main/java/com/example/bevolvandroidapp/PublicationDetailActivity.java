package com.example.bevolvandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class PublicationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication_detail);

        TextView start = findViewById(R.id.startYear);
        TextView end = findViewById(R.id.endYear);
        TextView title = findViewById(R.id.detailTitle);
        TextView publisher = findViewById(R.id.detailPublisher);
        TextView placeOfPublication = findViewById(R.id.detailPlaceOfPublication);
        TextView city = findViewById(R.id.detailCity);
        TextView country = findViewById(R.id.detailCountry);
        TextView language = findViewById(R.id.detailLang);
        TextView holdingType = findViewById(R.id.detailHolding);
        ImageView imageView = findViewById(R.id.detailImage);
        ImageView backButton = findViewById(R.id.back_icon);


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("publication")) {
            Publication publication = intent.getParcelableExtra("publication");

            if (publication != null) {
                int startYearValue = publication.getStartYear();
                start.setText(startYearValue != 0 ? String.valueOf(startYearValue) : "N/A");
                int endYearValue = publication.getEndYear();
                end.setText(endYearValue != 0 ? String.valueOf(endYearValue) : "N/A");
                title.setText(publication.getTitle());
                publisher.setText(publication.getPublisher().replaceAll("[\\[\\]]", ""));
                placeOfPublication.setText(publication.getPlaceOfPublication());
                city.setText(String.valueOf(publication.getCity()).replaceAll("[\\[\\]]", ""));
                country.setText(publication.getCountry());
                language.setText(String.valueOf(publication.getLanguage()).replaceAll("[\\[\\]]", ""));
                holdingType.setText(String.valueOf(publication.getNote()).replaceAll("[\\[\\]]", ""));

                Picasso.get().load(publication.generateRandomImageUrl())
                        .placeholder(R.drawable.prev)
                        .error(R.drawable.error)
                        .into(imageView);
            } else {
                Toast.makeText(this, "Publication data is null", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            Toast.makeText(this, "Intent or publication data missing", Toast.LENGTH_SHORT).show();
            finish();
        }

        backButton.setOnClickListener(view -> navigateToHomePage());

    }
    private void navigateToHomePage() {
        Intent intent = new Intent( PublicationDetailActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
