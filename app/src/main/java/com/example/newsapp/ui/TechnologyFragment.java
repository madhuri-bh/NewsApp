package com.example.newsapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.newsapp.R;


public class TechnologyFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.technology_fragment, container, false);
        final TextView sourceTv = rootView.findViewById(R.id.text_source);
        final TextView titleTv = rootView.findViewById(R.id.text_title);
        final TextView descriptionTv = rootView.findViewById(R.id.text_description);
        final TextView urlTv = rootView.findViewById(R.id.text_url);
        final ImageView urlToImage = rootView.findViewById(R.id.text_url_to_image);
        final TextView publishedAtTv = rootView.findViewById(R.id.text_published);
        final TextView contentTv = rootView.findViewById(R.id.text_content);
        return rootView;

    }

}