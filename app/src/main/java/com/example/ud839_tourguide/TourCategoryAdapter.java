package com.example.ud839_tourguide;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TourCategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public TourCategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new PlacesFragment();
                break;
            case 1:
                fragment = new RestaurantFragment();
                break;
            case 2:
                fragment = new MonumentFragment();
                break;
            case 3:
                fragment = new NatureFragment();
                break;
            default:
                fragment = null;
        }

        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title;
        switch (position) {
            case 0:
                title = mContext.getString(R.string.category_places);
                break;
            case 1:
                title = mContext.getString(R.string.category_restaurants);
                break;
            case 2:
                title = mContext.getString(R.string.category_monuments);
                break;
            case 3:
                title = mContext.getString(R.string.category_nature);
                break;
            default:
                title = null;
        }

        return title;

    }
}
