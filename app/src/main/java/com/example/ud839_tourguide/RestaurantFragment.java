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
public class RestaurantFragment extends Fragment {

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


    public RestaurantFragment() {
        // Required empty public constructor
        mPlaces = new ArrayList<Place>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        mPlaces.add(new Place(R.drawable.hard_rock_cafe, R.drawable.hard_rock_cafe_large,
                "Hard Rock Cafe", "Oniru Estate, VI",
                R.string.description_hard_rock_cafe, "+2349081988888"));
        mPlaces.add(new Place(R.drawable.shiro_lagos, R.drawable.shiro_lagos_large, "Shiro",
                "Oniru Estate, VI", R.string.description_shiro,
                "+2348186298888"));
        mPlaces.add(new Place(R.drawable.talindo_steak_house, R.drawable.talindo_steak_house_large,
                "Talindo", "Karimu Kotun, VI", R.string.description_talindo,
                "+2348023655880"));
        mPlaces.add(new Place(R.drawable.lafric_restaurant, R.drawable.lafric_restaurant_large,
                "L'afric", "Adeola Hopewell, VI", R.string.description_lafric,
                "+2348130053886"));
        mPlaces.add(new Place(R.drawable.sailors_lounge, R.drawable.sailors_lounge_large,
                "Sailor's Lounge", "Admiralty, Lekki",
                R.string.description_sailors_lounge, "+2348131093308"));
        mPlaces.add(new Place(R.drawable.oceans_basket, R.drawable.oceans_basket_large,
                "Ocean's Basket", "Isaac John Str. Ikeja",
                R.string.description_oceans_basket, "+2348091826777"));
        mPlaces.add(new Place(R.drawable.craft_gourmet, R.drawable.craft_gourmet_large,
                "Craft Gourmet", "Idowu Martins Str. VI",
                R.string.description_craft_gourmet, "+2347032652069"));
        mPlaces.add(new Place(R.drawable.arabesque, R.drawable.arabesque_large, "Arabesque",
                "Etim Inyang, VI", R.string.description_arabesque));
        mPlaces.add(new Place(R.drawable.casper_and_gambini, R.drawable.casper_and_gambini_large,
                "Casper & Gambini", "Agoro Odiyan Str. VI",
                R.string.description_casper_gambini, "+2347002277377"));

        PlaceAdapter adapter = new PlaceAdapter(rootView.getContext(), mPlaces);
        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(mOnItemClickListener);

        return rootView;
    }

}
