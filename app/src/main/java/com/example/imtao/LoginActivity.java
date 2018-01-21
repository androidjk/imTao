package com.example.imtao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    protected TextView tv_zhuce,tv_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        tv_zhuce=(TextView)findViewById(R.id.tv_zhuce);
        tv_zhuce.setOnClickListener(this);
        tv_password=(TextView)findViewById(R.id.tv_password);
        tv_password.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_zhuce:
                break;
            case R.id.tv_password:
                break;
        }
    }
}
