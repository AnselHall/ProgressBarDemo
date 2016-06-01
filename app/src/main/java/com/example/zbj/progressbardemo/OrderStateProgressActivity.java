package com.example.zbj.progressbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.zbj.progressbardemo.widget.OrderStateProgress;

public class OrderStateProgressActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "tag";
    private OrderStateProgress osp;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_state_progress);

        osp = (OrderStateProgress) findViewById(R.id.osp);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);

//        osp.setOrderState(OrderStateProgress.State.CHECKIN);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                osp.setOrderState(OrderStateProgress.State.ORDERCOMMIT);
                break;
            case R.id.btn_2:
                osp.setOrderState(OrderStateProgress.State.PAYSUCCESS);
                break;
            case R.id.btn_3:
                osp.setOrderState(OrderStateProgress.State.BOOKSUCCESS);
                break;
            case R.id.btn_4:
                osp.setOrderState(OrderStateProgress.State.CHECKIN);
                break;
        }

    }
}
