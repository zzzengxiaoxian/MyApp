package com.wrapp.example.floatlabelededittext;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

/**
 * Created by dell on 2016/7/26.
 */
/**
 * 一个FloatingActionButton有一个FloatingActionMenu，FloatingActionMenu添加动画弹出的子菜单。
 * FloatingActionButton的按钮点击事件将触发、弹出FloatingActionMenu中包含的子菜单。
 * FloatingActionMenu使用attachTo方法附着在一个FloatingActionButton上。
 * FloatingActionMenu在attachTo到一个FloatingActionButton后，两者之间发生关联。
 * FloatingActionMenu在添加子菜单时候，首先需要一个SubActionButton.Builder，该SubActionButton.
 * Builder通过setContentView(ImageView
 * image).build()把一个ImageView创建生产一个SubActionButton ,
 * 然后通过FloatingActionMenu.Builder的add方法把前面生成的SubActionButton添加进去。
 * <p/>
 * <p/>
 * 按钮的旋转动画在onMenuOpened和onMenuClosed中做。
 */

public class rlIcon2 extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rilcon2);

        // 添加 右下角的白色+号按钮
        final ImageView fabIconNew = new ImageView(this);
        fabIconNew.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_new_light));
        final FloatingActionButton rightLowerButton = new FloatingActionButton.Builder(this).setContentView(fabIconNew)
                .build();

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);

        ImageView rlIcon1 = new ImageView(this);
        ImageView rlIcon2 = new ImageView(this);
        ImageView rlIcon3 = new ImageView(this);
        ImageView rlIcon4 = new ImageView(this);
        rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_chat_light));
        rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_camera_light));
        rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_video_light));
        rlIcon4.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_place_light));

        // Build the menu with default options: light theme, 90 degrees, 72dp
        // radius.
        // Set 4 default SubActionButtons
        // FloatingActionMenu通过attachTo(rightLowerButton)附着到FloatingActionButton
        final FloatingActionMenu rightLowerMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(rLSubBuilder.setContentView(rlIcon1).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon2).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon3).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon4).build()).attachTo(rightLowerButton).build();


        // Listen menu open and close events to animate the button content view
        rightLowerMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
            @Override
            public void onMenuOpened(FloatingActionMenu menu) {
                // 增加按钮中的+号图标顺时针旋转45度
                // Rotate the icon of rightLowerButton 45 degrees clockwise
                fabIconNew.setRotation(0);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 45);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();
            }

            @Override
            public void onMenuClosed(FloatingActionMenu menu) {
                // 增加按钮中的+号图标逆时针旋转45度
                // Rotate the icon of rightLowerButton 45 degrees
                // counter-clockwise
                fabIconNew.setRotation(45);
                PropertyValuesHolder pvhR = PropertyValuesHolder.ofFloat(View.ROTATION, 0);
                ObjectAnimator animation = ObjectAnimator.ofPropertyValuesHolder(fabIconNew, pvhR);
                animation.start();
            }
        });

        //        // 左边中间的红底白色星型按钮
//        // Set up the large red button on the center right side
//        // With custom button and content sizes and margins
//        int redActionButtonSize = getResources().getDimensionPixelSize(R.dimen.red_action_button_size);
//        int redActionButtonMargin = getResources().getDimensionPixelOffset(R.dimen.action_button_margin);
//        int redActionButtonContentSize = getResources().getDimensionPixelSize(R.dimen.red_action_button_content_size);
//        int redActionButtonContentMargin = getResources()
//                .getDimensionPixelSize(R.dimen.red_action_button_content_margin);
//        int redActionMenuRadius = getResources().getDimensionPixelSize(R.dimen.red_action_menu_radius);
//        int blueSubActionButtonSize = getResources().getDimensionPixelSize(R.dimen.blue_sub_action_button_size);
//        int blueSubActionButtonContentMargin = getResources()
//                .getDimensionPixelSize(R.dimen.blue_sub_action_button_content_margin);
//
//        ImageView fabIconStar = new ImageView(this);
//        fabIconStar.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_important));
//
//        FloatingActionButton.LayoutParams starParams = new FloatingActionButton.LayoutParams(redActionButtonSize,
//                redActionButtonSize);
//        starParams.setMargins(redActionButtonMargin, redActionButtonMargin, redActionButtonMargin,
//                redActionButtonMargin);
//        fabIconStar.setLayoutParams(starParams);
//
//        FloatingActionButton.LayoutParams fabIconStarParams = new FloatingActionButton.LayoutParams(
//                redActionButtonContentSize, redActionButtonContentSize);
//        fabIconStarParams.setMargins(redActionButtonContentMargin, redActionButtonContentMargin,
//                redActionButtonContentMargin, redActionButtonContentMargin);
//
//        final FloatingActionButton leftCenterButton = new FloatingActionButton.Builder(this)
//                .setContentView(fabIconStar, fabIconStarParams)
//                .setBackgroundDrawable(R.drawable.button_action_red_selector)// 红底白星按钮选中时候状态变化和背景颜色
//                .setPosition(FloatingActionButton.POSITION_LEFT_CENTER)// 左边居中
//                .setLayoutParams(starParams).build();
//
//        // Set up customized SubActionButtons for the right center menu
//        SubActionButton.Builder lCSubBuilder = new SubActionButton.Builder(this);
//        lCSubBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_action_blue_selector));
//
//        FrameLayout.LayoutParams blueContentParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
//                FrameLayout.LayoutParams.MATCH_PARENT);
//        blueContentParams.setMargins(blueSubActionButtonContentMargin, blueSubActionButtonContentMargin,
//                blueSubActionButtonContentMargin, blueSubActionButtonContentMargin);
//        lCSubBuilder.setLayoutParams(blueContentParams);
//        // Set custom layout params
//        FrameLayout.LayoutParams blueParams = new FrameLayout.LayoutParams(blueSubActionButtonSize,
//                blueSubActionButtonSize);
//        lCSubBuilder.setLayoutParams(blueParams);
//
//        ImageView lcIcon1 = new ImageView(this);
//        ImageView lcIcon2 = new ImageView(this);
//        ImageView lcIcon3 = new ImageView(this);
//        ImageView lcIcon4 = new ImageView(this);
//        ImageView lcIcon5 = new ImageView(this);
//
//        lcIcon1.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_camera));
//        lcIcon2.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_picture));
//        lcIcon3.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_video));
//        lcIcon4.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_location_found));
//        lcIcon5.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_headphones));
//
//        // Build another menu with custom options
//        final FloatingActionMenu leftCenterMenu = new FloatingActionMenu.Builder(this)
//                .addSubActionView(lCSubBuilder.setContentView(lcIcon1, blueContentParams).build())
//                .addSubActionView(lCSubBuilder.setContentView(lcIcon2, blueContentParams).build())
//                .addSubActionView(lCSubBuilder.setContentView(lcIcon3, blueContentParams).build())
//                .addSubActionView(lCSubBuilder.setContentView(lcIcon4, blueContentParams).build())
//                .addSubActionView(lCSubBuilder.setContentView(lcIcon5, blueContentParams).build())
//                .setRadius(redActionMenuRadius).setStartAngle(70).setEndAngle(-70).attachTo(leftCenterButton).build();
//
//    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    }
}


