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
public class MonumentFragment extends Fragment {

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

    public MonumentFragment() {
        // Required empty public constructor
        mPlaces = new ArrayList<Place>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        mPlaces.clear();
        mPlaces.add(new Place(R.drawable.freedom_park, R.drawable.freedom_park_large, "Freedom Park",
                "Broad St, Lagos Island", R.string.description_freedom_park,
                "+2348095006567"));
        mPlaces.add(new Place(R.drawable.mko_abiola, R.drawable.mko_abiola_large, "MKO Abiola",
                "Ojota, Ikeja", R.string.description_mko_abiola));
        mPlaces.add(new Place(R.drawable.queen_amina, R.drawable.queen_amina_large, "Queen Amina",
                "Iganmu, Apapa", R.string.description_queen_amina));
        mPlaces.add(new Place(R.drawable.shitta_bey_mosque, R.drawable.shitta_bey_mosque_large,
                "Shitta Bey", "Martin St, Lagos Island",
                R.string.description_shitta_bey));
        mPlaces.add(new Place(R.drawable.tafawa_balewa_square, R.drawable.tafawa_balewa_square_large,
                "Tafawa Balewa Square", "Bamgboshe, Lagos Island",
                R.string.description_tafawa_balewa_square));
        mPlaces.add(new Place(R.drawable.tinubu_square, R.drawable.tinubu_square_large,
                "Tinubu Square", "Nnamdi Azikwe, Lagos Island",
                R.string.description_tinubu_square));

        PlaceAdapter adapter = new PlaceAdapter(getContext(), mPlaces);
        ListView listView = rootView.findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(mOnItemClickListener);

        return rootView;
    }

}
