package com.example.apnanotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    EditText etForgotPassword;
    Button btnPasswordRecover;
    TextView tvGobacktologin;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        getSupportActionBar().hide();
        etForgotPassword = findViewById(R.id.etForgotPassword);
        btnPasswordRecover = findViewById(R.id.btnPasswordRecover);
        tvGobacktologin = findViewById(R.id.tvGoBackToLogin);
        firebaseAuth = FirebaseAuth.getInstance();

        tvGobacktologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPassword.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnPasswordRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = etForgotPassword.getText().toString().trim();
                if(mail.isEmpty()){
                    Toast.makeText(ForgetPassword.this, "Enter your mail first!", Toast.LENGTH_SHORT).show();
                }
                else {
                    // we will send email.
                    firebaseAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgetPassword.this, "Mail sent, You can recover your password using mail.", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ForgetPassword.this,MainActivity.class));
                                finish();
                            }
                            else
                            {
                                Toast.makeText(ForgetPassword.this, "Email is wrong or Account doesn't exist.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}