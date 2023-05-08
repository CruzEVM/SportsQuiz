package com.example.sportsquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Slider_Adapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public int[] list_img ={
            R.drawable.americano,
            R.drawable.futbol,
            R.drawable.basquelbol,
            R.drawable.f1

    };

    public String[] list_title = {
            "HEADING 1",
            "HEADING 2",
            "HEADING 3",
            "HEADING 4"
    };

    public String[] list_description ={
            "DESCRIPTION 1",
            "DESCRIPTION 2",
            "DESCRIPTION 3",
            "DESCRIPTION 4"

    };

    public Slider_Adapter(Context context){
        this.context = context;
    }


    @Override
    public int getCount() {
        return list_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slider, container, false);
        ImageView imageView = view.findViewById(R.id.slide_img);
        TextView heading_text = view.findViewById(R.id.slider_heading);
        TextView des_text = view.findViewById(R.id.slider_des);
        imageView.setImageResource(list_img[position]);
        heading_text.setText(list_title[position]);
        des_text.setText(list_description[position]);
        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
