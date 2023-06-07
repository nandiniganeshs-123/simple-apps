package com.master.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.master.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler clickHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person person = new Person("Jack","Jack005@gmail.com");
        //Binding textviews
      activityMainBinding = DataBindingUtil.setContentView(this,
              R.layout.activity_main);
      activityMainBinding.setPerson(person);

      //Binding click events
        clickHandler = new MainActivityClickHandler(this);
        activityMainBinding.setClickManager(clickHandler);



    }

    public class MainActivityClickHandler{
        Context context;

        public MainActivityClickHandler(Context context) {
            this.context = context;
        }

        //first button click
        public void onButton1Click(View view){
            Toast.makeText(context, "Hello My Friends", Toast.LENGTH_SHORT).show();
        }

        //second button click
        public void onButton2Click(View view){
            Toast.makeText(context, "Bye Bye My Friends", Toast.LENGTH_LONG).show();
        }
    }
}