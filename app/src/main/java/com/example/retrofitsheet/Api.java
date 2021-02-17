package com.example.retrofitsheet;


import com.example.retrofitsheet.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
//    https://script.google.com/macros/s/AKfycbxOLElujQcy1-ZUer1KgEvK16gkTLUqYftApjNCM_IRTL3HSuDk/exec?id=159--pHYbfd56xjdLpNau0Db58Qz8L2r8kGf-WY8l8Ww&sheet=Sheet1
    String BASE_URL = "https://script.google.com/macros/s/AKfycbxOLElujQcy1-ZUer1KgEvK16gkTLUqYftApjNCM_IRTL3HSuDk/";
    @GET("exec")
    Call<Model> getmodel(@Query("id") String id, @Query("sheet") String sheet);
//?id=159--pHYbfd56xjdLpNau0Db58Qz8L2r8kGf-WY8l8Ww&sheet=Sheet1
}