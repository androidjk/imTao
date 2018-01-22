package com.example.imtao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.imtao.R;
import com.example.imtao.adapter.AdviceAdapter;
import com.example.imtao.util.DataUtil;


public class menu_main_fragment extends Fragment{
    int views[]={R.mipmap.header_pic_ad1,R.mipmap.header_pic_ad2};
    protected ViewPager viewPager;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_main,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager=(ViewPager)getView().findViewById(R.id.main_vp_guanggao);
        AdviceAdapter adviceAdapter=new AdviceAdapter(getActivity(),DataUtil.getHeaderView(getActivity(),views));
        viewPager.setAdapter(adviceAdapter);
    }
}
