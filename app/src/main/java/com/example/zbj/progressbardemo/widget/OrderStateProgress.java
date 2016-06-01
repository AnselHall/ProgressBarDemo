package com.example.zbj.progressbardemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.zbj.progressbardemo.util.PixelUtil;

public class OrderStateProgress extends View {

    private static final String TAG = "tag";
    private Paint paint;
    private int mWidth;
    private int topColor;

    private static float RADIUS = 0f;
    private static int PADDING = 20;
    private static int HALF_LINE_HEIGHT = 5;
    private static int TEXT_SIZE = 5;
    private static int TEXT_MARGIN_TOP = 5;
    private int activeTextColor;
    private int deActiveColor;
    private State orderState = State.ORDERCOMMIT;

    public enum State {
        ORDERCOMMIT, PAYSUCCESS, BOOKSUCCESS, CHECKIN
    }

    public OrderStateProgress(Context context) {
        this(context, null);
    }

    public OrderStateProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrderStateProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {

        topColor = Color.parseColor("#28A4B0");
//        backColor = Color.parseColor("#D9D9DE");
        activeTextColor = Color.parseColor("#6B6B76");
        deActiveColor = Color.parseColor("#D9D9DE");

        paint = new Paint();
        paint.setAntiAlias(true);

        RADIUS = PixelUtil.dpToPx(context, 6);//10px --
        PADDING = PixelUtil.dpToPx(context, 6);//10px
        HALF_LINE_HEIGHT = PixelUtil.dpToPx(context, 1);//2px  4px --
        TEXT_SIZE = PixelUtil.dpToPx(context, 16);//24px --
        TEXT_MARGIN_TOP = PixelUtil.dpToPx(context, 10);//20px --

        initPaintColor();
    }

    private int commitCircleColor;
    private int payCircleColor;
    private int bookCircleColor;
    private int checkCircleColor;

    private int commitTextColor;
    private int payTextColor;
    private int bookTextColor;
    private int checkTextColor;

    private int payLineHalfHeight = HALF_LINE_HEIGHT;
    private int bookLineHalfHeight = HALF_LINE_HEIGHT;
    private int checkLineHalfHeight = HALF_LINE_HEIGHT;

    private void initPaintColor() {
        switch (orderState) {
            case ORDERCOMMIT:
                commitCircleColor = topColor;
                payCircleColor = deActiveColor;
                bookCircleColor = deActiveColor;
                checkCircleColor = deActiveColor;

                payLineHalfHeight = HALF_LINE_HEIGHT;
                bookLineHalfHeight = HALF_LINE_HEIGHT;
                checkLineHalfHeight = HALF_LINE_HEIGHT;

                commitTextColor = activeTextColor;
                payTextColor = deActiveColor;
                bookTextColor = deActiveColor;
                checkTextColor = deActiveColor;

                break;
            case PAYSUCCESS:
                commitCircleColor = topColor;
                payCircleColor = topColor;
                bookCircleColor = deActiveColor;
                checkCircleColor = deActiveColor;

                payLineHalfHeight = HALF_LINE_HEIGHT * 2;
                bookLineHalfHeight = HALF_LINE_HEIGHT;
                checkLineHalfHeight = HALF_LINE_HEIGHT;


                commitTextColor = activeTextColor;
                payTextColor = activeTextColor;
                bookTextColor = deActiveColor;
                checkTextColor = deActiveColor;
                break;
            case BOOKSUCCESS:
                commitCircleColor = topColor;
                payCircleColor = topColor;
                bookCircleColor = topColor;
                checkCircleColor = deActiveColor;

                payLineHalfHeight = HALF_LINE_HEIGHT * 2;
                bookLineHalfHeight = HALF_LINE_HEIGHT * 2;
                checkLineHalfHeight = HALF_LINE_HEIGHT;

                commitTextColor = activeTextColor;
                payTextColor = activeTextColor;
                bookTextColor = activeTextColor;
                checkTextColor = deActiveColor;
                break;
            case CHECKIN:
                commitCircleColor = topColor;
                payCircleColor = topColor;
                bookCircleColor = topColor;
                checkCircleColor = topColor;

                payLineHalfHeight = HALF_LINE_HEIGHT * 2;
                bookLineHalfHeight = HALF_LINE_HEIGHT * 2;
                checkLineHalfHeight = HALF_LINE_HEIGHT * 2;

                commitTextColor = activeTextColor;
                payTextColor = activeTextColor;
                bookTextColor = activeTextColor;
                checkTextColor = activeTextColor;
                break;
        }
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = 200;
        if (MeasureSpec.UNSPECIFIED != MeasureSpec.getMode(widthMeasureSpec)) {
            width = MeasureSpec.getSize(widthMeasureSpec);
        }

        int height = (int) RADIUS * 2
                + PADDING * 2
                + TEXT_MARGIN_TOP
                + TEXT_SIZE
                ;

        if (MeasureSpec.UNSPECIFIED != MeasureSpec.getMode(heightMeasureSpec)) {
            height = Math.min(height, MeasureSpec.getSize(heightMeasureSpec));
        }
        setMeasuredDimension(width, height);

        mWidth = getWidth();

        Log.e(TAG, "onMeasure: mWidth = " + mWidth);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        paint.setColor(deActiveColor);
//        canvas.drawRect(PADDING + RADIUS, PADDING + RADIUS - HALF_LINE_HEIGHT, mWidth - PADDING, PADDING + RADIUS + HALF_LINE_HEIGHT, paint);

        float lineTop = PADDING + RADIUS - payLineHalfHeight / 2;
        float lineBottom = PADDING + RADIUS + payLineHalfHeight / 2;
        paint.setColor(payCircleColor);
        canvas.drawRect(PADDING, lineTop, mWidth / 3, lineBottom, paint);

        lineTop = PADDING + RADIUS - bookLineHalfHeight / 2;
        lineBottom = PADDING + RADIUS + bookLineHalfHeight / 2;
        paint.setColor(bookCircleColor);
        canvas.drawRect(mWidth / 3, lineTop, mWidth * 2 / 3, lineBottom, paint);

        lineTop = PADDING + RADIUS - checkLineHalfHeight / 2;
        lineBottom = PADDING + RADIUS + checkLineHalfHeight / 2;
        paint.setColor(checkCircleColor);
        canvas.drawRect(mWidth * 2 / 3, lineTop, mWidth - PADDING, lineBottom, paint);

        //提交订单
        paint.setColor(commitCircleColor);
        canvas.drawCircle(PADDING + RADIUS, RADIUS + PADDING, RADIUS, paint);

        //付款成功
        paint.setColor(payCircleColor);
        canvas.drawCircle(mWidth / 3 + PADDING * 2 / 3, RADIUS + PADDING, RADIUS, paint);

        //预定成功
        paint.setColor(bookCircleColor);
        canvas.drawCircle(mWidth * 2 / 3 - PADDING * 2 / 3, RADIUS + PADDING, RADIUS, paint);

        //入住
        paint.setColor(checkCircleColor);
        canvas.drawCircle(mWidth - PADDING - RADIUS, RADIUS + PADDING, RADIUS, paint);

        float textMargin = RADIUS * 2 + TEXT_MARGIN_TOP * 2 + PADDING * 2;
        paint.setTextSize(TEXT_SIZE);
        paint.setColor(commitTextColor);
        //计算字符长度
        float measureText = paint.measureText("提交订单");
        canvas.drawText("提交订单", 0, textMargin, paint);
//        canvas.drawText("",);

        paint.setColor(payTextColor);
        canvas.drawText("付款成功", mWidth / 3 + PADDING * 2 / 3 - measureText / 2, textMargin, paint);

        paint.setColor(bookTextColor);
        canvas.drawText("预定成功", mWidth * 2 / 3 - PADDING * 2 / 3 - measureText / 2, textMargin, paint);

        float ruzhu = paint.measureText("入住");
        paint.setColor(checkTextColor);
        canvas.drawText("入住", mWidth - ruzhu, textMargin, paint);

//        paint.setColor(Color.WHITE);
//        canvas.drawLine(PADDING + RADIUS / 2, PADDING + RADIUS * 3 / 4, PADDING + RADIUS - RADIUS / 7, PADDING + RADIUS + RADIUS / 3, paint);
//        canvas.drawLine(PADDING + RADIUS - RADIUS / 7, PADDING + RADIUS + RADIUS / 3, PADDING + RADIUS + RADIUS * 3 / 5, PADDING + RADIUS - RADIUS / 3, paint);

    }

    public void setOrderState(State state) {
        orderState = state;
        initPaintColor();
        invalidate();
    }
}
