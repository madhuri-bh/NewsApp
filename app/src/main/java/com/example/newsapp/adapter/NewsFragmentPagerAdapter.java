package com.example.newsapp.adapter;

import android.content.Context;

import com.example.newsapp.R;
import com.example.newsapp.ui.BusinessFragment;
import com.example.newsapp.ui.EntertainmentFragment;
import com.example.newsapp.ui.GeneralFragment;
import com.example.newsapp.ui.HealthFragment;
import com.example.newsapp.ui.ScienceFragment;
import com.example.newsapp.ui.SportsFragment;
import com.example.newsapp.ui.TechnologyFragment;
import com.example.newsapp.utils.Constants;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class NewsFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public NewsFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Constants.TECHNOLOGY:
                return new TechnologyFragment();
            case Constants.SCIENCE:
                return new ScienceFragment();
            case Constants.BUSINESS:
                return new BusinessFragment();
            case Constants.HEALTH:
                return new HealthFragment();
            case Constants.ENTERTAINMENT:
                return new EntertainmentFragment();
            case Constants.GENERAL:
                return new GeneralFragment();
            case Constants.SPORTS:
                return new SportsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
int titleId;
       switch (position) {
           case Constants.TECHNOLOGY:
               titleId = R.string.title_technology;
               break;
           case Constants.SCIENCE:
               titleId = R.string.title_science;
               break;
           case Constants.BUSINESS:
               titleId = R.string.title_business;
               break;
           case Constants.HEALTH:
               titleId = R.string.title_health;
               break;
           case Constants.ENTERTAINMENT:
               titleId = R.string.title_entertainment;
               break;
           case Constants.GENERAL:
               titleId = R.string.title_general;
               break;
           case Constants.SPORTS:
               titleId = R.string.title_sports;
               break;
           default:
               return null;
       }
       return mContext.getString(titleId);
    }
}
