package com.example.newsapp.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.newsapp.EmptyRecyclerView;
import com.example.newsapp.News;
import com.example.newsapp.NewsLoader;
import com.example.newsapp.R;
import com.example.newsapp.adapter.NewsAdapter;
import com.example.newsapp.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class BaseNewsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<News>> {

    private static final String LOG_TAG = BaseNewsFragment.class.getSimpleName();
    private static final int NEWS_LOADER_ID = 1;
    private NewsAdapter newsAdapter;
    private TextView emptyTextView;
    private ProgressBar loadingIndicator;
    private SwipeRefreshLayout swipeRefreshLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fragment, container, false);
        EmptyRecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.i(LOG_TAG, "onRefresh called from SwipeRefreshLayout");
                initiateRefresh();
                Toast.makeText(getActivity(), "Refreshed", Toast.LENGTH_SHORT).show();
            }
        });

        loadingIndicator = view.findViewById(R.id.loading_indicator);
        emptyTextView = view.findViewById(R.id.empty_view);
        recyclerView.setEmptyView(emptyTextView);

        newsAdapter = new NewsAdapter(getContext(), new ArrayList<News>());
        recyclerView.setAdapter(newsAdapter);

        initializeLoader(isConnected());
        return view;
    }

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int id, @Nullable Bundle args) {
        return new NewsLoader(this.getActivity(), Constants.NEWS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<News>> loader, List<News> newsData) {
        loadingIndicator.setVisibility(View.GONE);
        emptyTextView.setText("No news found");
        newsAdapter.clearAll();
        if (newsData != null && !newsData.isEmpty()) {
            newsAdapter.addAll(newsData);
        }
        //swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<News>> loader) {
        newsAdapter.clearAll();
    }

    @Override
    public void onResume() {
        super.onResume();
        restartLoader(isConnected());
    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    private void initializeLoader(boolean isConnected) {
        if (isConnected) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {
            loadingIndicator.setVisibility(View.GONE);
            emptyTextView.setText("You are offline. Please check your internet connection.");
        }
    }

    private void restartLoader(boolean isConnected) {
        if (isConnected) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {
            loadingIndicator.setVisibility(View.GONE);
            emptyTextView.setText("You are offline. Please check your internet connection.");
            swipeRefreshLayout.setVisibility(View.GONE);
        }
    }

    private void initiateRefresh() {
        restartLoader(isConnected());
    }
}
