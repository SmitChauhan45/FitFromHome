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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupPage extends AppCompatActivity {
    EditText email,password,repassword,phonenumber,name;
    TextView login;
    CardView register;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        //start
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        name=findViewById(R.id.yourname);
        phonenumber=findViewById(R.id.phone);
        email=findViewById(R.id.username);
        password=findViewById(R.id.passwordsingup);
        repassword=findViewById(R.id.repass);

        login =findViewById(R.id.loginbtntxt);
        register = findViewById(R.id.singupbtn);
        progressDialog=new ProgressDialog(this);
       // DBms=new DBhelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),LoginPage.class));
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            public boolean isEmailValid() {
                // Regular expression pattern to match email format
                String valemaild=email.getText().toString().trim();
                String emailRegex = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
                // Create a pattern object from the regex pattern
                Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
                // Create a matcher object to match the input email against the pattern
                Matcher matcher = pattern.matcher(valemaild);
                // Return true if the input email matches the pattern, false otherwise
                if(!matcher.matches())
                {
                    email.setError("Invalid Type ");
                }
                return matcher.matches();
            }
            private Boolean validpassword()
            {
                String valpass=password.getText().toString().trim();
                String pwval="^"+
                        "(?=.*[a-zA-z])"+
                        "(?=.*[@#$%^&*=])"+
                        "(?=\\S+$)"+
                        ".{4,}"+
                        "$";
                if(valpass.isEmpty()){
//                    password.setError("Field cannot be empty");
                    Toast.makeText(SignupPage.this, "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else if(!valpass.matches(pwval)){
//                    password.setError("Password is too weak");
                    Toast.makeText(SignupPage.this, "Password is too weak", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else if(valpass.length()<8){
//                    password.setError("Password Must be in 8 character");
                    Toast.makeText(SignupPage.this, "Password Must be greater then or equal to 8 character", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else{
                    password.setError(null);
                    return true;
                }
            }
            @Override
            public void onClick(View view) {
                if(!isEmailValid() | !validpassword())
                    return;
                String emaild=email.getText().toString().trim();
                String passd=password.getText().toString().trim();
                String repassd=repassword.getText().toString().trim();
                String named=name.getText().toString();
                String Phoned=phonenumber.getText().toString();
                if(TextUtils.isEmpty(emaild) || TextUtils.isEmpty(passd) || TextUtils.isEmpty(repassd))
                    Toast.makeText(SignupPage.this, "All fields are Required", Toast.LENGTH_SHORT).show();

                else{
                    progressDialog.show();
                    progressDialog.setTitle("Please Wait");
                    firebaseAuth.createUserWithEmailAndPassword(emaild,repassd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(SignupPage.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getBaseContext(),MainActivity.class));
                                finish();
                            progressDialog.cancel();
                            firebaseFirestore.collection("users").document(Objects.requireNonNull(FirebaseAuth.getInstance().getUid())).set(new userModel(Phoned,named,emaild,passd));
                        }
                    })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SignupPage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    progressDialog.cancel();
                                }
                            });
                }
            }
        });
    }
}