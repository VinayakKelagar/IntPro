package com.example.blooddonar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Flash extends AppCompatActivity {

    private static int PAGE_TIME=800;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashintent=new Intent( Flash.this,Login.class);
                startActivity(splashintent);
                finish();
            }
        },PAGE_TIME);
    }
}
