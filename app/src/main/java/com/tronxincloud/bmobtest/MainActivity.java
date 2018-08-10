package com.tronxincloud.bmobtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tronxincloud.bmobtest.bmob.BmobTestActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_testBmob;
    private Button btn_testJPushService;
    private Button btn_testAmapService;
    private Button btn_testXFyun;
    private Button btn_testAzure;
    private Button btn_testTheme;
    private Button btn_testQiniu;
    private Button btn_testDataEncryptionAndDecryption;
    private Button btn_testApkVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_testBmob = (Button) findViewById(R.id.btn_testBmob);
        btn_testJPushService = (Button) findViewById(R.id.btn_testJPushService);
        btn_testAmapService = (Button) findViewById(R.id.btn_testAmapService);
        btn_testXFyun = (Button) findViewById(R.id.btn_testXFyun);
        btn_testAzure = (Button) findViewById(R.id.btn_testAzure);
        btn_testTheme = (Button) findViewById(R.id.btn_testTheme);
        btn_testQiniu = (Button) findViewById(R.id.btn_testQiniu);
        btn_testDataEncryptionAndDecryption = (Button) findViewById(R.id.btn_testDataEncryptionAndDecryption);
        btn_testApkVerify = (Button) findViewById(R.id.btn_testApkVerify);

        btn_testBmob.setOnClickListener(this);
        btn_testJPushService.setOnClickListener(this);
        btn_testAmapService.setOnClickListener(this);
        btn_testXFyun.setOnClickListener(this);
        btn_testAzure.setOnClickListener(this);
        btn_testTheme.setOnClickListener(this);
        btn_testQiniu.setOnClickListener(this);
        btn_testDataEncryptionAndDecryption.setOnClickListener(this);
        btn_testApkVerify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_testBmob:
                Intent totestbmob=new Intent(this, BmobTestActivity.class);
                startActivity(totestbmob);
                finish();
                break;
            case R.id.btn_testJPushService:

                break;
            case R.id.btn_testAmapService:

                break;
            case R.id.btn_testXFyun:

                break;
            case R.id.btn_testAzure:

                break;
            case R.id.btn_testTheme:

                break;
            case R.id.btn_testQiniu:

                break;
            case R.id.btn_testDataEncryptionAndDecryption:

                break;
            case R.id.btn_testApkVerify:

                break;
        }
    }

    @Override
    public void onBackPressed() {


    }
}
