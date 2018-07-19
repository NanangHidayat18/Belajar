package com.example.hp.approvallatihan1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.view.View;

import java.util.Calendar;

public class Persetujuan_Tahunan extends AppCompatActivity implements View.OnClickListener {

    private EditText tanggalacc, tanggalmulaiacc, tanggalakhiracc;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_persetujuan_tahunan);

        tanggalacc = (EditText) findViewById(R.id.tanggalacc);
        tanggalmulaiacc = (EditText) findViewById(R.id.tanggalmulaiacc);
        tanggalakhiracc = (EditText) findViewById(R.id.tanggalakhiracc);

        tanggalacc.setOnClickListener(this);
        tanggalmulaiacc.setOnClickListener(this);
        tanggalakhiracc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tanggalacc:
                showDatePicker((datePicker, y, m, d) -> tanggalacc.setText(d + "-" + (m + 1) + "-" + y));
                break;

            case R.id.tanggalmulaiacc:
                showDatePicker((datePicker, y, m, d) -> tanggalmulaiacc.setText(d + "-" + (m + 1) + "-" + y));
                break;

            case R.id.tanggalakhiracc:
                showDatePicker((datePicker, y, m, d) -> tanggalakhiracc.setText(d + "-" + (m + 1) + "-" + y));
                break;
        }
    }

    private void showDatePicker(DatePickerDialog.OnDateSetListener listener) {
        Calendar a = Calendar.getInstance();
        mYear = a.get(Calendar.YEAR);
        mMonth = a.get(Calendar.MONTH);
        mDay = a.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this, listener, mYear, mMonth, mDay).show();
    }

    public void reject (View view){
        Intent intent = new Intent(Persetujuan_Tahunan.this, Keterangan_Penolakan.class);
        startActivity(intent);
    }

    public void approval (View view){
        Intent intent = new Intent(Persetujuan_Tahunan.this, Keterangan_Approval.class);
        startActivity(intent);
    }
}
