package com.example.bevolvandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PublicationAdapter extends ArrayAdapter<Publication> {

    public PublicationAdapter(@NonNull Context context, @NonNull List<Publication> publications) {
        super(context, 0, publications);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Publication publication = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.publication_item, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView publisherTextView = convertView.findViewById(R.id.publisherTextView);
        ImageView imageView = convertView.findViewById(R.id.listImage);

        titleTextView.setText(publication.getPublisher());
        publisherTextView.setText(publication.getPublisher());
        Picasso.get().load(publication.getImageUrl())
                .placeholder(R.drawable.prev)
                .error(R.drawable.error)
                .into(imageView);

        return convertView;
    }
}
