package com.example.admin.day11_mvp.presenter;

import com.example.admin.day11_mvp.model.User;

/**
 * Created by admin on 2018/3/20.
 */

public interface BackListener {
    void onsuccess(User user);

    void onshibai(String string);
}
