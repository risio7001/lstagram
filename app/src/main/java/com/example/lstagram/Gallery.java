package com.example.lstagram;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Adapter.galleryAdapter;

public class Gallery extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        int numOfColumns = 2;
        recyclerView = findViewById(R.id.gallery_recycler);
        recyclerView.setHasFixedSize(true);
        // 몇개까지 나올지 정하기
        recyclerView.setLayoutManager(new GridLayoutManager(this, numOfColumns));
        adapter = new galleryAdapter(arrayList, Gallery.this);
//        adapter = new Adapter(galleryAdapter);



    }
}