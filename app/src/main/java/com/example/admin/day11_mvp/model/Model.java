package com.example.admin.day11_mvp.model;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2018/3/20.
 */

public class Model {
    private static final Model ourInstance = new Model();

    private Model() {
    }
    public static Model getInstance() {
        return ourInstance;
    }

    public void Myokhttp(String url, final GetModelListener getModelListener){

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

                Gson gson = new Gson();
                User user = gson.fromJson(string, User.class);

                getModelListener.getModeldata(user);
            }
        });

    }
    public interface GetModelListener{
        void getModeldata(User user);
    }

}
