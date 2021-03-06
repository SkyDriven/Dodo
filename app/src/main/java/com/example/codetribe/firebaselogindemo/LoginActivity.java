package com.example.codetribe.firebaselogindemo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.codetribe.firebaselogindemo.Helper.Helper;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by codetribe on 9/15/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText emailInput;
    private  EditText passwordInput;
    private TextView signUpText;
    private TextView loginError;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.hide();
        }
        mAuth = ((FirebaseApplication)getApplication()).getFirebaseAuth();
        ((FirebaseApplication)getApplication()).checkUserLogin(LoginActivity.this);

        loginError = (TextView)findViewById(R.id.login_error);
        emailInput = findViewById(R.id.email);

        passwordInput = findViewById(R.id.password);

        signUpText  = findViewById(R.id.register);
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(signUpIntent);
              }
        });

        final Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = emailInput.getText().toString();
                String enteredPassword = passwordInput.getText().toString();
                if(TextUtils.isEmpty(enteredEmail)|| TextUtils.isEmpty(enteredPassword))
                {
                    Helper.displayMessageToast(LoginActivity.this,"Login filelds must be filled");
                    return;
                }
                if(Helper.isValidEmail(enteredEmail))
                {
                    Helper.displayMessageToast(LoginActivity.this,"Invalidate email entered");
                    return;;
                }
                ((FirebaseApplication)getApplication().loginAUser(LoginActivity.this,enteredEmail,enteredPassword,loginError));

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(((FirebaseApplication)getApplication()).mAuthListener != null)
        {

        }
    }
}
