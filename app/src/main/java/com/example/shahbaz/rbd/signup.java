package com.example.shahbaz.rbd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    private EditText txtEmailAddress;
    private EditText txtPassword;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        txtEmailAddress = (EditText) findViewById(R.id.txtEmailRegistration);
        txtPassword = (EditText) findViewById(R.id.txtPasswordRegistration);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void btnRegistrationUser_Click(View v) {

        final String _txtEmailAddress = txtEmailAddress.getText().toString().trim();
        final String _txtPassword = txtPassword.getText().toString().trim();

        if(TextUtils.isEmpty(_txtEmailAddress) || TextUtils.isEmpty(_txtPassword) )
        {
            if(TextUtils.isEmpty(_txtEmailAddress))
            {
                txtEmailAddress.setError("Type Email");
                txtEmailAddress.requestFocus();
                return;
            }
            if(TextUtils.isEmpty(_txtPassword))
            {
                txtPassword.setError("Type Password");
                txtPassword.requestFocus();
                return;
            }
        }

        else {
            final ProgressDialog progressDialog = ProgressDialog.show(signup.this, "Please wait...", "Processing...", true);
            firebaseAuth.createUserWithEmailAndPassword(_txtEmailAddress,_txtPassword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();

                            if (task.isSuccessful()) {

                                Toast.makeText(signup.this, "Registration successful", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(signup.this, login.class);
                                startActivity(i);
                            } else {
                                Log.e("ERROR", task.getException().toString());
                                Toast.makeText(signup.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
}
