package com.wrapp.example.floatlabelededittext;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.LDM.util.MTPageview.RecyclerViewFragment;
import com.LDM.util.MTPageview.TestRecyclerViewAdapter;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

/**
 * Created by dell on 2016/8/10.
 */
public class MaterailViewPager extends AppCompatActivity {


    private MaterialViewPager mViewPager;
    private Toolbar toolbar;

    TestRecyclerViewAdapter adapter;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);

        setTitle("");


        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        //设置toolbar标题栏
        toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);//让actionbar的后退按钮可点击。对应ActionBar.DISPLAY_HOME_AS_UP
//            actionBar.setDisplayShowHomeEnabled(true);//左上角图标是否显示
//            actionBar.setDisplayShowTitleEnabled(true);
//            actionBar.setDisplayUseLogoEnabled(false);
//            actionBar.setHomeButtonEnabled(true);
        }

        //选项卡的数量
        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    default:
                        return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "Selection";
                    case 1:
                        return "LDM";
                    case 2:
                        return "Professionnel";
                    case 3:
                        return "Setting";
                }
                return "";
            }
        });


        //最上边的颜色和替换的图片
        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "http://image4.360doc.com/DownloadImg/2009/7/30/137535_4547726_1.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://article.luqianzhe.cn/img_travel/2015730175218192.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.wmpic.me/wp-content/uploads/2014/03/20140320105920496.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://pic1.mofang.com.tw/2014/0516/20140516051344912.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        //添加大标题和点击事项
        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo = findViewById(R.id.logo_white);

        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Callme刘董", Toast.LENGTH_SHORT).show();
                }
            });
        }

        //列表
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(adapter);

    }

    /**
     * 设置返回按钮监听事件
     *
     * @param item
     * @return
     */
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
