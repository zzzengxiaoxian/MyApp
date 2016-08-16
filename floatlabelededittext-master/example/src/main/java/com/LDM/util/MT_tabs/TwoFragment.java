package com.LDM.util.MT_tabs;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.wrapp.example.floatlabelededittext.ConvenientBanner.BannerTest;
import com.wrapp.example.floatlabelededittext.MainActivity;
import com.wrapp.example.floatlabelededittext.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/8/8.
 */
public class TwoFragment extends Fragment implements ResettableFragment {

    View v;
    private MainActivity mainActivity;


    Button btn1;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_two, container, false);

        btn1 = (Button) v.findViewById(R.id.btn1);
        btn1.setText("Imagebanner");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), BannerTest.class);
                startActivity(intent);
            }
        });
        return v;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity) getActivity();
        mainActivity.addFragment(this);
    }

    @Override
    public void onDetach() {
        mainActivity.removeFragment(this);
        super.onDetach();
    }

    @Override
    public void setupAndReset() {

    }


}
