package com.dreamfisn.tipdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvUnread;
    private TipRadioButton tipRB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        tvUnread = (TextView) findViewById(R.id.tv_unread);
        tipRB = (TipRadioButton) findViewById(R.id.tip_button);
        tvUnread.setOnClickListener(this);
    }

    private void initData() {
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_unread:
                tipRB.setTipOn(!tipRB.isTipOn());
                break;
        }
    }
}
