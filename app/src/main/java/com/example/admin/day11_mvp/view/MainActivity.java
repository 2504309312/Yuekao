package com.example.admin.day11_mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.admin.day11_mvp.R;
import com.example.admin.day11_mvp.adapter.MyRecyclerAdapter;
import com.example.admin.day11_mvp.model.User;
import com.example.admin.day11_mvp.presenter.BackListener;
import com.example.admin.day11_mvp.presenter.Presenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BackListener{

    private RecyclerView recycler;
    private String path = "http://172.16.54.6:8080/jsonstring/q.txt";
    private List<User.LiveBean> mLive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
  
        initData();

    }

    private void initData() {

        Presenter presenter = new Presenter(MainActivity.this);
        presenter.GetModeldate(path);



    }

    private void initView() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
    }

    @Override
    public void onsuccess(User user) {

        mLive = user.getLive();

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        recycler.setLayoutManager(staggeredGridLayoutManager);

        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(mLive, MainActivity.this);

        recycler.setAdapter(myRecyclerAdapter);


    }

    @Override
    public void onshibai(String string) {

    }
}
