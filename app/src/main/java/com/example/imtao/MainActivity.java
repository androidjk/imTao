package com.example.imtao;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.imtao.fragment.menu_find_fragment;
import com.example.imtao.fragment.menu_main_fragment;
import com.example.imtao.fragment.menu_mine_fragment;

public class MainActivity extends AppCompatActivity {
    private LinearLayout menu_main,menu_find,menu_mine;
    protected Fragment ft_main=new menu_main_fragment();//首页
    protected Fragment ft_find=new menu_find_fragment();//查找页
    protected Fragment ft_mine=new menu_mine_fragment();//个人信息页

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getSupportFragmentManager()//获取管理类
                .beginTransaction()//开启事务，事务添加
                .add(R.id.container_context,ft_main)
                .add(R.id.container_context,ft_find)
                .hide(ft_find)
                .add(R.id.container_context,ft_mine)
                .hide(ft_mine)
                .commit();//提交
    }

    /**
     * 初始化视图，绑定监听器
     */
    private void initViews() {
        menu_main=(LinearLayout) findViewById(R.id.menu_main);
        menu_main.setOnClickListener(new ButtonClickListener());
        menu_find=(LinearLayout) findViewById(R.id.menu_find);
        menu_find.setOnClickListener(new ButtonClickListener());
        menu_mine=(LinearLayout) findViewById(R.id.menu_mine);
        menu_mine.setOnClickListener(new ButtonClickListener());

    }

    public class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.menu_main:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .show(ft_main)
                            .hide(ft_find)
                            .hide(ft_mine)
                            .commit();
                    break;
                case R.id.menu_find:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .hide(ft_main)
                            .show(ft_find)
                            .hide(ft_mine)
                            .commit();
                    break;
                case R.id.menu_mine:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .hide(ft_main)
                            .hide(ft_find)
                            .show(ft_mine)
                            .commit();
                    break;
            }
        }
    }
}
