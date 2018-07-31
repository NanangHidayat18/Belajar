package com.example.hp.approvallatihan1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserAdapter.OnClickItemListener{

    private List<UserModel> mListUser = new ArrayList<>();
    private RecyclerView rvUser;
    private UserAdapter mUserAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        rvUser = (RecyclerView) findViewById(R.id.recyclerview);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mUserAdapter = new UserAdapter(mListUser);
        mUserAdapter.setOnClickItemListener(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvUser.setLayoutManager(mLayoutManager);
        rvUser.setItemAnimator(new DefaultItemAnimator());
        rvUser.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvUser.setAdapter(mUserAdapter);

        prepareUserData();
    }

    private void prepareUserData() {
        UserModel userModel = new UserModel("Veni Fela Yanuarita", "Pengajuan Cuti Besar", "2018");
        mListUser.add(userModel);

        userModel = new UserModel("Eni Nofita Sari", "Pengajuan Cuti Hamil", "2018");
        mListUser.add(userModel);

        userModel = new UserModel("Reza Amalia", "Pengajuan Cuti Hamil", "2018");
        mListUser.add(userModel);

        userModel = new UserModel("Narto Hidayat", "Pengajuan Cuti Tahunan", "2018");
        mListUser.add(userModel);

        userModel = new UserModel("Renaldi Pramudia", "Pengajuan Cuti Besar", "2018");
        mListUser.add(userModel);

        userModel = new UserModel("Fani Enda", "Pengajuan Cuti Tahunan", "2018");
        mListUser.add(userModel);

        userModel = new UserModel("Nanang Hidayat", "Pengajuan Cuti Hamil", "2018");
        mListUser.add(userModel);

        userModel = new UserModel("Aldo Galih", "Pengajuan Cuti Tahunan", "2018");
        mListUser.add(userModel);

        userModel = new UserModel("Tias Karisma", "Pengajuan Cuti Hamil", "2018");
        mListUser.add(userModel);

        userModel = new UserModel("Alif fitrawan", "Pengajuan Cuti Besar", "2018");
        mListUser.add(userModel);

        mUserAdapter.notifyDataSetChanged();
    }



    @Override
    public void onClickItem(UserModel usermodel) {
        // TODO: 30/07/2018 buatkan intent ke activity selanjutnya

        Toast.makeText(this, usermodel.getName(), Toast.LENGTH_SHORT).show();
    }
}
