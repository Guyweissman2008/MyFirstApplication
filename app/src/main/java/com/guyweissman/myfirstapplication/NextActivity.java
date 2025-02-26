package com.guyweissman.myfirstapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_next);

        // Handling window insets (system bars)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.keyval), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // SharedPreferences code
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        // Saving values in SharedPreferences
        editor.putBoolean("key_boolean", true);  // Storing boolean
        editor.putString("key_string", "string value");  // Storing string
        editor.putInt("key_int", 123);  // Storing integer
        editor.putFloat("key_float", 12.34f);  // Storing float
        editor.putLong("key_long", 123456789L);  // Storing long

        editor.commit();  // Apply changes

        // Retrieving values from SharedPreferences
        boolean booleanValue = pref.getBoolean("key_boolean", false);  // getting boolean
        String stringValue = pref.getString("key_string", null);  // getting string
        int intValue = pref.getInt("key_int", -1);  // getting integer
        float floatValue = pref.getFloat("key_float", -1.0f);  // getting float
        long longValue = pref.getLong("key_long", -1L);  // getting long
    }
}
