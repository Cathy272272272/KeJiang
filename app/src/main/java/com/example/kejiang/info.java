package com.example.kejiang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class info extends AppCompatActivity {

    private List<kejiang> kejiangList = new ArrayList<kejiang>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        init();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        /*StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);*/
        GridLayoutManager layoutManager = new
                GridLayoutManager(this, GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        kejiangAdapter adapter = new kejiangAdapter(kejiangList);
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        kejiang p1 = new kejiang("p1", R.drawable.p1);
        kejiangList.add(p1);
        kejiang p2 = new kejiang("p2", R.drawable.p2);
        kejiangList.add(p2);
        kejiang p3 = new kejiang("p3", R.drawable.p3);
        kejiangList.add(p3);
        kejiang p4 = new kejiang("p4", R.drawable.p4);
        kejiangList.add(p4);
        kejiang p5 = new kejiang("p5", R.drawable.p5);
        kejiangList.add(p5);
        kejiang p6 = new kejiang("p6", R.drawable.p6);
        kejiangList.add(p6);
        kejiang p7 = new kejiang("p7", R.drawable.p7);
        kejiangList.add(p7);
        kejiang p8 = new kejiang("p8", R.drawable.p8);
        kejiangList.add(p8);
        kejiang p9 = new kejiang("p9", R.drawable.p9);
        kejiangList.add(p9);
    }


}

