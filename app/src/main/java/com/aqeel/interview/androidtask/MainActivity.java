package com.aqeel.interview.androidtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.aqeel.interview.androidtask.adapters.MainTabsAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout bottomTabLayout;
    MainTabsAdapter tabsAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTabs();
        setViewPager();
        setListeners();
    }

    private void setTabs() {
         bottomTabLayout = findViewById(R.id.bottom_tab); // get the reference of TabLayout
        TabLayout.Tab firstTab = bottomTabLayout.newTab(); // Create a new Tab names "First Tab"
        firstTab.setText("Home"); // set the Text for the first Tab
        firstTab.setIcon(R.drawable.ic_baseline_home_24);// set an icon for the first tab
        bottomTabLayout.addTab(firstTab, true); // add  the tab at specified position in the TabLayout and makes it selectable
        TabLayout.Tab tabTwo = bottomTabLayout.newTab(); // Create a new Tab names "First Tab"
        tabTwo.setText("Favourites"); // set the Text for the first Tab
        tabTwo.setIcon(R.drawable.ic_baseline_star_border_24);
        // set an icon for the first tab
        bottomTabLayout.addTab(tabTwo, false);
    }

    private void setViewPager()
    {
        viewPager = findViewById(R.id.viewpager_main);
        tabsAdapter = new MainTabsAdapter(getSupportFragmentManager(), bottomTabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);

    }
    private void setListeners()
    {
     viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
         @Override
         public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

         }

         @Override
         public void onPageSelected(int position) {

         }

         @Override
         public void onPageScrollStateChanged(int state) {

         }
     });

     bottomTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
         @Override
         public void onTabSelected(TabLayout.Tab tab) {
             viewPager.setCurrentItem(tab.getPosition());
         }

         @Override
         public void onTabUnselected(TabLayout.Tab tab) {

         }

         @Override
         public void onTabReselected(TabLayout.Tab tab) {

         }
     });
    }
}