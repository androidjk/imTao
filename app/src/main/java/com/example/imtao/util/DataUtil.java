package com.example.imtao.util;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by asus1 on 2018/1/22.
 */

public class DataUtil {

    public static List<ImageView> getHeaderView(Context context ,int resourece[]){
        List<ImageView>images=new ArrayList<>();
        for (int i:resourece){
            ImageView imageView=new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(i);//传入图标id
            images.add(imageView);
        }
        return images;

    }
}
