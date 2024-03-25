package com.example.bevolvandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class PublicationDetailActivity extends AppCompatActivity {

    private TextView nameTextView, publisherTextView, publisherPlaceTextView, yearTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication_detail);

        nameTextView = findViewById(R.id.publicationDetail);
        publisherTextView = findViewById(R.id.detailPublisher);
        publisherPlaceTextView = findViewById(R.id.detailPublicationPlace);
        yearTextView = findViewById(R.id.detailYear);
        imageView = findViewById(R.id.detailImage);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("publication")) {
            Publication publication = intent.getParcelableExtra("publication");

            if (publication != null) {
                // Set data to views
                nameTextView.setText(publication.getPublisher());
                publisherTextView.setText(publication.getPlaceOfPublication());
                publisherPlaceTextView.setText(publication.getPublisher());
                yearTextView.setText(String.valueOf(publication.getStartYear()));

                // Load image using Picasso/Glide
                Picasso.get().load(publication.getImageUrl())
                        .placeholder(R.drawable.prev)
                        .error(R.drawable.error)
                        .into(imageView);
            } else {
                // Handle case where publication object is null
                Toast.makeText(this, "Publication data is null", Toast.LENGTH_SHORT).show();
                finish(); // Close the activity
            }
        } else {
            // Handle case where intent or publication extra is missing
            Toast.makeText(this, "Intent or publication data missing", Toast.LENGTH_SHORT).show();
            finish(); // Close the activity
        }
    }


}
