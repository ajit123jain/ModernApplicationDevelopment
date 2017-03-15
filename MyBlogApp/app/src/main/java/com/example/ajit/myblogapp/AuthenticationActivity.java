package com.example.ajit.myblogapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AuthenticationActivity extends AppCompatActivity {
    EditText username,password;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.userpassword);
        Button signin= (Button)findViewById(R.id.button_signin);
        Button register = (Button)findViewById(R.id.button_register);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (isFormValid()){

                performSignIn();
            }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (isFormValid()){
                 performRegistration();
             }
            }
        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(false);
        progressDialog.setMessage("Please Wait...");



    }
    private  boolean isFormValid(){
        if(username.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"Username can not be empty",Toast.LENGTH_LONG).show();
            return false;
        }
        if (password.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"Username can not be empty",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    private void performSignIn(){
     //mock an apicall
        new SignInTask().execute(username.getText().toString(),password.getText().toString());
    }
    private void performRegistration(){

    }
    private void showProgressDialog(Boolean shouldShould){
         if(shouldShould){
             progressDialog.show();
         }
        else {
           progressDialog.dismiss();
         }
    }
    private  void showAlert(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            }
        });
        builder.show();
    }
    class SignInTask extends AsyncTask<String,Void,Boolean>{
        String mockUsername = "test";
        String mockPassword = "password";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgressDialog(true);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            showProgressDialog(false);
            if(aBoolean){
              showAlert("Welcome","You have successfully signed in");
            }
            else {
                showAlert("Failed","Username / password Incorrect");
            }
        }

        @Override
        protected Boolean doInBackground(String... params) {
            String username = params[0];
            String password = params[1];
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Do something woth this
            return username.contentEquals(mockUsername) && password.contentEquals(mockPassword);




        }
    }
}
