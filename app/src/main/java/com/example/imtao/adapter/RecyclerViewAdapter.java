package com.example.imtao.adapter;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imtao.R;
import com.example.imtao.entity.Menu;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by asus1 on 2018/1/23.
 */


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder>{

    private Context context;
    private List<Menu>menus;
    public RecyclerViewAdapter(Context context,List menus){
        this.context=context;
        this.menus=menus;
    }

    /**
     * 创建ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_menu,null));
    }

    /**
     * 绑定viewHolder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

        Menu menu= menus.get(position);
        holder.menuImage.setImageResource(menu.icons);
        holder.menuText.setText(menu.menuName);
    }

    @Override
    public int getItemCount() {
        return null!=menus?menus.size():0;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        public ImageView menuImage;
        private TextView menuText;
        public viewHolder(View itemView) {
            super(itemView);
            menuImage=(ImageView)itemView.findViewById(R.id.iv_menu);
            menuText=(TextView)itemView.findViewById(R.id.tv_menu);
        }
    }
}
