package com.example.user.vangun;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class BillSet extends AppCompatActivity {

    TextView SetVanName;
    TextView SetVanTime;
    TextView SetVanData;

    EditText ET;
    EditText ETB;

    Button btn;

    //Firebase Fb;

    DatabaseReference mR;


    //int i ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_set);

        SetVanName = (TextView) findViewById(R.id.SetVanName);
        SetVanTime = (TextView) findViewById(R.id.SetVanTime);
        SetVanData = (TextView) findViewById(R.id.SetVanData);

        ET = (EditText) findViewById(R.id.editText3);
        ETB = (EditText) findViewById(R.id.editText4);

        btn = (Button) findViewById(R.id.btnBillSet);

        //Firebase.setAndroidContext(this);

        mR = FirebaseDatabase.getInstance().getReference().child("counter");



       // i = 1;


       // Fb = new Firebase("https://mdatabasevan.firebaseio.com/counter/counter");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseGun();

                startActivity(new Intent(BillSet.this , ProFile.class));
                finish();
            }
        });


        initial();

    }

    private void DatabaseGun() {
        String key = ET.getText().toString();
        String key2 = ETB.getText().toString();

        String value = SetVanName.getText().toString();
        String value1 = SetVanTime.getText().toString();
        String value2 = SetVanData.getText().toString();

        DatabaseReference newPost = mR.push();

        newPost.child("VanName").setValue(value);
        newPost.child("VanData").setValue(value2);
        newPost.child("VanTime").setValue(value1);
        newPost.child("User").setValue(key);
        newPost.child("Number").setValue(key2);

    }


    private void initial() {
        Intent intent = this.getIntent();

        String NameSett = intent.getStringExtra("NameSett");
        String Text_Van_Data = intent.getStringExtra("Text_Van_Data");
        String DtTime = intent.getStringExtra("DtTime");
        String strjenis = intent.getStringExtra("Strjenis");



        TextView SetVanName = (TextView) findViewById(R.id.SetVanName);
        TextView SetVanData = (TextView) findViewById(R.id.SetVanData);
        TextView SetVanTime = (TextView) findViewById(R.id.SetVanTime);
        TextView Strjenis = (TextView) findViewById(R.id.SetVanTime);



        SetVanName.setText(NameSett);
        SetVanData.setText(Text_Van_Data);
        Strjenis.setText(strjenis);



    }

}
