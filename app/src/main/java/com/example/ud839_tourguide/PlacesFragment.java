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
public class PlacesFragment extends Fragment {

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


    public PlacesFragment() {
        // Required empty public constructor
        mPlaces = new ArrayList<Place>();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        mPlaces.add(new Place(R.drawable.nike_art_center, R.drawable.nike_art_center_large,
                "Nike Art Center", "Phase 1, Lekki",
                R.string.description_nikes_art_center, "+2348034096656"));
        mPlaces.add(new Place(R.drawable.national_museum, R.drawable.national_museum_large,
                "National Museum", "Onikan,Lagos Island",
                R.string.description_national_museum, "+23412636005"));
        mPlaces.add(new Place(R.drawable.new_afrika_shrine, R.drawable.new_afrika_shrine_large,
                "New Afrika Shrine", "Agidingbi, Ikeja",
                R.string.description_new_afrika_shrine, "+2348037125939"));
        mPlaces.add(new Place(R.drawable.scoan, R.drawable.scoan_large,
                "Synagogue", "Egbe Rd, Egbe",
                R.string.description_scoan, "+2348077679597"));

        mPlaces.add(new Place(R.drawable.terra_kulture, R.drawable.terra_kulture_large,
                "Terra Kulture", "Tiamiyu Savage, VI",
                R.string.description_terra_kulture, "+2348104224137"));

        mPlaces.add(new Place(R.drawable.ikeja_city_mall, R.drawable.ikeja_city_mall_large,
                "Ikeja City Mall", "Alausa, Ikeja",
                R.string.description_icm, "+2348068582039"));

        mPlaces.add(new Place(R.drawable.club_quilox, R.drawable.club_quilox_large, "Club Quilox",
                "Victoria Island", R.string.description_quilox));

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), mPlaces);
        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(mOnItemClickListener);

        return rootView;
    }

}
