package com.cloudyun.parselocaldatastoredebug;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.cloudyun.parselocaldatastoredebug.slidingtabs.SlidingTabLayout;


public class MainActivity extends ActionBarActivity {

    MainMenuPagerAdapter mainMenuPagerAdapter;
    ViewPager viewPager;
    SlidingTabLayout slidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainMenuPagerAdapter = new MainMenuPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(mainMenuPagerAdapter);

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        slidingTabLayout.setViewPager(viewPager);
    }
}
