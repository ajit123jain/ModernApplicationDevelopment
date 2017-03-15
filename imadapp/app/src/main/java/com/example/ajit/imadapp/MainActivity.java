package com.example.ajit.imadapp;

import android.content.DialogInterface;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    TextView text;
    final String TAG ="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.textView);
        text.setText("new Text");
        edit = (EditText)findViewById(R.id.edit_text);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Button clicked",Toast.LENGTH_LONG).show();
                String EnterdText = edit.getText().toString().trim();
                if(EnterdText.isEmpty()){
                     //give an alert
                    showAlert();
                }
                else{
                  ReplaceText(EnterdText);
                    edit.setText("");
                }
            }
        });
        Log.i(TAG,"Inside Oncreate");
    }
    @Override
     protected void  onResume(){
   super.onResume();
    }
    @Override
    protected void  onPause(){
  super.onPause();
    }
    @Override
    protected void  onDestroy(){
   super.onDestroy();
    }
    private void ReplaceText(String str){
        text.setText(str);
    }
    private void showAlert(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Empty!!");
        builder.setMessage("Nothing to replace");
        builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
            }
        });
        builder.show();
    }
}
