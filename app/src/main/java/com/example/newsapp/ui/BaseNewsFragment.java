package com.example.newsapp.ui;

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
import com.example.newsapp.R;
import com.example.newsapp.adapter.NewsAdapter;

import java.util.List;

public class BaseNewsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<News>> {

    private static final String LOG_TAG = BaseNewsFragment.class.getSimpleName();
    private static final int NEWS_LOADER_ID = 1;
    private NewsAdapter newsAdapter;
    private TextView EmptyTextView;
    private ProgressBar LoadingIndicator;
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
                    Toast.makeText(getActivity(), "Refreshed",Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }


    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int id, @Nullable Bundle args) {
        Uri.Builder builder = new
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<News>> loader, List<News> data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<News>> loader) {

    }

    private void restartLoader(boolean isConnected) {

    }

    private void initiateRefresh() {
            restartLoader(isConnected);
    }
}
