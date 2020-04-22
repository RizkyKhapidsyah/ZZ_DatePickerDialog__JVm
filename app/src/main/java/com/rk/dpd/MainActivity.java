package com.rk.dpd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText ET_1_IDJAVA;
    DatePickerDialog.OnDateSetListener DPD_OnDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET_1_IDJAVA = findViewById(R.id.ET_1_IDXML);
        ET_1_IDJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar Kalender = Calendar.getInstance();
                int Tahun = Kalender.get(Calendar.YEAR);
                int Bulan = Kalender.get(Calendar.MONTH);
                int Hari = Kalender.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog DPD = new DatePickerDialog(getApplicationContext(), DPD_OnDateSetListener, Tahun, Bulan, Hari);
                DPD.show();
            }
        });

        DPD_OnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String Tanggal = dayOfMonth + "/" + month + "/" + year;
                ET_1_IDJAVA.setText(Tanggal);
            }
        };

    }
}
