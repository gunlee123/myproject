package com.example.user.vangun;

import android.accounts.Account;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Main2Activitytwo extends AppCompatActivity {

    Button FB;
    Button EM;
    Button RT;

    // ตัวเเปรอง google


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_activitytwo);

        //FB = (Button) findViewById(R.id.button8);
        EM = (Button) findViewById(R.id.button7);
        RT = (Button) findViewById(R.id.button);


    }




    //ปุ่มกดยกเว้น Google

    public void onClickEmail(View view) {
        startActivity(new Intent(Main2Activitytwo.this , login.class));
    }

    public void onClickFacebook(View view) {
        startActivity(new Intent(Main2Activitytwo.this , LoginGoogle2.class));
        finish();
    }

    public void onClickRegister(View view) {
        startActivity(new Intent(Main2Activitytwo.this , register.class));
    }

    public void onClickGoogle(View view) {
        startActivity(new Intent(Main2Activitytwo.this , LoginGoogle.class));
        finish();
    }

    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("ทางออก");
        dialog.setIcon(R.drawable.admin);
        dialog.setCancelable(true);
        dialog.setMessage("คุณต้องการออกจากระบบหรือไม่");
        dialog.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialog.setNegativeButton("ไม่ออก", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialog.show();

    }
}
