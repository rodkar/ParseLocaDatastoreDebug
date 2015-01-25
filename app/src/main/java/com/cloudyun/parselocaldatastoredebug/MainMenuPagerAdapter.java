package com.cloudyun.parselocaldatastoredebug;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by 2013_13_mbp on 23/1/15.
 */
public class MainMenuPagerAdapter extends FragmentPagerAdapter {

    public static int NUM_ITEMS = 1;

    public MainMenuPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            TestObjectListFragment testObjectListFragment = new TestObjectListFragment();
            return testObjectListFragment;
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return App.getmContext().getResources().getString(R.string.menu_tab_title);
        } else {
            return null;
        }
    }
}
