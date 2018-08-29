package com.example.kejiang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class end extends AppCompatActivity {

    public static List<kejiang> kejiangList = new ArrayList<kejiang>();
    public static boolean[] miedeng = new boolean[24];
    public static int size = 24;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        //ImageView imageView = (ImageView)findViewById(R.id.imageView);
        kejiangList.clear();
        init();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        /*StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);*/
        GridLayoutManager layoutManager = new
                GridLayoutManager(this, GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        final kejiangAdapter adapter = new kejiangAdapter(kejiangList);
        recyclerView.setAdapter(adapter);
        /*Button button = (Button)findViewById(R.id.draw);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int size = kejiangList.size();
                Random random = new Random();
                int idx = size * random.nextInt();
                //kejiang tmp = kejiangList.get(idx);
                kejiangList.remove(idx);
                kejiang tmp = new kejiang("banana_pic", R.drawable.banana_pic);
                kejiangList.add(idx, tmp);
                recyclerView.setAdapter(adapter);
                //Intent intent = new Intent(dosth.this, end.class);
                //startActivity(intent);
            }
        });
*/
    }

    private void init() {
        //kejiang apple = new kejiang("apple_pic", R.drawable.apple_pic);
        //kejiangList.add(apple);
        Random random = new Random();
        if ( random.nextDouble() < 0.1 ) {
            kejiang p1 = new kejiang("p1", R.drawable.p1);
            kejiangList.add(p1);
            return;
        }
        if ( random.nextDouble() < 0.1 ) {
            kejiang p1 = new kejiang("p1", R.drawable.p2);
            kejiangList.add(p1);
            return;
        }
        if ( random.nextDouble() < 0.1 ) {
            kejiang p1 = new kejiang("p1", R.drawable.p3);
            kejiangList.add(p1);
            return;
        }
        if ( random.nextDouble() < 0.1 ) {
            kejiang p1 = new kejiang("p1", R.drawable.p4);
            kejiangList.add(p1);
            return;
        }
        if ( random.nextDouble() < 0.1 ) {
            kejiang p1 = new kejiang("p1", R.drawable.p5);
            kejiangList.add(p1);
            return;
        }
        if ( random.nextDouble() < 0.1 ) {
            kejiang p1 = new kejiang("p1", R.drawable.p6);
            kejiangList.add(p1);
            return;
        }
        if ( random.nextDouble() < 0.1 ) {
            kejiang p1 = new kejiang("p1", R.drawable.p7);
            kejiangList.add(p1);
            return;
        }        if ( random.nextDouble() < 0.1 ) {
            kejiang p1 = new kejiang("p1", R.drawable.p8);
            kejiangList.add(p1);
            return;
        }
        kejiang p1 = new kejiang("p1", R.drawable.p9);
        kejiangList.add(p1);
        //int idx = (int)(9 * random.nextDouble());
        /*kejiang p1 = new kejiang("p1", random.nextDouble() > 0.5 ? R.drawable.p1 : R.drawable.p10);
        kejiangList.add(p1);
        kejiang p2 = new kejiang("p2", random.nextDouble() > 0.5 ? R.drawable.p2 : R.drawable.p11);
        kejiangList.add(p2);
        kejiang p3 = new kejiang("p3", random.nextDouble() > 0.5 ? R.drawable.p3 : R.drawable.p12);
        kejiangList.add(p3);
        kejiang p4 = new kejiang("p4", random.nextDouble() > 0.5 ? R.drawable.p4 : R.drawable.p13);
        kejiangList.add(p4);
        kejiang p5 = new kejiang("p5", random.nextDouble() > 0.5 ? R.drawable.p5 : R.drawable.p14);
        kejiangList.add(p5);
        kejiang p6 = new kejiang("p6", random.nextDouble() > 0.5 ? R.drawable.p6 : R.drawable.p15);
        kejiangList.add(p6);
        kejiang p7 = new kejiang("p7", random.nextDouble() > 0.5 ? R.drawable.p7 : R.drawable.p16);
        kejiangList.add(p7);
        kejiang p8 = new kejiang("p8", random.nextDouble() > 0.5 ? R.drawable.p8 : R.drawable.p17);
        kejiangList.add(p8);
        kejiang p9 = new kejiang("p9", random.nextDouble() > 0.5 ? R.drawable.p9 : R.drawable.p18);
        kejiangList.add(p9);*/
        /*kejiang p10 = new kejiang("p10", R.drawable.p10);
        kejiangList.add(p10);
        kejiang p11 = new kejiang("p11", R.drawable.p11);
        kejiangList.add(p11);
        kejiang p12 = new kejiang("p12", R.drawable.p12);
        kejiangList.add(p12);
        kejiang p13 = new kejiang("p13", R.drawable.p13);
        kejiangList.add(p13);
        kejiang p14 = new kejiang("p14", R.drawable.p14);
        kejiangList.add(p14);
        kejiang p15 = new kejiang("p15", R.drawable.p15);
        kejiangList.add(p15);
        kejiang p16 = new kejiang("p16", R.drawable.p16);
        kejiangList.add(p16);
        kejiang p17 = new kejiang("p17", R.drawable.p17);
        kejiangList.add(p17);
        kejiang p18 = new kejiang("p18", R.drawable.p18);
        kejiangList.add(p18);
        kejiang p19 = new kejiang("p19", R.drawable.p19);
        kejiangList.add(p19);
        kejiang p20 = new kejiang("p20", R.drawable.p20);
        kejiangList.add(p20);
        kejiang p21 = new kejiang("p21", R.drawable.p21);
        kejiangList.add(p21);
        kejiang p22 = new kejiang("p22", R.drawable.p22);
        kejiangList.add(p22);
        kejiang p23 = new kejiang("p23", R.drawable.p23);
        kejiangList.add(p23);
        kejiang p24 = new kejiang("p24", R.drawable.p24);
        kejiangList.add(p24);*/
    }


}

