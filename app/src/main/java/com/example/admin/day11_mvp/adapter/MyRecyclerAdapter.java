package com.example.admin.day11_mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.day11_mvp.R;
import com.example.admin.day11_mvp.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by admin on 2018/3/20.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private List<User.LiveBean> mLive;
    private Context mContext;

    public MyRecyclerAdapter(List<User.LiveBean> live, Context context) {
        mLive = live;
        mContext = context;
    }

    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.ViewHolder holder, int position) {

        holder.mTv.setText(mLive.get(position).getTitle());
        Picasso.with(mContext).load(mLive.get(position).getImage()).into(holder.mImg);

    }

    @Override
    public int getItemCount() {
        return mLive.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTv;
        private final ImageView mImg;

        public ViewHolder(View itemView) {
            super(itemView);

            mTv = itemView.findViewById(R.id.tv);
            mImg = itemView.findViewById(R.id.img);

        }
    }
}
