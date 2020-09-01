package com.example.newsapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.content.Loader;

import com.example.newsapp.News;
import com.example.newsapp.NewsLoader;
import com.example.newsapp.R;

import java.util.List;

public class HealthFragment extends BaseNewsFragment {
    private static final String LOG_TAG = BusinessFragment.class.getSimpleName();
    private final String healthUrl = "https://newsapi.org/v2/top-headlines?category=health&apiKey=aaab4be3710e4ee5beebc7664ac7fb4f";


    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int id, @Nullable Bundle args) {

        return new NewsLoader(getActivity(), healthUrl);
    }
}
