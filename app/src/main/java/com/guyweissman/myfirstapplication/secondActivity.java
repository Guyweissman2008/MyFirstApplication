package com.guyweissman.myfirstapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {

    Button BunnyButton, game,takanon;

int START_GAME;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == START_GAME)
            if (resultCode == RESULT_OK) {
                int i = data.getIntExtra("num_guesses", -1);
                String str = data.getStringExtra("user_name");
                Toast.makeText(this, "game finished =" + i + "user=" + str, Toast.LENGTH_SHORT).show();
            }
        if(requestCode==1){
    if(requestCode==RESULT_OK){

    }
        }
    }

 @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_second);

     initViews();
  }

  //  @Override
  //  protected void onStop() {
    //    super.onStop();
   //     Toast.makeText(this, "onstop", Toast.LENGTH_SHORT).show();

  //  }

  //  @Override
//    protected void onStart() {
     //   super.onStart();
    //    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
 //   }

    private void initViews() {
        BunnyButton = findViewById(R.id.BunnyButton);
        BunnyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });
        takanon=findViewById(R.id.takanon);
        takanon.setOnClickListener(new View.OnClickListener() {
        @Override
       public void onClick(View view) {
Intent intent=new Intent(secondActivity.this,com.guyweissman.myfirstapplication.takanon.class);
startActivityForResult(intent,1);
                                       }



                                   });
        game = findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
               Intent intent = new Intent(secondActivity.this, MainActivity4.class);

               startActivityForResult(intent, START_GAME);
                //finish();
            }
        });
    }
}






