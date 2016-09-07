package com.wrapp.example.floatlabelededittext;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by dell on 2016/8/22.
 */
public class OkTestActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_get;
    private Button bt_post;
    private TextView tv_show;


    final OkHttpClient client = new OkHttpClient();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttplayout);
        bt_get = (Button) findViewById(R.id.bt_get);
        bt_post = (Button) findViewById(R.id.bt_post);
        tv_show = (TextView) findViewById(R.id.tv_show);

        bt_get.setOnClickListener(this);
        bt_post.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_get:
                getRequest();
            case R.id.bt_post:
                postRequest();

                break;
        }

    }

    public void getRequest() {

        final Request request = new Request.Builder()
                .get()
                .tag(this)
                .url("http://www.baidu.com")
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Response response = null;

                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        Log.i("LDM", "打印GET响应数据" + response.body().string());

                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                    tv_show.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();


    }

    private void postRequest() {
        RequestBody formBody = new FormBody.Builder()//2.x的FormEncodingBuilder类被去掉了在3.x版本中被FormBody.Builder取代了
                .add("", "")
                .build();

        final Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .post(formBody)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        Log.i("WY", "打印POST响应的数据：" + response.body().string());

                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                    tv_show.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
