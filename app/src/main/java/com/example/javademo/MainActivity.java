package com.example.javademo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    View.MeasureSpec m;
    ViewGroup viewGroup;
    View vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }



    RelativeLayout rl;

    TextView tv;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            Log.i(TAG, "rl: left : " + rl.getLeft());
            Log.i(TAG, "rl: top : " + rl.getTop());
            Log.i(TAG, "rl: right : " + rl.getRight());
            Log.i(TAG, "rl: bottom : " + rl.getBottom());
            Log.i(TAG, "rl: x : " + rl.getX());
            Log.i(TAG, "rl: y : " + rl.getY());
            Log.i(TAG, "rl: translationx : " + rl.getTranslationX());
            Log.i(TAG, "rl: translationY : " + rl.getTranslationY());

            Log.i(TAG, "----------------------------");

            Log.i(TAG, "tv: left : " + tv.getLeft());
            Log.i(TAG, "tv: top : " + tv.getTop());
            Log.i(TAG, "tv: right : " + tv.getRight());
            Log.i(TAG, "tv: bottom : " + tv.getBottom());
            Log.i(TAG, "tv: x : " + tv.getX());
            Log.i(TAG, "tv: y : " + tv.getY());
            Log.i(TAG, "tv: translationx : " + tv.getTranslationX());
            Log.i(TAG, "tv: translationY : " + tv.getTranslationY());


        }
    }

    private void initView() {

        rl = findViewById(R.id.rl);
        tv = findViewById(R.id.tv);
    }

    public void rlclick(View view) {
        startActivity(new Intent(this,SecondActivity.class));
    }
}
