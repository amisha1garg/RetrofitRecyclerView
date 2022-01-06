package com.ford.retrofitrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Marvel> movieInfo1;
    Context context;
    View view;
    String url;

    public MyAdapter(Context ct, ArrayList<Marvel> movieInfo) {
        movieInfo1 = movieInfo;
        context = ct;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.movieInfoText.setText(movieInfo1.get(position).toString());
        url = movieInfo1.get(position).getImageurl();

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.mipmap.ic_launcher_round)
                .circleCrop();

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return movieInfo1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView movieInfoText;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            movieInfoText = itemView.findViewById(R.id.movie_info_text_view);
            imageView = itemView.findViewById(R.id.action_image1);


        }
    }
}
