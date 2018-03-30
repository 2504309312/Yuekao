package com.example.admin.day11_mvp.presenter;

import com.example.admin.day11_mvp.view.MainActivity;
import com.example.admin.day11_mvp.model.Model;
import com.example.admin.day11_mvp.model.User;

/**
 * Created by admin on 2018/3/20.
 */

public class Presenter {

    public BackListener mBackListener;

    public Presenter(MainActivity mainActivity){

        this.mBackListener = mainActivity;

    }

    public void GetModeldate(String url){
        Model.getInstance().Myokhttp(url, new Model.GetModelListener() {
            @Override
            public void getModeldata(User user) {

                mBackListener.onsuccess(user);

            }
        });
    }

}
