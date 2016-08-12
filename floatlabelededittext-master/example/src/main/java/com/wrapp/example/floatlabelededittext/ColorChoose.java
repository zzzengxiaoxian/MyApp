package com.wrapp.example.floatlabelededittext;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.color.CircleView;
import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.afollestad.materialdialogs.internal.ThemeSingleton;
import com.afollestad.materialdialogs.util.DialogUtils;

/**
 * Created by dell on 2016/8/8.
 */
public class ColorChoose extends AppCompatActivity implements ColorChooserDialog.ColorCallback {


    private Toast mToast;

    // color chooser dialog
    private int primaryPreselect;

    // UTILITY METHODS
    private int accentPreselect;

    private Thread mThread;
    private Handler mHandler;

//    private int chooserDialog;

    private void showToast(String message) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.show();
    }

    private void startThread(Runnable run) {
        if (mThread != null)
            mThread.interrupt();
        mThread = new Thread(run);
        mThread.start();
    }

    private void showToast(@StringRes int message) {
        showToast(getString(message));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorchoose);

        mHandler = new Handler();
        primaryPreselect = DialogUtils.resolveColor(this, R.attr.colorPrimary);
        accentPreselect = DialogUtils.resolveColor(this, R.attr.colorAccent);

        new MaterialDialog.Builder(this)
                .items(R.array.Colors_Item)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        showToast(which + ": " + text);

                        switch (which) {

                            case 0:
                                new ColorChooserDialog.Builder(ColorChoose.this, R.string.color_palette)
                                        .titleSub(R.string.colors)
                                        .preselect(primaryPreselect)
                                        .show();
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            default:
                                break;
                        }


                    }
                })
                .show();
    }

    // Receives callback from color chooser dialog
    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, @ColorInt int color) {
        if (dialog.isAccentMode()) {
            accentPreselect = color;
            ThemeSingleton.get().positiveColor = DialogUtils.getActionTextStateList(this, color);
            ThemeSingleton.get().neutralColor = DialogUtils.getActionTextStateList(this, color);
            ThemeSingleton.get().negativeColor = DialogUtils.getActionTextStateList(this, color);
            ThemeSingleton.get().widgetColor = color;
        } else {
            primaryPreselect = color;
            if (getSupportActionBar() != null)
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(CircleView.shiftColorDown(color));
                getWindow().setNavigationBarColor(color);
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler = null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mThread != null && !mThread.isInterrupted() && mThread.isAlive())
            mThread.interrupt();
    }
}
