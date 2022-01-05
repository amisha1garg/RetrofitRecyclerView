package com.ford.retrofitrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    ArrayList<Marvel> movieInfo1;
    Context context;
    View view;

    public MyAdapter (Context ct, ArrayList<Marvel> movieInfo){
        movieInfo1 = movieInfo;
        context = ct;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.movieInfoText.setText(movieInfo1.get(position).toString());


    }

    @Override
    public int getItemCount() {
        return movieInfo1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView movieInfoText;
        TextView movieBio;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            movieInfoText = itemView.findViewById(R.id.movie_info_text_view);


        }
    }
}
