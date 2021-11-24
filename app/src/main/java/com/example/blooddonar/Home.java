package com.example.blooddonar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity
{
    Button button_donar,button_reciever;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        button_donar=(Button) findViewById(R.id.btn_home_ddet);
        button_reciever=(Button) findViewById(R.id.btn_home_rdet);

        button_donar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent donarintent=new Intent(Home.this,Viewdonar.class);
                startActivity(donarintent);
            }
        });

        button_reciever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recieverintent=new Intent(Home.this,Viewreciever.class);
                startActivity(recieverintent);
            }
        });


    }
}
