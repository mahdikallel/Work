package com.example.dmk.workfinder;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends Activity implements View.OnClickListener {

    private Button mBack;
    private Button mCreate;
    private EditText fname;
    private EditText lname;
    private EditText email;
    private EditText login;
    private EditText pwd;
    private EditText work;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);
        mBack =(Button)findViewById(R.id.btn_back);
        mCreate =(Button)findViewById(R.id.btn_register);
        mCreate.setOnClickListener(this);
        mBack.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                backToSignIn();
            case R.id.btn_register:
                register();
        break;
        }


    }
    private void backToSignIn(){
        Intent i= new Intent(getApplicationContext(),AuthentificationActivity.class);
        startActivity(i);
        finish();
    }

    private void register()
    {

        Log.v("----->"," REgisterrrr");
        ParseUser p = new ParseUser();
        fname=(EditText)findViewById(R.id.input_first_name);
        lname=(EditText)findViewById(R.id.input_last_name);
        email=(EditText)findViewById(R.id.input_email);
        login=(EditText)findViewById(R.id.input_login);
        pwd=(EditText)findViewById(R.id.input_password);
        work=(EditText)findViewById(R.id.work);

        p.setEmail(email.getText().toString());
        p.setUsername(login.getText().toString());
        p.setPassword(pwd.getText().toString());

        p.put("work",work.getText().toString());

        p.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                } else {
                   e.getMessage();
                }
            }
        });

    }


}
