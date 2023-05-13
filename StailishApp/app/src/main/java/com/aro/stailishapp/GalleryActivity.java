package com.aro.stailishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

import API.ApiInterface;
import API.ServiceGenerator;
import Model.GalleryItem;
import Model.GalleryItemAdapter;
import Model.Mensaje;
import Model.MensajeAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ArrayList<GalleryItem> arrayList = new ArrayList<>();
        GridView gridView = findViewById(R.id.grid_view);


        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);

        ArrayList<String> arrLinks = new ArrayList<String>();

        Call<ArrayList<String>> call = apiInterface.getUrls();
        call.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                for (int i = 0; i < response.body().size(); i = i + 1) {
                    arrayList.add(new GalleryItem(response.body().get(i)));
                    GalleryItemAdapter adapter = new GalleryItemAdapter(getApplicationContext(), R.layout.grid_item, arrayList);
                    gridView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                Log.e("tag", t.getMessage());
            }
        });
    }
}