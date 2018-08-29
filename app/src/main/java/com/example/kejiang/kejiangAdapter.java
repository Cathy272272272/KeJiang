package com.example.kejiang;

import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class kejiangAdapter extends RecyclerView.Adapter<kejiangAdapter.ViewHolder>{

    private List<kejiang> mkejiangList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View kejiangView;
        ImageView kejiangImage;
        //TextView kejiangName;

        public ViewHolder(View view) {
            super(view);
            kejiangView = view;
            kejiangImage = (ImageView) view.findViewById(R.id.kejiang_image);
            //kejiangImage.setColorFilter(getContext().getResources().getColor(R.color.blue));
            //kejiangImage.setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.MULTIPLY);
            //kejiangName = (TextView) view.findViewById(R.id.kejiang_name);
        }
    }

    public kejiangAdapter(List<kejiang> kejiangList) {
        mkejiangList = kejiangList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kejiang, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        //int screenWidth = getScreenWidth(this);
        /*int screenWidth =
        ViewGroup.LayoutParams lp = holder.kejiangImage.getLayoutParams();
        lp.width = screenWidth;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        holder.kejiangImage.setLayoutParams(lp);

        holder.kejiangImage.setMaxWidth(screenWidth);
        holder.kejiangImage.setMaxHeight(screenWidth * 5);*/
        /*holder.kejiangView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                kejiang kj = mkejiangList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + kj.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });*/
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        kejiang kejiang = mkejiangList.get(position);
        holder.kejiangImage.setImageResource(kejiang.getImageId());
        //holder.kejiangName.setText(kejiang.getName());
    }

    @Override
    public int getItemCount() {
        return mkejiangList.size();
    }

}
