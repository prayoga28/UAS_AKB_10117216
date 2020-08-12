package com.project.uas_akb_10117216;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_Screen.this, MainActivity.class);
                startActivity(i);

                finish();
            }
        }, 3000);
    }
}

    // 06 agustus 2020
    // 10117216
    // Adi Prayoga
    // IF - 7