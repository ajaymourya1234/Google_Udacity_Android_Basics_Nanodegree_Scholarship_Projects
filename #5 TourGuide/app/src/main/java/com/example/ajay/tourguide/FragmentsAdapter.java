package com.example.ajay.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentsAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    public FragmentsAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SightsFragment();
        } else if (position == 1) {
            return new ResortsFragment();
        } else if (position == 2) {
            return new CafesFragment();
        } else
            return new HotelsFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.label_sights);
        } else if (position == 1) {
            return mContext.getString(R.string.label_restaurants);
        } else if (position == 2) {
            return mContext.getString(R.string.label_cafes);
        } else
            return mContext.getString(R.string.label_hotels);

    }
}
