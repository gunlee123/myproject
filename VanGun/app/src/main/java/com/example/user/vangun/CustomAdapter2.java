package com.example.user.vangun;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by user on 14/5/2560.
 */
public class CustomAdapter2 extends PagerAdapter {
    int[] imgs = {R.mipmap.register1,R.mipmap.register2,R.mipmap.register3,R.mipmap.register4};
    LayoutInflater inflater;
    Context ctx;


    CustomAdapter2(Context ctx) {
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
        View v = inflater.inflate(R.layout.swipe2,container,false);
        ImageView img = (ImageView) v.findViewById(R.id.imageView6);
        img.setImageResource(imgs[position]);
        container.addView(v);
        return v;

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}

