package com.example.fitnesssgp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {
    ImageView shwpasslogin;
    EditText emailid, passw;
    CardView btnlogin;
    TextView fgpas;
    TextView ca;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    //    DBhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        //start
        emailid = findViewById(R.id.emailedt);
        passw = findViewById(R.id.passwordedt);
        btnlogin = findViewById(R.id.loginbtn);
//        DB =new DBhelper(this);
        ca = findViewById(R.id.createac);
        fgpas=findViewById(R.id.fgpassword);
        progressDialog=new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        btnlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String mail = emailid.getText().toString().trim();
                String pass = passw.getText().toString().trim();
                progressDialog.show();
                progressDialog.setTitle("Please Wait");
                if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass))
                    Toast.makeText(LoginPage.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                else {
                    firebaseAuth.signInWithEmailAndPassword(mail, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();
                            startActivity(new Intent(getBaseContext(), MainActivity.class));
                            finish();
                        }
                    })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    progressDialog.cancel();
                                    Toast.makeText(LoginPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
        
        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), SignupPage.class));
                finish();
            }
        });

        fgpas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailid.getText().toString();
                if (!TextUtils.isEmpty(email)) {
                    FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(LoginPage.this, "Password reset email sent", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(LoginPage.this, "Failed to send password reset email", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(LoginPage.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}