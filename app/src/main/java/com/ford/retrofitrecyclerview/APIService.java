package com.ford.retrofitrecyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("marvel")
    Call<List<Marvel>> getInfos();
}
