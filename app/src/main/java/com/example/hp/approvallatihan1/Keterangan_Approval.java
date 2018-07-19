package com.example.hp.approvallatihan1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Keterangan_Approval extends AppCompatActivity {
    private Button btnkirim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Keterangan Approval");
        setContentView(R.layout.activity_keterangan_approval);
        btnkirim = (Button) findViewById(R.id.btnkirim);
        btnkirim.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }
    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        // alertDialogBuilder.setTitle("Keluar dari aplikasi?");//

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Apakah Anda Yakin Menerima Cuti Pegawai?")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        Keterangan_Approval.this.finish();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }
}