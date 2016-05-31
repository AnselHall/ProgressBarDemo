package com.example.zbj.progressbardemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class OrderStateProgress extends View {

    private Paint bPaint;
    private int mWidth;
    private Paint topPaint;
    private int topColor;
    private int backColor;

    private static float RADIUS = 40f;
    private static int PADDING = 10;

    public OrderStateProgress(Context context) {
        this(context, null);
    }

    public OrderStateProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrderStateProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {

        topColor = Color.parseColor("#28A4B0");
        backColor = Color.parseColor("#D9D9DE");

        bPaint = new Paint();
        bPaint.setAntiAlias(true);
        bPaint.setColor(backColor);


        topPaint = new Paint();
        topPaint.setAntiAlias(true);
        topPaint.setColor(topColor);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth = getWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawLine(0f, 5f, mWidth, 5f, bPaint);

        canvas.drawRect(40f, 30f, mWidth, 50f, bPaint);

        topPaint.setColor(topColor);
        canvas.drawCircle(40f, 40f, RADIUS, topPaint);

        topPaint.setColor(backColor);
        canvas.drawCircle(mWidth / 3, 40f, RADIUS, topPaint);

        canvas.drawCircle(mWidth * 2 / 3, 40f, RADIUS, topPaint);

        canvas.drawCircle(mWidth - 40f, 40f, RADIUS, topPaint);

        canvas.drawText("订单预定", 2, 4, 40f, 180f, topPaint);
//        canvas.drawText("",);

    }
}
