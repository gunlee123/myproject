package com.example.user.vangun;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity implements View.OnClickListener {

    EditText UserName;
    EditText passwordName;

    Button btn1;

    FirebaseAuth mAuth;

    ProgressDialog progressDialog;

    CustomAdapter2 adapter2;
    ViewPager viewPager;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        viewPager = (ViewPager) findViewById(R.id.view_pager2);
        adapter2 = new CustomAdapter2(this);
        viewPager.setAdapter(adapter2);


        UserName = (EditText) findViewById(R.id.UserName);
        passwordName = (EditText) findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        btn1 = (Button) findViewById(R.id.btnRegister);

        btn1.setOnClickListener(this);



    }

    private void starRegister(){
        String email = UserName.getText().toString();
        String password = passwordName.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(register.this, "กดอีกครั้ง" ,Toast.LENGTH_LONG).show(); // fail
        }else {
            progressDialog.setMessage("ระบบกำลังลงทะเบียน"); // Register Please Wait...
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    progressDialog.dismiss();
                    if (!task.isSuccessful()){        // Register fail
                        Toast.makeText(register.this, "ยินดีตอนรับ",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(register.this, ProFile.class);
                        startActivity(i);


                    }else {
                                                        // Regiater Succesful
                        Toast.makeText(register.this, "กดอีกครั้ง",Toast.LENGTH_LONG).show();

                    }

                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btn1){
            starRegister();
        }

    }
}

