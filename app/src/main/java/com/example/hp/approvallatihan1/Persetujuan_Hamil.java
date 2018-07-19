package com.example.hp.approvallatihan1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.view.View;

import java.util.Calendar;

public class Persetujuan_Hamil extends AppCompatActivity implements View.OnClickListener{

    private EditText tanggalapprove;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persetujuan__hamil);

        tanggalapprove = (EditText) findViewById(R.id.tanggalapprove);

        tanggalapprove.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tanggalapprove:
                showDatePicker((datePicker, y, m, d) -> tanggalapprove.setText(d + "-" + (1) + "-" + y));
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

    public void reject1 (View view){
        Intent intent = new Intent(Persetujuan_Hamil.this, Keterangan_Penolakan.class);
        startActivity(intent);
    }

    public void approval1 (View view){
        Intent intent = new Intent(Persetujuan_Hamil.this, Keterangan_Approval.class);
        startActivity(intent);
    }
}


