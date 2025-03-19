
package com.guyweissman.myfirstapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button btnSelectDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Edge to Edge configuration
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // Set up padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up button and click listener
        btnSelectDate = findViewById(R.id.btnDate);
        btnSelectDate.setOnClickListener(this);
    }


    private void showDatePicker() {
        // Get the current date
        Calendar systemCalendar = Calendar.getInstance();
        int year = systemCalendar.get(Calendar.YEAR);
        int month = systemCalendar.get(Calendar.MONTH);
        int day = systemCalendar.get(Calendar.DAY_OF_MONTH);

        // Show the DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new SetDate(), year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v == btnSelectDate) {
            showDatePicker();
        }
    }

    public class SetDate implements DatePickerDialog.OnDateSetListener {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            monthOfYear = monthOfYear + 1;  // Correct the month (0-indexed)

            String str = "You selected: " + dayOfMonth + "/" + monthOfYear + "/" + year;
            Toast.makeText(MainActivity2.this, str, Toast.LENGTH_LONG).show();
            btnSelectDate.setText(str);
        }
    }
}

