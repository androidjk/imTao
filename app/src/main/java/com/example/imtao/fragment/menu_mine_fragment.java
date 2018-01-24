package com.example.imtao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.imtao.LoginActivity;
import com.example.imtao.MainActivity;
import com.example.imtao.R;

/**
 * 我的
 */

public class menu_mine_fragment extends Fragment implements View.OnClickListener {
    protected Button bt_login;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_mine, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        setClickListeners();
    }

    //获取布局
    private void initViews() {
        bt_login = (Button) getView().findViewById(R.id.mine_login);
    }

    //绑定监听
    private void setClickListeners() {
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_login://登录
                Intent login = new Intent(getContext(), LoginActivity.class);
                startActivity(login);
                break;
        }
    }
}
