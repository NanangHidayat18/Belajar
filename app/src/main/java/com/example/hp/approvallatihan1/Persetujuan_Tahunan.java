package com.example.hp.approvallatihan1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class Persetujuan_Tahunan extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2;
    EditText etanggalacc, ejumlahacc, etanggalmulaiacc, etanggalakhiracc;

    private EditText tanggalacc, jumlahacc, tanggalmulaiacc, tanggalakhiracc;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_persetujuan_tahunan);

        tanggalacc = (EditText) findViewById(R.id.tanggalacc);
        jumlahacc = (EditText) findViewById(R.id.jumlahacc);
        tanggalmulaiacc = (EditText) findViewById(R.id.tanggalmulaiacc);
        tanggalakhiracc = (EditText) findViewById(R.id.tanggalakhiracc);

        tanggalacc.setOnClickListener(this);
        tanggalacc.setOnClickListener(this);
        tanggalmulaiacc.setOnClickListener(this);
        tanggalakhiracc.setOnClickListener(this);

        etanggalacc = (EditText) findViewById(R.id.tanggalacc);
        ejumlahacc = (EditText) findViewById(R.id.jumlahacc);
        etanggalmulaiacc = (EditText) findViewById(R.id.tanggalmulaiacc);
        etanggalakhiracc = (EditText) findViewById(R.id.tanggalakhiracc);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(etanggalacc.getText().toString())) {
                    etanggalacc.setError(null);
                    etanggalacc.setError("Tanggal diperlukan!");
                    etanggalacc.requestFocus();

                } else if (TextUtils.isEmpty(ejumlahacc.getText().toString()) || ejumlahacc.getText().toString().length() == 0) {
                    ejumlahacc.setError(null);
                    ejumlahacc.setError("Jumlah hari ACC diperlukan!");
                    ejumlahacc.requestFocus();


                } else if (TextUtils.isEmpty(etanggalmulaiacc.getText().toString())) {
                    etanggalmulaiacc.setError(null);
                    etanggalmulaiacc.setError("Tanggal diperlukan!");
                    etanggalmulaiacc.requestFocus();


                } else if (TextUtils.isEmpty(etanggalakhiracc.getText().toString())) {
                    tanggalakhiracc.setError(null);
                    etanggalakhiracc.setError("Tanggal diperlukan!");
                    etanggalakhiracc.requestFocus();


                } else {
                    Intent i = new Intent(getApplicationContext(), Keterangan_Penolakan.class);
                    startActivity(i);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(etanggalacc.getText().toString())) {
                    etanggalacc.setError(null);
                    etanggalacc.setError("Tanggal diperlukan!");
                    etanggalacc.requestFocus();


                } else if (TextUtils.isEmpty(ejumlahacc.getText().toString()) || ejumlahacc.getText().toString().length() == 0) {
                    ejumlahacc.setError(null);
                    ejumlahacc.setError("Jumlah hari ACC diperlukan!");
                    ejumlahacc.requestFocus();


                } else if (TextUtils.isEmpty(etanggalmulaiacc.getText().toString())) {
                    etanggalmulaiacc.setError(null);
                    etanggalmulaiacc.setError("Tanggal diperlukan!");
                    etanggalmulaiacc.requestFocus();


                } else if (TextUtils.isEmpty(etanggalakhiracc.getText().toString())) {
                    tanggalakhiracc.setError(null);
                    etanggalakhiracc.setError("Tanggal diperlukan!");
                    etanggalakhiracc.requestFocus();


                } else {
                    Intent i = new Intent(getApplicationContext(), Keterangan_Approval.class);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tanggalacc:
                showDatePicker((datePicker, y, m, d) -> {
                    tanggalacc.setText(d + "-" + (m + 1) + "-" + y);
                    tanggalacc.setError(null);
                });
                break;

            case R.id.tanggalmulaiacc:
                showDatePicker((datePicker, y, m, d) -> {
                    tanggalmulaiacc.setText(d + "-" + (m + 1) + "-" + y);
                    tanggalmulaiacc.setError(null);
                });
                break;

            case R.id.tanggalakhiracc:
                showDatePicker((datePicker, y, m, d) -> {
                    tanggalakhiracc.setText(d + "-" + (m + 1) + "-" + y);
                    tanggalakhiracc.setError(null);
                });
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

