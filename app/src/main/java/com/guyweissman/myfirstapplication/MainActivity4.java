package com.guyweissman.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class
MainActivity4 extends AppCompatActivity {

    EditText etLast;
    TextView result;
    Button btnOk1, btnGuess, btnFindNumber,back1;
    RadioGroup radioGroup;
    int gameNum, count;
    int lowerRange, upperRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        initViews();
    }

    private void initViews() {
        // Initialize the UI elements
        radioGroup = findViewById(R.id.num1);
        etLast = findViewById(R.id.editText3);
        result = findViewById(R.id.resultText);  // This is the result TextView now
        btnOk1 = findViewById(R.id.btn2);
        btnGuess = findViewById(R.id.btn);
        back1=findViewById(R.id.back1);

        back1.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         Intent intent = new Intent(MainActivity4.this, MainActivity.class);
                                         startActivity(intent);
                                     }
                                 });
        // Initialize game variables
        count = 0;

        // Set listener for "Find a random number" button
        btnOk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the selected range from the RadioGroup
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedRange = selectedRadioButton.getText().toString();

                    // Set the range based on the selected radio button
                    if (selectedRange.equals("0-100")) {
                        lowerRange = 0;
                        upperRange = 100;
                    } else if (selectedRange.equals("100-200")) {
                        lowerRange = 100;
                        upperRange = 200;
                    } else if (selectedRange.equals("200-300")) {
                        lowerRange = 200;
                        upperRange = 300;
                    }

                    // Generate a random number within the selected range
                    gameNum = (int) (Math.random() * (upperRange - lowerRange + 1)) + lowerRange;
                    count = 0;  // Reset guess count
                    result.setText("");  // Clear previous result
                    Toast.makeText(MainActivity4.this, "Random number generated!", Toast.LENGTH_SHORT).show();
                } else {
                    // Show a toast message if no range is selected
                    Toast.makeText(MainActivity4.this, "Please select a range first!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set listener for "Guess" button
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the user's guess from the EditText
                String guessStr = etLast.getText().toString();
                if (!guessStr.isEmpty()) {
                    int guess = Integer.parseInt(guessStr);
                    count++;  // Increment the guess count

                    // Compare the guess with the generated number
                    if (guess == gameNum) {
                        result.setText("Correct! It took you " + count + " attempts.");
                            Intent intent=new Intent();
                            intent.putExtra("num_guesses",count);
                        intent.putExtra("user_name","guy");
                            setResult(RESULT_OK,intent);
                            finish();
                    } else if (guess > gameNum) {
                        result.setText("Your guess is too high.");
                    } else {
                        result.setText("Your guess is too low.");
                    }
                } else {
                    Toast.makeText(MainActivity4.this, "Please enter a guess!", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

}
