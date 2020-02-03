package com.example.ud839_tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;



import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NatureFragment extends Fragment {

    private ArrayList<Place> mPlaces;
    private ListView.OnItemClickListener mOnItemClickListener =
            new ListView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Place place = mPlaces.get(position);
                    Intent intent = new Intent(getContext(), DetailsActivity.class);
                    intent.putExtra(EXTRA_PLACE, place);
                    startActivity(intent);
                }
            };

    private static final String EXTRA_PLACE = "com.example.ud839_tour_guide.Place";


    public NatureFragment() {
        // Required empty public constructor

        mPlaces = new ArrayList<Place>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        mPlaces.add(new Place(R.drawable.lekki_conservation, R.drawable.lekki_conservation_large,
                "Lekki Conservation Centre", "Lekki Penninsula, Lekki",
                R.string.description_lekki_conservation));
        mPlaces.add(new Place(R.drawable.tarkwa_bay, R.drawable.tarkwa_bay_large, "Tarkwa Bay Beach",
                "Lagos harbour", R.string.description_tarkwa_bay));
        mPlaces.add(new Place(R.drawable.atican_beach, R.drawable.atican_beach_large, "Atican Beach",
                "Ajah Town, Lekki", R.string.description_atican));
        mPlaces.add(new Place(R.drawable.lufasi, R.drawable.lufasi_large, "Lufasi Nature Park",
                "Eti-Osa, Lekki", R.string.lufasi));
        mPlaces.add(new Place(R.drawable.green_fingers_wi, R.drawable.green_fingers_large,
                "Greenfingers Wildlife Conservation", "Sangotedo",
                R.string.description_greenfingers));
        mPlaces.add(new Place(R.drawable.lekki_leisure_lake, R.drawable.lekki_leisure_lake_large,
                "Lekki Leisure Lake", "Phase I, Lekki", R.string.lekki_leisure_lake));

        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        PlaceAdapter adapter = new PlaceAdapter(getContext(), mPlaces);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(mOnItemClickListener);

        return rootView;
    }
}
