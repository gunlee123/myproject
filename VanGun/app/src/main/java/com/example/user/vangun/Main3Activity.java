package com.example.user.vangun;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    CustomAdapter adapter;
    ViewPager viewPager;

    Button Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new CustomAdapter(this);
        viewPager.setAdapter(adapter);

        Btn = (Button) findViewById(R.id.BtnMain3);


    }

    public void onClickMain3(View view) {
        startActivity(new Intent(this , Main2Activitytwo.class));
        finish();
    }
}
