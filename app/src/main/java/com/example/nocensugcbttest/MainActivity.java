package com.example.nocensugcbttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import link.fls.swipestack.SwipeStack;

public class MainActivity extends AppCompatActivity {
    SwipeStack swipeStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeStack = findViewById(R.id.swipeStack);
        SwipeStack();
    }

    private void SwipeStack(){
        List<String> names = new ArrayList<>();
        names.add("Somto");
        names.add("Obiajulu");
        names.add("Igwebuike");
        names.add("Ajulu");
        swipeStack.setAdapter(new SwipeStackAdapter(names,this));
        swipeStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {
            }

            @Override
            public void onViewSwipedToRight(int position) {

            }

            @Override
            public void onStackEmpty() {

            }
        });

    }

}