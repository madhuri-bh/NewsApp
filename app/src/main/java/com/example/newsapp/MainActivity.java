package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_navigation_drawer, R.string.close_navigation_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        //default fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new TechnologyFragment()).commit();

        /*if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TechnologyFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_technology);
        }*/

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //String url = "";
        /*switch (item.getItemId()) {
            case R.id.nav_technology:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new TechnologyFragment()).commit();
                Toast.makeText(this, "Technology", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_science:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ScienceFragment()).commit();
                Toast.makeText(this, "Science", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_business:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new TechnologyFragment()).commit();
                Toast.makeText(this, "Business", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_entertainment:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new TechnologyFragment()).commit();
                Toast.makeText(this, "Entertainment", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }*/
        if (item.getItemId() == R.id.nav_technology) {
            //url = "https://newsapi.org/v2/top-headlines?category=technology&apiKey=aaab4be3710e4ee5beebc7664ac7fb4f";
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TechnologyFragment()).commit();
            Toast.makeText(this, "Technology", Toast.LENGTH_SHORT).show();
        } else  if(item.getItemId() == R.id.nav_business) {
            //url = "https://newsapi.org/v2/top-headlines?category=business&apiKey=aaab4be3710e4ee5beebc7664ac7fb4f";
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ScienceFragment()).commit();
        }
        /*} else if (item.getItemId() == R.id.nav_health) {
            url = "https://newsapi.org/v2/top-headlines?category=health&apiKey=aaab4be3710e4ee5beebc7664ac7fb4f";
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TechnologyFragment()).commit();
        } else if (item.getItemId() == R.id.nav_entertainment) {
            url = "https://newsapi.org/v2/top-headlines?category=entertainment&apiKey=aaab4be3710e4ee5beebc7664ac7fb4f";
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TechnologyFragment()).commit();
        } else if (item.getItemId() == R.id.nav_general) {
            url = "https://newsapi.org/v2/top-headlines?category=general&apiKey=aaab4be3710e4ee5beebc7664ac7fb4f";
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TechnologyFragment()).commit();
        } else {
            url = "https://newsapi.org/v2/top-headlines?category=business&apiKey=aaab4be3710e4ee5beebc7664ac7fb4f";
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new TechnologyFragment()).commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
return true;
    }*/
        drawerLayout.closeDrawer(GravityCompat.START);
return true;
        }

    }



//https://newsapi.org/v2/top-headlines?category=technology&apiKey=aaab4be3710e4ee5beebc7664ac7fb4f
//query parameters
//business entertainment general health science sports technology