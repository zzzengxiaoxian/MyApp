package com.LDM.util.MT_tabs;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
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
public class TwoFragment extends Fragment implements ResettableFragment {


    private MainActivity mainActivity;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);

        TextView tv1 = (TextView) v.findViewById(R.id.tvvv1);
        tv1.setText("nihao!");

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
