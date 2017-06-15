package com.example.user.vangun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class LisAdapter extends BaseAdapter {
    private List<van> vanList = new ArrayList<>();
    private Context context;

    LisAdapter(Context context,List<van> vanList){
        this.context = context;
        this.vanList = vanList;
    }
    @Override
    public int getCount() {
        if (vanList==null)
            return  0;
        return vanList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item,parent,false);


        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView vancar1 = (TextView) view.findViewById(R.id.vancar1);
        TextView vancar1data = (TextView) view.findViewById(R.id.vancar1data);

        imageView.setImageResource(vanList.get(position).getPhoto());
        vancar1.setText(vanList.get(position).getDatavanname());
        vancar1data.setText(vanList.get(position).getDatavan());


        return view;
    }
}
