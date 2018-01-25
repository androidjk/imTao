package com.example.imtao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imtao.R;
import com.example.imtao.entity.Menu;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by asus1 on 2018/1/25.
 */

public class SecondFlightAdapter extends RecyclerView.Adapter<SecondFlightAdapter.flyViewholder>{

    private List<Menu> menu_flight;
    private Context context;
    public SecondFlightAdapter(Context context,List list){
        this.menu_flight=list;
        this.context=context;
    }
    @Override
    public flyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new flyViewholder(LayoutInflater.from(context).inflate(R.layout.item_main_second,null));
    }

    @Override
    public void onBindViewHolder(flyViewholder holder, int position) {
        Menu menu=menu_flight.get(position);
        holder.imageView.setImageResource(menu.icons);
        holder.textView.setText(menu.menuName);
    }

    @Override
    public int getItemCount() {
        return null!=menu_flight?menu_flight.size():0;
    }

    public class flyViewholder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public flyViewholder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_menu_second);
            textView=itemView.findViewById(R.id.tv_menu_second);
        }
    }
}
