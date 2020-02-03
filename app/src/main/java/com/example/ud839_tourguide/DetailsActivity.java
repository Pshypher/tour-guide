package com.example.ud839_tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private static final String EXTRA_PLACE = "com.example.ud839_tour_guide.Place";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Place place = (Place) getIntent().getParcelableExtra(EXTRA_PLACE);

        ImageView imageView = (ImageView) findViewById(R.id.img_tour_attraction);
        TextView name = (TextView) findViewById(R.id.place);
        TextView location = (TextView) findViewById(R.id.location);
        TextView contact = (TextView) findViewById(R.id.contact);
        TextView description = (TextView) findViewById(R.id.description);

        imageView.setImageResource(place.getImageResourceId());
        name.setText(place.getName());
        location.setText(place.getLocation());

        if (place.getContact() != null) {
            contact.setText(place.getContact());
        }
        else {
            contact.setVisibility(View.INVISIBLE);
        }

        description.setText(getString(place.getDescriptionId()));

    }
}
