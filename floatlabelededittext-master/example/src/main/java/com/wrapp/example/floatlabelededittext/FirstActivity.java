package com.wrapp.example.floatlabelededittext;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.LDM.util.LOGutil;

/**
 * Created by dell on 2016/8/7.
 */
public class FirstActivity extends Activity {
    private final int SPLASH_DISPLAY_LENGHT = 4000;// 定义常量1s

    private Boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_firstactivity);


        //读取SharedPreFerences中需要的数据,使用SharedPreFerences来记录程序启动的使用次数
        SharedPreferences preferences = getSharedPreferences("ISFIRST_APPINTRO", MODE_PRIVATE);

        //取得相应的值,如果没有该值,说明还未写入,用true作为默认值
        isFirst = preferences.getBoolean("isFirstIn", true);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //判断程序第几次启动
                if (isFirst) {
                LOGutil.d("TAG", "第一次登陆");
                Intent intent = new Intent();
                intent.setClass(FirstActivity.this, AppIntro.class);
                FirstActivity.this.startActivity(intent);
                FirstActivity.this.finish();
                } else {
                    LOGutil.d("TAG", "第二次登陆");
                    Intent intent = new Intent();
                    intent.setClass(FirstActivity.this, MainActivity.class);
                    FirstActivity.this.startActivity(intent);
                    FirstActivity.this.finish();
                }


            }
        }, SPLASH_DISPLAY_LENGHT);

    }
}
