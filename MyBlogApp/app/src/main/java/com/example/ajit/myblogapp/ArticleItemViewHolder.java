package com.example.ajit.myblogapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ajit on 16/3/17.
 */

public class ArticleItemViewHolder extends RecyclerView.ViewHolder {

    public TextView articleName;
    public CardView cardView;

    public ArticleItemViewHolder(View itemView) {
        super(itemView);
        articleName = (TextView) itemView.findViewById(R.id.articleOne);
        cardView = (CardView) itemView.findViewById(R.id.cardView);
    }
}



