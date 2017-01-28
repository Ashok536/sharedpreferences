package com.example.ashok.shared;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
      EditText ed1,ed2;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        sp=getSharedPreferences("MyPrefs",0);
        String name=sp.getString("name","");
        int age=sp.getInt("age",0);
        ed1.setText(name);
        ed2.setText(""+age);
    }
    public void onStop()
    {
        String s1=ed1.getText().toString();
        String s2=ed2.getText().toString();
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("name",s1);
        if(s2.length()>0)
        {
            editor.putInt("age",Integer.parseInt(s2));
        }
        editor.commit();
    }
}
