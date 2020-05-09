package com.example.javademo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Customview extends View {

    public Customview(Context context) {
        super(context);
    }

    public Customview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Customview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
