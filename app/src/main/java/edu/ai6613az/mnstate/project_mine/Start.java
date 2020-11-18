package edu.ai6613az.mnstate.project_mine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {

    private static int SPLASH_TIMEOUT = 2000;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Start.this, MainActivity.class));
                finish();


            }
        }, SPLASH_TIMEOUT );

    }
}
