package com.example.bevolvandroidapp;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class PublicationDetailActivity extends AppCompatActivity {

    private  TextView nameTextView, publisherTextView, publisherPlaceTextView, yearTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        nameTextView = findViewById(R.id.publicationDetail);
        publisherTextView = findViewById(R.id.detailPublisher);
        publisherPlaceTextView = findViewById(R.id.detailPublicationPlace);
        yearTextView = findViewById(R.id.detailYear);
        imageView = findViewById(R.id.detailImage);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String publisher = intent.getStringExtra("publisher");
            String publicationPlace = intent.getStringExtra("publicationPlace");
            String year = intent.getStringExtra("year");
            String imageUrl = intent.getStringExtra("imageUrl");

            // Set data to views
            nameTextView.setText(name);
            publisherTextView.setText(publisher);
            publisherPlaceTextView.setText(publicationPlace);
            yearTextView.setText(year);

            // Load image using Picasso/Glide
            Picasso.get().load(imageUrl)
                .placeholder(R.drawable.prev)
                .error(R.drawable.error)
                .into(imageView);
    }}
}



