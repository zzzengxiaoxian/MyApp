package com.wrapp.example.floatlabelededittext;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.simplelist.MaterialSimpleListAdapter;
import com.afollestad.materialdialogs.simplelist.MaterialSimpleListItem;

/**
 * Created by dell on 2016/7/27.
 */
public class LoginActivity extends Activity {


    private Toast mToast;

    Button btnweixinlogin, btnweibologin, btnemaillogin;
    TextView tvotherlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnweixinlogin = (Button) findViewById(R.id.btnweixinlogin);
        btnweibologin = (Button) findViewById(R.id.btnweibologin);
        btnemaillogin = (Button) findViewById(R.id.btnemailogin);
        tvotherlogin = (TextView) findViewById(R.id.otherlogin);


        btnemaillogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, EmailLogin.class);
                startActivity(intent);
                finish();
            }
        });


        tvotherlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                MaterialDialog dialog = new MaterialDialog.Builder(LoginActivity.this)
//                        .title("R.string.title")
//                        .content("R.string.content")
//                        .positiveText("R.string.agree")
//                        .show();
                final MaterialSimpleListAdapter adapter = new MaterialSimpleListAdapter(new MaterialSimpleListAdapter.Callback() {
                    @Override
                    public void onMaterialListItemSelected(int index, MaterialSimpleListItem item) {
                        showToast(item.getContent().toString());
                    }
                });
                adapter.add(new MaterialSimpleListItem.Builder(LoginActivity.this)
                        .content("新浪微博登录")
                        .icon(R.drawable.ic_launcher)
                        .backgroundColor(Color.WHITE)
                        .build());
                adapter.add(new MaterialSimpleListItem.Builder(LoginActivity.this)
                        .content("人人网登录")
                        .icon(R.drawable.ic_launcher)
                        .backgroundColor(Color.WHITE)
                        .build());
//                adapter.add(new MaterialSimpleListItem.Builder(this)
//                        .content(R.string.add_account)
//                        .icon(R.drawable.ic_content_add)
//                        .iconPaddingDp(8)
//                        .build());

                new MaterialDialog.Builder(LoginActivity.this)
                        .title(R.string.loginways)
                        .adapter(adapter, null)
                        .show();
            }
        });


    }

    private void showToast(String message) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.show();
    }


}
