package com.guyweissman.myfirstapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button b5, b6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        // אתחול של EditText
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        // אתחול של כפתורים
        b5 = findViewById(R.id.buttonSave);  // כפתור לשמירה
        b6 = findViewById(R.id.buttonPrint); // כפתור להדפסה

        // אתחול של SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // שמירת הערכים ב-SharedPreferences כשנלחץ כפתור שמירה
        b5.setOnClickListener(view -> {
            String value1 = editText1.getText().toString();
            String value2 = editText2.getText().toString();

            // שמירה ב-SharedPreferences
            editor.putString("key_string_1", value1);
            editor.putString("key_string_2", value2);
            editor.apply();  // שמירה אסינכרונית

            // הצגת הודעת Toast
            Toast.makeText(this, "הערכים נשמרו!", Toast.LENGTH_SHORT).show();
        });

        // הצגת הערכים שנשמרו ב-SharedPreferences
        b6.setOnClickListener(view -> {
            String savedValue1 = sharedPreferences.getString("key_string_1", "לא נמצא ערך");
            String savedValue2 = sharedPreferences.getString("key_string_2", "לא נמצא ערך");

            // הצגת הערכים ב-Toast
            Toast.makeText(this, "הערך הראשון: " + savedValue1 + "\nהערך השני: " + savedValue2, Toast.LENGTH_LONG).show();
        });
    }
}


