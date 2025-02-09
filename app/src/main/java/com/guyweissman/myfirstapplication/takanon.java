package com.guyweissman.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class takanon extends AppCompatActivity {
Button ok;
CheckBox checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takanon);
    }

    private  void initViews(){
        ok=findViewById(R.id.takanon);
        checkbox=findViewById(R.id.check);
        ok.setOnClickListener(new View.OnClickListener(){


            public void onClick(View view){
                Intent resultIntent=new Intent();
                if(checkbox.isChecked()) {
                    resultIntent.putExtra("checkbox_checked", true);

                }
                else{
                    resultIntent.putExtra("checkbox_checked", false);
                }
                setResult(RESULT_OK, resultIntent);
                finish();
            }
                              }

        );

    }
}