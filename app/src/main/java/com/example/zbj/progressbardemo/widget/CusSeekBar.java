package com.example.zbj.progressbardemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.example.zbj.progressbardemo.R;

/**
 * Created by zbj on 16/5/23.
 */
public class CusSeekBar extends View {
    public CusSeekBar(Context context) {
        this(context, null);
    }

    public CusSeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CusSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CusSeekBar, defStyleAttr, 0);




        ta.recycle();
    }
}
