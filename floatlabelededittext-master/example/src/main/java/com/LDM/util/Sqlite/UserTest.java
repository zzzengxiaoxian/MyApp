package com.LDM.util.Sqlite;

import android.test.AndroidTestCase;
import android.util.Log;

import com.LDM.util.Sqlite.DatabaseHelper;
import com.LDM.util.Sqlite.UserService;
import com.bean.User;

public class UserTest extends AndroidTestCase {
    public void datatest() throws Throwable {
        DatabaseHelper dbhepler = new DatabaseHelper(this.getContext());
        dbhepler.getReadableDatabase();
    }

    //ע��
    public void registerTest() throws Throwable {
        UserService uService = new UserService(this.getContext());
        User user = new User();
        user.setUsername("renhaili");
        user.setPassword("123");
        uService.register(user);
    }

    public void loginTest() throws Throwable {
        UserService uService = new UserService(this.getContext());
        String username = "renhaili";
        String password = "123";
        boolean flag = uService.login(username, password);
        if (flag) {
            Log.i("TAG", "登录成功");
        } else {
            Log.i("TAG", "登录失败");
        }
    }

}
