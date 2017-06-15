package com.example.user.vangun;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowVanActivity extends AppCompatActivity {

    private ImageView image;
    private TextView vancar1;
    private TextView vancar1data;
    private Button ButtSet;

    public static final int REQUEST_ANDROID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_van);

        image = (ImageView) findViewById(R.id.image);
        vancar1 = (TextView) findViewById(R.id.vancar1);
        vancar1data = (TextView) findViewById(R.id.vancar1data);

        int photo = getIntent().getIntExtra("image", 0);
        String vanname = getIntent().getStringExtra("vancar1");
        String vandata = getIntent().getStringExtra("vancar1data");

        image.setImageResource(photo);
        vancar1.setText(vanname);
        vancar1data.setText(vandata);

        Log.d("von", "photo =" + photo);
        Log.d("von", "vanname =" + vanname);
        Log.d("von", "vandata =" + vandata);

        initBtn();
    }

    private void initBtn() {
        Button ButtSet = (Button) findViewById(R.id.ButtSet);


        ButtSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView vancar1 = (TextView) findViewById(R.id.vancar1);
                TextView van1data = (TextView) findViewById(R.id.vancar1data);


                String vanName = vancar1.getText().toString();
                String vandata = van1data.getText().toString();

                Intent intent = new Intent(ShowVanActivity.this, Bill.class);

                intent.putExtra("vanName", vanName);
                intent.putExtra("vanData", vandata);

                startActivity(intent);
            }
        });
    }
}


