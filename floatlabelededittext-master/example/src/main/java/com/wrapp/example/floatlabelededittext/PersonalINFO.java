package com.wrapp.example.floatlabelededittext;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.LDM.util.AvatarImageView;

/**
 * Created by dell on 2016/8/18.
 */
public class PersonalINFO extends AppCompatActivity {


    private Toolbar toolbar;

    private AvatarImageView avatarImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        avatarImageView = (AvatarImageView) findViewById(R.id.avatarIv);
        //        avatarImageView.setDialogBackgroundColor("#00AAAA"); //设置对话框的背景色
//        avatarImageView.setBtnClickedColor("#00AAAA"); //设置按钮点击后的颜色

//        avatarImageView.setAnimResId(R.style.avatar_dialog_animation); //设置dialog显示的动画
//        avatarImageView.setTitleColor("#FFEEAA");  //设置标题的颜色
//        avatarImageView.setBtnBackgroundColor("#FFEEAA"); //设置按钮的背景色
//        avatarImageView.setTitleLineColor("#FFEEAA"); //设置标题下的分割线的颜色
//        avatarImageView.setLineColor("#FFEEAA"); //设置按钮之间的分割线的颜色
//        avatarImageView.setTitlePaddingTopBottom(30); //设置标题的padding
//        avatarImageView.setBtnPaddingTopBottom(30); //设置按钮的padding
//        avatarImageView.setTitleText("testTitle"); //设置标题的文字
//        avatarImageView.setPhotoButtonText("testPhotoText"); //设置拍照按钮的文字
//        avatarImageView.setChoosePicButtonText("testChooseText"); //设置选择照片的文字
//        avatarImageView.setDialogCorner(20); //设置dialog的角度
//        avatarImageView.setBtnTextColor("#FFEEAA"); //设置按钮文本的颜色
//        avatarImageView.setTitleTextSize(30); //设置标题的文字大小
//        avatarImageView.setBtnTextSize(30); //设置按钮的文字大小


        if (toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);//让actionbar的后退按钮可点击。对应ActionBar.DISPLAY_HOME_AS_UP
//            actionBar.setDisplayShowHomeEnabled(true);//左上角图标是否显示
//            actionBar.setDisplayShowCustomEnabled(true);  // 使自定义的普通View能在title栏显示，即actionBar.setCustomView能起作用，对应ActionBar.DISPLAY_SHOW_CUSTOM
//            actionBar.setDisplayShowTitleEnabled(true);
////            其中setHomeButtonEnabled和setDisplayShowHomeEnabled共同起作用，如果setHomeButtonEnabled设成false，
////            即使setDisplayShowHomeEnabled设成true，图标也不能点击
//            actionBar.setDisplayUseLogoEnabled(false);
//            actionBar.setHomeButtonEnabled(true);
        }

        View view_user;

        view_user = findViewById(R.id.view_user);

        view_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(PersonalINFO.this, "请点击图片", Toast.LENGTH_SHORT).show();
            }
        });

        avatarImageView.setAfterCropListener(new AvatarImageView.AfterCropListener() {
            @Override
            public void afterCrop(Bitmap photo) {
                Toast.makeText(PersonalINFO.this, "设置新的头像成功", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //在拍照、选取照片、裁剪Activity结束后，调用的方法
        if (avatarImageView != null) {
            avatarImageView.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    //监听返回按钮操作事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
