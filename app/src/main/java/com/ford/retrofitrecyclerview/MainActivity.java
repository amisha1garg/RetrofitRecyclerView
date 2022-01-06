package com.ford.retrofitrecyclerview;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private APIService apiService;
    private RecyclerView recyclerView;
    static ArrayList<Marvel> movieInfo;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);

        Gson gson = new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor loggingInterceptor= new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

       apiService = retrofit.create(APIService.class);

        getMarvels();
//        createMarvels();
//        updateMarvel();
//        deleteMarvel();


    }

    private void getMarvels()
    {
        Call<List<Marvel>> call = apiService.getInfos();

        call.enqueue(new Callback<List<Marvel>>() {
            @Override
            public void onResponse(Call<List<Marvel>> call, Response<List<Marvel>> response) {

                List <Marvel> Marvels = response.body();
                movieInfo = new ArrayList<Marvel>();
                for (Marvel marvel:Marvels)
                {

                    movieInfo.add(new Marvel(marvel.getName(),
                            marvel.getRealname(),
                            marvel.getTeam(),
                            marvel.getFirstappearance(),
                            marvel.getCreatedby(),
                            marvel.getPublisher(),
                            marvel.getBio(),
                            marvel.getImageurl()));
                }
                createRecyclerView();
            }
            @Override
            public void onFailure(Call<List<Marvel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "failed to retrieve data\ncheck your internet connection", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void createRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(this, movieInfo);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
