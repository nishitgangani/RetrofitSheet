package com.example.retrofitsheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitsheet.Model.Model;
import com.example.retrofitsheet.Model.Sheet1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    ArrayList<Sheet1> Sheet1 = new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        model = new Model();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<Model> call = api.getmodel("159--pHYbfd56xjdLpNau0Db58Qz8L2r8kGf-WY8l8Ww","Sheet1");

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                model = response.body();

//                for (int i = 0; i < response.body().size(); i++) {
//                    model.add(new Model(response.body().get(i).getId(),
//                            response.body().get(i).getName(),
//                            response.body().get(i).getUsername(),
//                            response.body().get(i).getEmail(),
//                            response.body().get(i).getAddress(),
//                            response.body().get(i).getPhone(),
//                            response.body().get(i).getWebsite(),
//                            response.body().get(i).getCompany()));
//                }
//                Log.e("main", "onResponse: --" + response.body().get);

                Sheet1.addAll(model.getSheet1());
                myAdapter = new MyAdapter(MainActivity.this,Sheet1);
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });

    }
}