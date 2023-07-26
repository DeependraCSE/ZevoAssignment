package com.example.newsassignmentzevo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.newsassignmentzevo.R;
import com.example.newsassignmentzevo.databinding.ActivitySplashScreenBinding;
import com.example.newsassignmentzevo.newslist.activity.MainActivity;

public class SplashScreen extends AppCompatActivity {
    ActivitySplashScreenBinding binding;
    Handler handler;
    Runnable runnable;
    int delay = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash_screen);

        handler = new Handler();
        runnable = () -> {
            startActivity(new Intent(SplashScreen.this, MainActivity.class));
            finish();
        };
        CallMainActivity();
    }

    public void CallMainActivity(){
        handler.postDelayed(runnable, delay);
    }

    @Override
    protected void onDestroy() {
        if(null != handler){
            handler.removeCallbacks(runnable);
        }
        super.onDestroy();
    }
}