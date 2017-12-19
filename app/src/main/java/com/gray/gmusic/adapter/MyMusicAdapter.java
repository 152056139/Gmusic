package com.gray.gmusic.adapter;

import android.content.Context;
import android.media.tv.TvView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gray.gmusic.R;

import java.util.ArrayList;

/**
 * Created by gray on 17-12-19.
 */

public class MyMusicAdapter extends BaseAdapter {
    //数据源
    private ArrayList<String> musicArrayList;
    private Context context;
    private ViewHolder viewHolder;
    //视图扩充器
    private LayoutInflater layoutInflater;

    public MyMusicAdapter(ArrayList<String> musicArrayList, Context context) {
        this.musicArrayList = musicArrayList;
        this.context = context;

        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return musicArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.tvMusicName = (TextView) convertView.findViewById(R.id.tv_item_music_name);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.tvMusicName.setText(musicArrayList.get(i));
        return convertView;
    }

    //创建对象持有者
    class ViewHolder {
        private TextView tvMusicName;
    }
}
