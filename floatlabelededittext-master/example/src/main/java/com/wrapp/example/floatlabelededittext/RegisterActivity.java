package com.wrapp.example.floatlabelededittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.LDM.util.InputEditTextJudge;
import com.LDM.util.Sqlite.UserService;
import com.bean.User;


public class RegisterActivity extends /*ActionBarActivity*/ AppCompatActivity {

    Button btnregister;
    EditText edtusername, edtpasswrod, edtconfirmpwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnregister = (Button) findViewById(R.id.btnregister);
        edtusername = (EditText) findViewById(R.id.edt_email);
        edtpasswrod = (EditText) findViewById(R.id.edt_pwd);
        edtconfirmpwd = (EditText) findViewById(R.id.edt_configpwd);

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.activity_emailregister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edtusername.getText().toString().trim();
                Boolean flag = InputEditTextJudge.isEmail(name);
                String pwd = edtpasswrod.getText().toString().trim();
                String confirmpwd = edtconfirmpwd.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "邮箱不能为空", Toast.LENGTH_LONG).show();
                } else if (flag == false) {
                    Toast.makeText(RegisterActivity.this, "请输入正确的邮箱格式", Toast.LENGTH_LONG).show();
                } else if (pwd.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_LONG).show();
                } else if (!confirmpwd.equals(pwd)) {
                    Toast.makeText(RegisterActivity.this, "前后输入的密码不同，请重试", Toast.LENGTH_LONG).show();
                } else {
                    UserService uService = new UserService(RegisterActivity.this);
                    User user = new User();
                    user.setUsername(name);
                    user.setPassword(pwd);
                    uService.register(user);
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });


    }//----oncreat end

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
