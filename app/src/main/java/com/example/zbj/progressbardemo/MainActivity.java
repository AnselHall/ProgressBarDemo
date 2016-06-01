package com.example.zbj.progressbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.zbj.progressbardemo.widget.RangeSeekBar;

public class MainActivity extends AppCompatActivity {

    private TextView tv_min;
    private TextView tv_max;
    private RangeSeekBar rsb_range;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initViews();
//
//        registerListener();
    }

    public void order(View view) {
        startActivity(new Intent(this, OrderStateProgressActivity.class));
    }

    private void registerListener() {

        rsb_range.setNotifyWhileDragging(true);
        rsb_range.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar bar, Number minValue, Number maxValue) {

                int min = minValue.intValue();
                int max = maxValue.intValue();

                if (min == 50 && max == 5000) {
                    tv_min.setText("¥" + min);
                    tv_max.setText("¥5000+");
                    return;
                }

                tv_min.setText("¥" + min);
                tv_max.setText("¥" + max);
            }
        });
    }

    private void initViews() {
//        tv_min = (TextView) findViewById(R.id.tv_min);
//        tv_max = (TextView) findViewById(R.id.tv_max);
//        rsb_range = (RangeSeekBar) findViewById(R.id.rsb_range);
    }
}