package com.example.newsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.News;
import com.example.newsapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<News> newsList;

    public NewsAdapter(@NonNull Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final News currentNews = newsList.get(position);
        holder.sourceTv.setText(currentNews.getSource());
        holder.titleTv.setText(currentNews.getTitle());
        holder.descriptionTv.setText(currentNews.getDescription());
        holder.urlTv.setText(currentNews.getUrl());
        Glide.with(context.getApplicationContext())
                .load(currentNews.getUrlToImage())
                .into(holder.imageIv);
        holder.publishedAtTv.setText(formatDate(currentNews.getPublishedAt()));
        holder.contentTv.setText(currentNews.getContent());

    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView sourceTv;
        private TextView titleTv;
        private TextView descriptionTv;
        private TextView urlTv;
        private ImageView imageIv;
        private TextView publishedAtTv;
        private TextView contentTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sourceTv = itemView.findViewById(R.id.text_source);
            titleTv = itemView.findViewById(R.id.text_title);
            descriptionTv = itemView.findViewById(R.id.text_description);
            urlTv = itemView.findViewById(R.id.text_url);
            imageIv = itemView.findViewById(R.id.url_to_image);
            publishedAtTv = itemView.findViewById(R.id.text_published);
            contentTv = itemView.findViewById(R.id.text_content);
        }
    }

    private String formatDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateObject = null;
        try {
            dateObject = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateObject.toString();
    }

    public void clearAll() {
        newsList.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<News> newsList) {
        newsList.clear();
        newsList.addAll(newsList);
        notifyDataSetChanged();
    }
}
