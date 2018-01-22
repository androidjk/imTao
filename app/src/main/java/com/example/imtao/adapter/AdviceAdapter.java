package com.example.imtao.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.pdf.PdfDocument;
import android.provider.ContactsContract;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by asus1 on 2018/1/22.
 */

public class AdviceAdapter extends PagerAdapter {
    protected Context context;
    protected List<ImageView> list;
    public AdviceAdapter(Context context, List<ImageView>list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return null!=list?list.size():0;
    }
//初始化的方法
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {//判断是否来自Object对象
        return view==object;
    }
//销毁item的方法
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
}
