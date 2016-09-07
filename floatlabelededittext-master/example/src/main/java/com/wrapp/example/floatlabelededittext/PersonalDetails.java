package com.wrapp.example.floatlabelededittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by dell on 2016/8/18.
 */
public class PersonalDetails extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldetail);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);//让actionbar的后退按钮可点击。对应ActionBar.DISPLAY_HOME_AS_UP
//            actionBar.setDisplayShowHomeEnabled(true);//左上角图标是否显示
//            actionBar.setDisplayShowCustomEnabled(true);  // 使自定义的普通View能在title栏显示，即actionBar.setCustomView能起作用，对应ActionBar.DISPLAY_SHOW_CUSTOM
//            actionBar.setDisplayShowTitleEnabled(true);其中setHomeButtonEnabled和setDisplayShowHomeEnabled共同起作用，如果setHomeButtonEnabled设成false，即使setDisplayShowHomeEnabled设成true，图标也不能点击
//            actionBar.setDisplayUseLogoEnabled(false);
//            actionBar.setHomeButtonEnabled(true);
        }

        View view_user;

        view_user = findViewById(R.id.view_user);

        view_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(PersonalDetails.this, PersonalINFO.class);
                startActivity(intent);
            }
        });


    }


}
