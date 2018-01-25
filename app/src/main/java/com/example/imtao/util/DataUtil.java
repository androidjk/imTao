package com.example.imtao.util;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.ImageView;

import com.example.imtao.entity.Menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by asus1 on 2018/1/22.
 */

public class DataUtil {

    public static List<ImageView> getHeaderView(Context context, int resourece[]) {
        List<ImageView> images = new ArrayList<>();
        for (int i : resourece) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(i);//传入图标id
            images.add(imageView);
        }
        return images;

    }
    public static List<Menu> getMainMenu(int icons[],String menuName[]){
        List<Menu>menus=new ArrayList<>();
        for (int i=0;i<icons.length;i++){
            Menu menu=new Menu(icons[i],menuName[i]);
            menus.add(menu);
        }
        return menus;
    }
    public static List<Menu> getSecondMenu(int icons[],String name[]){
        List<Menu>list=new ArrayList<>();
        for (int i=0;i<icons.length;i++){
            Menu menu=new Menu(icons[i],name[i]);
            list.add(menu);
        }
        return list;
    }
}
