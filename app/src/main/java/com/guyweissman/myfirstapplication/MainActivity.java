package com.guyweissman.myfirstapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {//implements View.OnClickListener
    Button b1, b2, b3;
    TextView tv1;
//Context context;

    ConstraintLayout constraintLayout;

    Switch sw;

    SeekBar sb;
    ImageView iv;
    ImageView iv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        constraintLayout = findViewById(R.id.main_layout);

        b1 = findViewById(R.id.first);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("hello");
                Log.d("guy", "b1");
            }
        });
        b2 = findViewById(R.id.second);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setText("hello2");
                Log.d("guy", "b2");
            }

        });
        tv1 = findViewById(R.id.tv1);
        sw = findViewById(R.id.abc);
        sw.setOnCheckedChangeListener(this);
        sw = (Switch) findViewById(R.id.abc);
        sw.setOnCheckedChangeListener(this);
        iv = (ImageView) findViewById(R.id.iv);
        iv2 = (ImageView) findViewById(R.id.iv2);
        sb = (SeekBar) findViewById(R.id.sb);
        sb.setProgress(100);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float alpha = (float) i / 100;
                iv.setAlpha(alpha);
                float alpha1 = (float) 1 - alpha;
                iv2.setAlpha(alpha1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        b3 = findViewById(R.id.secondpage);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            constraintLayout.setBackgroundColor(0xFF00BCD4);
        } else {
            constraintLayout.setBackgroundColor(0xFFED7BA2);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.action_login) {
            Toast.makeText(this, "You selected login", Toast.LENGTH_SHORT).show();
        } else if (R.id.action_register == id) {
            Toast.makeText(this, "You selected register", Toast.LENGTH_SHORT).show();
        } else if (R.id.action_start == id) {
            Toast.makeText(this, "You selected start", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.new_item) {
            Intent intent = new Intent(MainActivity.this, NewActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.dialog_menu) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }
        return true;
    }
}










