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



public class  login extends AppCompatActivity {

    private EditText txtEmailLogin;
    private EditText txtPwd;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmailLogin = (EditText) findViewById(R.id.txtEmailLogin);
        txtPwd = (EditText) findViewById(R.id.txtPasswordLogin);
        firebaseAuth = FirebaseAuth.getInstance();

    }
    public void btnUserLogin_Click(View v) {
        final String _txtEmailLogin = txtEmailLogin.getText().toString().trim();
        final String _txtPwd = txtPwd.getText().toString().trim();

        if(TextUtils.isEmpty(_txtEmailLogin) || TextUtils.isEmpty(_txtPwd) )
        {
            if(TextUtils.isEmpty(_txtEmailLogin))
            {
                txtEmailLogin.setError("Type Email");
                txtEmailLogin.requestFocus();
                return;
            }
            if(TextUtils.isEmpty(_txtPwd))
            {
                txtPwd.setError("Type Password");
                txtPwd.requestFocus();
                return;
            }
        }
        else{
            final ProgressDialog progressDialog = ProgressDialog.show(login.this, "Please wait...", "Proccessing...", true);

            firebaseAuth.signInWithEmailAndPassword(_txtEmailLogin,_txtPwd)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();

                            if (task.isSuccessful()) {
                                Toast.makeText(login.this, "Login successful", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(login.this, Homemain.class);
                                i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                                startActivity(i);
                            } else {
                                Log.e("ERROR", task.getException().toString());
                                Toast.makeText(login.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                            }
                        }
                    });
        }
    }

    public void gotoactivity4(View view){
        Intent intent = new Intent(login.this, signup.class);
        startActivity(intent);
    }
}
