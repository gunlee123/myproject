package com.example.user.vangun;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.security.acl.Group;

public class Bill extends AppCompatActivity {

    RadioGroup btntime;

    RadioButton btntime1;
    RadioButton btntime2;
    RadioButton btntime3;
    RadioButton btntime4;
    RadioButton btntime5;
    RadioButton btntime6;
    RadioButton btntime7;


    Button btnSet1;
    Button btnSet2;

    TextView dtData;
    TextView dtVanSet;
    TextView dtTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);



        btntime1 = (RadioButton) findViewById(R.id.radioButton);
        btntime2 = (RadioButton) findViewById(R.id.radioButton2);
        btntime3 = (RadioButton) findViewById(R.id.radioButton3);
        btntime4 = (RadioButton) findViewById(R.id.radioButton4);
        btntime5 = (RadioButton) findViewById(R.id.radioButton5);
        btntime6 = (RadioButton) findViewById(R.id.radioButton6);
        btntime7 = (RadioButton) findViewById(R.id.radioButton7);

        dtData = (TextView) findViewById(R.id.DataTime1);
        dtVanSet = (TextView) findViewById(R.id.nameSet);
        dtTime = (TextView) findViewById(R.id.textView4);

        btnSet1 = (Button) findViewById(R.id.ButtSet1);

        initial();


    }
    private void initial() {
        Intent intent = this.getIntent();

        String vanName = intent.getStringExtra("vanName");
        String vanData = intent.getStringExtra("vanData");

        TextView nameSet = (TextView) findViewById(R.id.nameSet);
        TextView dataSet = (TextView) findViewById(R.id.text_van_data);


        nameSet.setText(vanName);
        dataSet.setText(vanData);

        initbtn();
    }
    private void initbtn () {
        Button btnSet1 = (Button) findViewById(R.id.ButtSet1);

        btnSet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView nameSet = (TextView) findViewById(R.id.nameSet);
                TextView text_van_data = (TextView) findViewById(R.id.text_van_data);
                RadioButton strjenis = (RadioButton) findViewById(R.id.radioButton);



                String NameSet = nameSet.getText().toString();
                String Text_Van_Data = text_van_data.getText().toString();
                String Strjenis = null;

                if (btntime1.isChecked()){
                    Strjenis = btntime1.getText().toString();
                }else if (btntime2.isChecked()){
                    Strjenis = btntime2.getText().toString();

                }else if (btntime3.isChecked()){
                    Strjenis = btntime3.getText().toString();

                }else if (btntime4.isChecked()){
                    Strjenis = btntime4.getText().toString();

                }else if (btntime5.isChecked()){
                    Strjenis = btntime5.getText().toString();

                }else if (btntime6.isChecked()){
                    Strjenis = btntime6.getText().toString();

                }else if (btntime7.isChecked()){
                    Strjenis = btntime7.getText().toString();

                }else {
                    dtTime.setText("โปรเลือกเวลารถ");
                }



                Intent intent = new Intent(Bill.this,BillSet.class);



                intent.putExtra("NameSett",NameSet);
                intent.putExtra("Text_Van_Data",Text_Van_Data);
                intent.putExtra("Strjenis",Strjenis);


                startActivity(intent);


                finish();


            }
        });
    }




}
