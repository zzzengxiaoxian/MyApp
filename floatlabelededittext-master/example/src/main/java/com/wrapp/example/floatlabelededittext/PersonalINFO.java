package com.wrapp.example.floatlabelededittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;

/**
 * Created by dell on 2016/8/18.
 */
public class PersonalINFO extends AppCompatActivity {

    private ArrayList<String> filePaths;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);

        View view_user;

        view_user = findViewById(R.id.view_user);

        view_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onPickPhoto();
            }
        });

    }

    public void onPickPhoto() {
        FilePickerBuilder.getInstance().setMaxCount(1)
                .setSelectedFiles(filePaths)
                .setActivityTheme(R.style.FilePickerTheme)
                .pickPhoto(this);
//                选择文档For document picker:
//                FilePickerBuilder.getInstance().setMaxCount(10)
//                        .setSelectedFiles(filePaths)
//                        .setActivityTheme(R.style.AppTheme)
//                        .pickDocument(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case FilePickerConst.REQUEST_CODE:
                if (resultCode == RESULT_OK && data != null) {
                    filePaths = data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_PHOTOS);
//                    addThemToView(filePaths);
                }
        }
    }


}
