package com.example.hp.approvallatihan1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.view.View;

import java.util.Calendar;

public class Persetujuan_Cuti_Besar extends AppCompatActivity implements View.OnClickListener{

    private Button button1, button2;
    EditText ehakcuti, esisacuti, etanggalapprove;

    private EditText tanggalapprove;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persetujuan__cuti__besar);

        tanggalapprove = (EditText) findViewById(R.id.tanggalapprove);

        tanggalapprove.setOnClickListener(this);

        ehakcuti = (EditText) findViewById(R.id.hakcuti);
        esisacuti = (EditText) findViewById(R.id.sisacuti);
        etanggalapprove = (EditText) findViewById(R.id.tanggalapprove);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(ehakcuti.getText().toString())) {
                    ehakcuti.setError(null);
                    ehakcuti.setError("Masukkan hak cuti!");
                    ehakcuti.requestFocus();
                } else if (TextUtils.isEmpty(esisacuti.getText().toString())) {
                    esisacuti.setError(null);
                    esisacuti.setError("Masukkan sisa cuti!");
                    esisacuti.requestFocus();
                } else if (TextUtils.isEmpty(etanggalapprove.getText().toString())) {
                    etanggalapprove.setError(null);
                    etanggalapprove.setError("Tanggal diperlukan!");
                    etanggalapprove.requestFocus();
                } else {
                    Intent i = new Intent(getApplicationContext(), Keterangan_Penolakan.class);
                    startActivity(i);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(ehakcuti.getText().toString())) {
                    ehakcuti.setError(null);
                    ehakcuti.setError("Masukkan hak cuti!");
                    ehakcuti.requestFocus();
                } else if (TextUtils.isEmpty(esisacuti.getText().toString())) {
                    esisacuti.setError(null);
                    esisacuti.setError("Masukkan sisa cuti!");
                    esisacuti.requestFocus();
                } else if (TextUtils.isEmpty(etanggalapprove.getText().toString())) {
                    etanggalapprove.setError(null);
                    etanggalapprove.setError("Tanggal diperlukan!");
                    etanggalapprove.requestFocus();
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
            case R.id.tanggalapprove:
                showDatePicker((datePicker, y, m, d) ->{
                    tanggalapprove.setText(d + "-" + (1) + "-" + y);
                    tanggalapprove.setError(null);
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

        public void reject1 (View view){
            Intent intent = new Intent(Persetujuan_Cuti_Besar.this, Keterangan_Penolakan.class);
            startActivity(intent);
        }

        public void approval1 (View view){
            Intent intent = new Intent(Persetujuan_Cuti_Besar.this, Keterangan_Approval.class);
            startActivity(intent);
        }
    }
