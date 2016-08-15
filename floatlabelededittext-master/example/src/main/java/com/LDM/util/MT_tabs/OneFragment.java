package com.LDM.util.MT_tabs;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adapter.RecyclerViewAdapter;
import com.bean.News;
import com.wrapp.example.floatlabelededittext.MainActivity;
import com.wrapp.example.floatlabelededittext.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/8/8.
 */
public class OneFragment extends Fragment implements ResettableFragment {

    private MainActivity mainActivity;
    /**
     * 8.12 recyclewview
     */
    private RecyclerView recyclerView;
    private List<News> newsList;
    private RecyclerViewAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        /**
         * 8/12 recycleview
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        initPersonData();
        adapter = new RecyclerViewAdapter(newsList,getActivity());
        recyclerView.setHasFixedSize(true);//优化
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return v;
    }

    private void initPersonData() {
        newsList = new ArrayList<>();
        //添加新闻
        newsList.add(new News(getString(R.string.news_one_title), getString(R.string.news_one_desc), R.drawable.news_one));
        newsList.add(new News(getString(R.string.news_two_title), getString(R.string.news_two_desc), R.drawable.news_two));
        newsList.add(new News(getString(R.string.news_three_title), getString(R.string.news_three_desc), R.drawable.news_three));
        newsList.add(new News(getString(R.string.news_four_title), getString(R.string.news_four_desc), R.drawable.news_four));
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
