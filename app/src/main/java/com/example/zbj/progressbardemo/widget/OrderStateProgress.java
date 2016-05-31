package com.example.zbj.progressbardemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zbj on 16/5/31.
 */
public class OrderStateProgress extends View {
    public OrderStateProgress(Context context) {
        this(context,null);
    }

    public OrderStateProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrderStateProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        
    }
}
