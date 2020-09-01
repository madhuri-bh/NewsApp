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

public class BusinessFragment extends BaseNewsFragment {

    private static final String LOG_TAG = BusinessFragment.class.getSimpleName();
    private final String businessUrl = "https://newsapi.org/v2/top-headlines?category=business&apiKey=aaab4be3710e4ee5beebc7664ac7fb4f";


    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int id, @Nullable Bundle args) {

        return new NewsLoader(getActivity(), businessUrl);
    }

    /*public class EntertainmentFragment extends Fragment {
        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.entertainment_fragment, container, false);
            final TextView textView = root.findViewById(R.id.text_entertainment);
            return root;
        }
    }*/
}
