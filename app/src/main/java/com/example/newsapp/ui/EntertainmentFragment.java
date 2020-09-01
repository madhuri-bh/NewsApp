package com.example.newsapp.ui;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.Loader;
import com.example.newsapp.News;
import com.example.newsapp.NewsLoader;
import java.util.List;

public class EntertainmentFragment extends BaseNewsFragment {
    private static final String LOG_TAG = BusinessFragment.class.getSimpleName();
    private final String entertainmentUrl = "https://newsapi.org/v2/top-headlines?category=entertainment&apiKey=aaab4be3710e4ee5beebc7664ac7fb4f";


    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int id, @Nullable Bundle args) {

        return new NewsLoader(getActivity(), entertainmentUrl);
    }
}