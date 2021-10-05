package com.example.nocensugcbttest;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SwipeStackAdapter extends PagerAdapter{
    private List<Questions> mData;
    RadioButton btn1,btn2,btn3,btn4;
    TextView question_txt;
    Context context;
    boolean hasSelected = false;


    public SwipeStackAdapter(List<Questions> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view = inflater.inflate(R.layout.slide,container,false);
       question_txt = view.findViewById(R.id.question_txt_view);


       btn1 = view.findViewById(R.id.radioButton2);
       btn2 = view.findViewById(R.id.radioButton3);
       btn3  = view.findViewById(R.id.radioButton4);
       btn4 = view.findViewById(R.id.radioButton5);

       Initialize(position);



    container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout) object);
    }

    private void Initialize(int pos){
        question_txt.setText(mData.get(pos).getQuestion());
        btn1.setText(mData.get(pos).getAns1());
        btn2.setText(mData.get(pos).getAns2());
        btn3.setText(mData.get(pos).getAns3());
        btn4.setText(mData.get(pos).getAns4());


    }







}
