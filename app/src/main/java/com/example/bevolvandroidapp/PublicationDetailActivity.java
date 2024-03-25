package com.example.bevolvandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class PublicationDetailActivity extends AppCompatActivity {

    private TextView  publisherTextView, publisherPlaceTextView, yearTextView, toolBarTitle;
    private ImageView imageView, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication_detail);

        publisherTextView = findViewById(R.id.detailPublisher);
        publisherPlaceTextView = findViewById(R.id.detailPublicationPlace);
        yearTextView = findViewById(R.id.detailYear);
        imageView = findViewById(R.id.detailImage);
        backButton = findViewById(R.id.back_icon);
        toolBarTitle = findViewById(R.id.previous_topic);


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("publication")) {
            Publication publication = intent.getParcelableExtra("publication");

            if (publication != null) {
                publisherTextView.setText(publication.getPublisher());
                publisherPlaceTextView.setText(publication.getPlaceOfPublication());
                yearTextView.setText(String.valueOf(publication.getStartYear()));

                Picasso.get().load(publication.getImageUrl())
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

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToHomePage();
            }
        });

    }
    private void navigateToHomePage() {
        Intent intent = new Intent( PublicationDetailActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
