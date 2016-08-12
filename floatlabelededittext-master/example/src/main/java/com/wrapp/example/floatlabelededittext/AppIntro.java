package com.wrapp.example.floatlabelededittext;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.LDM.util.AppIntroAnimation.BaseAppIntro;

/**
 * Created by dell on 2016/8/7.
 */
public class AppIntro extends BaseAppIntro {
    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        addSlide(SampleSlide.newInstance(R.layout.intro));
        addSlide(SampleSlide.newInstance(R.layout.intro2));
        addSlide(SampleSlide.newInstance(R.layout.intro3));
        addSlide(SampleSlide.newInstance(R.layout.intro4));

        setFlowAnimation();
    }

    private void loadMainActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onSkipPressed() {
        loadMainActivity();
        Toast.makeText(getApplicationContext(), "Y U DO DIS TO ME?", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        loadMainActivity();
    }

    @Override
    public void onSlideChanged() {


    }

    public void getStarted(View v) {
        loadMainActivity();
    }

}
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//
//
//        // Add your slide's fragments here.
//        // AppIntro will automatically generate the dots indicator and buttons.
////        addSlide(first_fragment);
////        addSlide(second_fragment);
////        addSlide(third_fragment);
////        addSlide(fourth_fragment);
//
//        // Instead of fragments, you can also use our default slide
//        // Just set a title, description, background and image. AppIntro will do the rest.
//        addSlide(AppIntroFragment.newInstance("1", "这是刘东铭的个人主页", R.drawable.ic_launcher, Color.BLUE));
//        addSlide(AppIntroFragment.newInstance("2", "这是刘东铭的个人主页", R.drawable.ic_launcher, Color.RED));
//        addSlide(AppIntroFragment.newInstance("3", "这是刘东铭的个人主页", R.drawable.ic_launcher, Color.WHITE));
//
//
//        // OPTIONAL METHODS
//        // Override bar/separator color.
//        setBarColor(Color.parseColor("#3F51B5"));
//        setSeparatorColor(Color.parseColor("#2196F3"));
//
//        // Hide Skip/Done button.
//        showSkipButton(true);
//        setProgressButtonEnabled(true);
//
//        // Turn vibration on and set intensity.
//        // NOTE: you will probably need to ask VIBRATE permisssion in Manifest.
//        setVibrate(true);
//        setVibrateIntensity(30);
//    }
//
//    @Override
//    public void onSkipPressed(Fragment currentFragment) {
//        super.onSkipPressed(currentFragment);
//        // Do something when users tap on Skip button.
//        loadMainActivity();
//        Toast.makeText(getApplicationContext(), "滑动", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onDonePressed(Fragment currentFragment) {
//        super.onDonePressed(currentFragment);
//        // Do something when users tap on Done button.
//        loadMainActivity();
//    }
//
//    @Override
//    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
//        super.onSlideChanged(oldFragment, newFragment);
//        // Do something when the slide changes.
//    }
//
//    private void loadMainActivity() {
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
//    }



