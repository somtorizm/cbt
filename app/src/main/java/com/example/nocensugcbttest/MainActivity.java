package com.example.nocensugcbttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
        ViewPager viewPager;
        PagerAdapter adapter;
        ProgressBar progressBar;
        Toolbar toolbar;
        DialogInterface.OnClickListener clickListener;
        Button next,previous;
        TextView Question_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Make Device Full Screen
        Window window = getWindow();

        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setLightStatusBar(window.getDecorView(), window);

        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.app_bar);
        toolbar.setTitle("");
        toolbar.setSubtitle("Psychology (104)");
        setSupportActionBar(toolbar);


        viewPager = findViewById(R.id.viewPager);
        next = findViewById(R.id.next_button);
        previous = findViewById(R.id.previous_btn);
        progressBar = findViewById(R.id.progress_bar);
        Question_no = findViewById(R.id.question_no);

        List<Questions> vic = new ArrayList<>();
        Questions ques1 = new Questions();
        Questions questions2 = new Questions();
        questions2.setQuestion("Francis (2006) categorized universal human rights into Francis (2006) categorized universal human rights into Francis (2006) categorized universal human rights into Francis (2006) categorized universal human rights into Francis (2006) categorized universal human rights into Francis (2006) categorized universal human rights into Francis (2006) categorized universal human rights into ?________");
        questions2.setAns2("2");
        questions2.setAns3("4");
        questions2.setAns4("5");

        ques1.setAns1("3");
        ques1.setQuestion("Francis (2006) categorized universal human rights into ?________");
        ques1.setAns2("2");
        ques1.setAns3("4");
        ques1.setAns4("5");
        vic.add(ques1);
        vic.add(questions2);
        vic.add(ques1);
        vic.add(questions2);
        adapter = new SwipeStackAdapter(vic,this);





        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position == 0) previous.setVisibility(View.INVISIBLE);
                else previous.setVisibility(View.VISIBLE);
                if(position == vic.size()-1) next.setText("Finish");
                else next.setText("Next");
                if(position == 0 && position ==vic.size()-1){
                    next.setVisibility(View.VISIBLE);
                    next.setText("Finish");
                }
                progressBar.setProgress(position);
                setQuestion_no(Question_no,position,vic.size());

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        int pos = viewPager.getCurrentItem();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current_position = viewPager.getCurrentItem();
                if(current_position <= vic.size()){
                    viewPager.setCurrentItem((current_position +1));
                }
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int current_position = viewPager.getCurrentItem();
                if(current_position != 0 && current_position <= vic.size()){
                    viewPager.setCurrentItem((current_position -1));
                }
            }
        });

        progressBar.setMax(vic.size()-1);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }
    public static void setLightStatusBar(View view, Window window) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);

            window.setStatusBarColor(Color.WHITE);
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(this, "Clicked Settings", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
    private void setQuestion_no(TextView view, int no, int total){
        view.setText(String.format("Question :%d/%d", (no+1), total));
    }
}