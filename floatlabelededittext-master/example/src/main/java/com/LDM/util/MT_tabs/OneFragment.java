package com.LDM.util.MT_tabs;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wrapp.example.floatlabelededittext.MainActivity;
import com.wrapp.example.floatlabelededittext.R;

/**
 * Created by dell on 2016/8/8.
 */
public class OneFragment extends Fragment implements ResettableFragment {


    private TextView rv;
    private MainActivity mainActivity;

    public static OneFragment newInstance() {
        OneFragment fragment = new OneFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        rv = (TextView) v.findViewById(R.id.tv1);
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
