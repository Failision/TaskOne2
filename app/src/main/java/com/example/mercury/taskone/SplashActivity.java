package com.example.mercury.taskone;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;


public class SplashActivity extends ActionBarActivity {

    private Handler mHandler;
    Runnable runnable;
    private boolean flag_orientation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Log.d("save", String.valueOf(savedInstanceState));
        setContentView(R.layout.activity_splash_screen);
        if (savedInstanceState != null) {
       //     Log.d("save", String.valueOf(savedInstanceState));
            flag_orientation = savedInstanceState.getBoolean("flag_orientation", false);
       //     Log.d("save", String.valueOf(flag_orientation));
        }
        if (flag_orientation == false) {
            final Intent intent = new Intent(this, HomeActivity.class);
            mHandler = new Handler();
            mHandler.postDelayed(runnable = new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    finish();
                }
            }, 3000);
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("flag_orientation", true);
    }
}