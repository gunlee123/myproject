package com.example.user.vangun;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 11/5/2560.
 */
public class CustomAdapter extends PagerAdapter {

    int[] imgs = {R.drawable.main1,R.drawable.main2,R.drawable.main3};
    LayoutInflater inflater;
    Context ctx;


    CustomAdapter(Context ctx) {
        this.ctx = ctx;
    }
    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==(LinearLayout)object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.swipe,container,false);
        ImageView img = (ImageView) v.findViewById(R.id.imageView5);
        img.setImageResource(imgs[position]);
        container.addView(v);
        return v;

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
