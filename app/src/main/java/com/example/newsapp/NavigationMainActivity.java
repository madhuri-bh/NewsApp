package com.example.newsapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.newsapp.adapter.NewsFragmentPagerAdapter;
import com.example.newsapp.utils.Constants;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NavigationMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_navigation_drawer, R.string.close_navigation_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        viewPager = findViewById(R.id.viewpager);

        TabLayout tabLayout = findViewById(R.id.sliding_tab);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        NavigationView navigationView = findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);

        // Set the default fragment when starting the app
        onNavigationItemSelected(navigationView.getMenu().getItem(0).setChecked(true));

        NewsFragmentPagerAdapter newsFragmentPagerAdapter =
                new NewsFragmentPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(newsFragmentPagerAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        int id = menuItem.getItemId();
        //Fragment fragment = null;

        switch (id) {
            case R.id.nav_technology:
                viewPager.setCurrentItem(Constants.TECHNOLOGY);
                break;
            case R.id.nav_science:
                viewPager.setCurrentItem(Constants.SCIENCE);
                break;
            case R.id.nav_business:
                viewPager.setCurrentItem(Constants.BUSINESS);
                break;
            case R.id.nav_health:
                viewPager.setCurrentItem(Constants.HEALTH);
                break;
            case R.id.nav_entertainment:
                viewPager.setCurrentItem(Constants.ENTERTAINMENT);
                break;
            case R.id.nav_general:
                viewPager.setCurrentItem(Constants.GENERAL);
                break;
            case R.id.nav_sports:
                viewPager.setCurrentItem(Constants.SPORTS);
                break;
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

}


