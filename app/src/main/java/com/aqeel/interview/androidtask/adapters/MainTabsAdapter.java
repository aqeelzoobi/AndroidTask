package com.aqeel.interview.androidtask.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.aqeel.interview.androidtask.fragments.FarvouritesFragment;
import com.aqeel.interview.androidtask.fragments.HomeFragment;

public class MainTabsAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    public MainTabsAdapter(FragmentManager fm, int NoofTabs){
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                HomeFragment home = new HomeFragment();
                return home;
            case 1:
                FarvouritesFragment farvouritesFragment = new FarvouritesFragment();
                return farvouritesFragment;

            default:
                return null;
        }
    }
}