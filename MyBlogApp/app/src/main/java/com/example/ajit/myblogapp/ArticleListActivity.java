package com.example.ajit.myblogapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
    ArticleListAdapter articleListAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        articleListAdapter= new  ArticleListAdapter();
        recyclerView = (RecyclerView)findViewById(R.id.recylerview);
        recyclerView.setAdapter(articleListAdapter);
        //step_2 linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         progressDialog= new ProgressDialog(this);
        progressDialog.setMessage("Fetching Articles");
        progressDialog.show();

        ApiManager.getApiInterface().getArticles().enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                progressDialog.dismiss();
             if(response.isSuccessful()){

               articleListAdapter.setData(response.body());
             }
                else {
                 Toast.makeText(ArticleListActivity.this,"Failed ",Toast.LENGTH_LONG).show();
             }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {

            }
        });

    }
    public class ArticleListAdapter extends RecyclerView.Adapter<ArticleItemViewHolder>{
        List<Article> articleList = new ArrayList<>();

        @Override
        public ArticleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //Infalting
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_article,parent,false);

            return new ArticleItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ArticleItemViewHolder holder, int position) {
            //item nstore
            holder.articleName.setText(articleList.get(position).getHeading());
        }

        @Override
        public int getItemCount() {
            return articleList.size();
        }
        public void setData(List<Article> data ){
            this.articleList=data;
            this.notifyDataSetChanged();

        }
    }
}
