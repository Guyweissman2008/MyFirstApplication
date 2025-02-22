package com.guyweissman.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewActivity extends AppCompatActivity {
    private ImageView timerImage;


    final int[] images = {
            R.drawable.img_14,
            R.drawable.img_13,
            R.drawable.img_12,
            R.drawable.img_11,
            R.drawable.img_10,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        timerImage = findViewById(R.id.timer_image);
        new CountDownTimer(5000, 1000) {
            int i = 0;


            @Override
            public void onTick(long millisUntilFinished) {
                if (i < images.length) {
                    timerImage.setImageResource(images[i]);
                    i++;
                }
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(NewActivity.this, NextActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}




