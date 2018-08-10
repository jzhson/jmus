package com.tronxincloud.bmobtest.bmob;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tronxincloud.bmobtest.MainActivity;
import com.tronxincloud.bmobtest.R;
import com.tronxincloud.bmobtest.bmob.view.activity.UserLoginActivity;

/**
 * Created by Administrator on 2018/8/2.
 */

public class BmobTestActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_testUserTableuse;
    private Button btn_testCustomTableCRUD;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testbmob);
        initView();
    }

    private void initView() {
        btn_testUserTableuse = (Button) findViewById(R.id.btn_testUserTableuse);
        btn_testCustomTableCRUD = (Button) findViewById(R.id.btn_testCustomTableCRUD);

        btn_testUserTableuse.setOnClickListener(this);
        btn_testCustomTableCRUD.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_testUserTableuse:
                Intent toUserCenter=new Intent(this, UserLoginActivity.class);
                startActivity(toUserCenter);
                finish();
                break;
            case R.id.btn_testCustomTableCRUD:

                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent toback=new Intent(this, MainActivity.class);
        startActivity(toback);
        finish();

    }
}
