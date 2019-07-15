package com.example.chaurideuralimunicipality.Adaptors;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class WardDetailsPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> mlist = new ArrayList<>();

    public WardDetailsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        return mlist.get(i);

    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    public void addFragment(Fragment fragment){

        mlist.add(fragment);   //adding fragment to arraylist sending from warddetailsactivity
    }
}
