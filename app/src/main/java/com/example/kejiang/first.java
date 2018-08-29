package com.example.kejiang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class first extends AppCompatActivity {
    private static final String TAG = "";

    private List<kejiang> kejiangList = new ArrayList<kejiang>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosth);
        init();
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        /*StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);*/
        GridLayoutManager layoutManager = new
                GridLayoutManager(this, GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        final kejiangAdapter adapter = new kejiangAdapter(dosth.kejiangList);
        recyclerView.setAdapter(adapter);
        Button button = (Button)findViewById(R.id.draw);
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
                recyclerView.setAdapter(adapter);*/
                Intent intent = new Intent(first.this, end.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        /*Log.d(TAG, "hahaha" + dosth.miedeng.length);

        Random random = new Random();
        int num = dosth.size * random.nextInt();
        dosth.size -= num;
        //kejiang tmp = kejiangList.get(idx);
        while ( num-- > 0 ) {
            int idx = (int)(5 * random.nextDouble());
            Toast.makeText(this, "" + idx, Toast.LENGTH_LONG).show();
            while ( true ) {
                if ( dosth.miedeng[idx] ) {
                    if ( idx == 4 ) idx = 0;
                    else idx++;
                }
                else {
                    dosth.miedeng[idx] = true;
                    break;
                }
            }
            //dosth.kejiangList.remove(idx);
            kejiang tmp = new kejiang("banana_pic", R.drawable.banana_pic);
            dosth.kejiangList.set(idx, tmp);
        }
        //kejiang apple = new kejiang("apple_pic", random.nextInt() > 0.5 ? R.drawable.apple_pic : R.drawable.banana_pic);
        //dosth.kejiangList.add(apple);*/
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

