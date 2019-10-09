package com.example.disystask.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.disystask.R;
import com.example.disystask.preference.SharePref;

public class Splah_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah__screen);

        splash_Handler();
    }

    /**
     * This method will be executed once the timer is over
     */
    private void splash_Handler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (SharePref.getInstance(Splah_Screen.this).getData(SharePref.KEY_EID).equalsIgnoreCase("")) {
                    intent = new Intent(Splah_Screen.this, Register_Activity.class);
                } else {
                    intent = new Intent(Splah_Screen.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
