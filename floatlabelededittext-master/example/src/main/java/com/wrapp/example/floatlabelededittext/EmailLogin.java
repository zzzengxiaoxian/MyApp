package com.wrapp.example.floatlabelededittext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.LDM.util.L;
import com.LDM.util.Sqlite.UserService;

/**
 * Created by dell on 2016/7/27.
 */
public class EmailLogin extends AppCompatActivity {


    EditText edtemail, edtpassword;
    Button btnlogin;
    TextView txtregister, txtforgetpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emalilogin);

        edtemail = (EditText) findViewById(R.id.edtemail);//邮箱edt
        edtpassword = (EditText) findViewById(R.id.edtpwd);//密码edt
        btnlogin = (Button) findViewById(R.id.btnlogin);//登陆按钮
        txtregister = (TextView) findViewById(R.id.txtregister);//注册txt
        txtforgetpwd = (TextView) findViewById(R.id.txtforgetpwd);//忘记密码txt


        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //设置后退按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.activity_emalilogin);


        /**
         * 监听事件
         */
        txtregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(EmailLogin.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtemail.getText().toString();
                String pwd = edtpassword.getText().toString();
                L.d("TAG", name + "_"+pwd);

                UserService uService = new UserService(EmailLogin.this);
                boolean flag = uService.login(name, pwd);
                if (flag) {
                    L.d("TAG", "登录成功");
                    Toast.makeText(EmailLogin.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(EmailLogin.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    L.d("TAG", "登录失败");
                    Toast.makeText(EmailLogin.this, "登录失败", Toast.LENGTH_LONG).show();
                }


            }
        });

        txtforgetpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EmailLogin.this, "忘记密码", Toast.LENGTH_LONG).show();
            }
        });


    }

    /**
     * 点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle the click on the back arrow click
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
