package com.example.imtao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.imtao.R;
import com.example.imtao.adapter.AdviceAdapter;
import com.example.imtao.adapter.RecyclerViewAdapter;
import com.example.imtao.adapter.SecondFlightAdapter;
import com.example.imtao.util.DataUtil;


public class menu_main_fragment extends Fragment {
    int views[] = {R.mipmap.header_pic_ad1, R.mipmap.header_pic_ad2};
    int menusId[] = {R.mipmap.menu_airport, R.mipmap.menu_car, R.mipmap.menu_course, R.mipmap.menu_hatol,
            R.mipmap.menu_nearby, R.mipmap.menu_ticket, R.mipmap.menu_train, R.mipmap.menu_trav};
    String menusName[];
    protected ViewPager viewPager;
    protected RecyclerView main_menu;
    protected RecyclerView second_flight;
    private int icons[]={R.mipmap.menu_second_airport,R.mipmap.menu_second_play,R.mipmap.menu_second_quan};
    private String names[];

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        adviceMenu();
       firstMenu();
        secondMenu();
    }

    private void initViews() {
        viewPager = (ViewPager) getView().findViewById(R.id.main_vp_guanggao);
        main_menu = (RecyclerView) getView().findViewById(R.id.main_menu_recyclerview);
    }
    public void adviceMenu(){
        AdviceAdapter adviceAdapter = new AdviceAdapter(getActivity(), DataUtil.getHeaderView(getActivity(), views));
        viewPager.setAdapter(adviceAdapter);
    }
    public void firstMenu(){
        menusName = this.getActivity().getResources().getStringArray(R.array.menusName);
        RecyclerViewAdapter menuAdapter = new RecyclerViewAdapter(getActivity(), DataUtil.getMainMenu(menusId, menusName));
        main_menu.setLayoutManager(new GridLayoutManager(this.getContext(), 4));
        main_menu.setAdapter(menuAdapter);
    }
    public void secondMenu(){
        second_flight = (RecyclerView) getView().findViewById(R.id.menu_second_flight);
        names=this.getActivity().getResources().getStringArray(R.array.second_flight);
        SecondFlightAdapter secondFlightAdapter=new SecondFlightAdapter(getActivity(), DataUtil.getSecondMenu(icons,names));
        second_flight.setLayoutManager(new GridLayoutManager(this.getContext(),3));
        second_flight.setAdapter(secondFlightAdapter);
    }
}
