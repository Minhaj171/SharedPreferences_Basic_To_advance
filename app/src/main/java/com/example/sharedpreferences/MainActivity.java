package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button btn, btnViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //write from shared preferences
//        editor.putBoolean("isOpenedFirstTime", true);
//        editor.putString("key","value");
//        editor.putInt("intKey",1);
//        editor.putFloat("floatKey",10);
//        editor.putLong("longKey",10000);
//        editor.apply();

        //Read from shared preferences
//        prefs.getString("key","value");
//        prefs.getInt("intKey",0);
//        prefs.getFloat("floatKey",0);
//        prefs.getBoolean("isOpenedFirstTime", false);
//        prefs.getLong("longKey",0);
//        editor.apply();


        //delete from shared preferences
//        editor.remove("intKey");
//        editor.apply();

        //delete everything from shared preferences
//        editor.clear();
//        editor.apply();

        textView = findViewById(R.id.tv);
        editText = findViewById(R.id.edit_txt);
        btn = findViewById(R.id.button);
        btnViewData = findViewById(R.id.button2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getEditableText().toString();
                SharedPreferences prefs = getSharedPreferences(
                        "com.example.sharedpreferences.users", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("msg", message);
                editor.apply();
                editText.setText(" ");
                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences(
                        "com.example.sharedpreferences.users", Context.MODE_PRIVATE);
               String getMsg = prefs.getString("msg","value");
               textView.setText(getMsg);
            }
        });





    }
}