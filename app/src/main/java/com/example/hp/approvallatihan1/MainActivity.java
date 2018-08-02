package com.example.hp.approvallatihan1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UserAdapter.OnClickItemListener {

    private List<UserModel> mListUser = new ArrayList<>();
    private List<UserModel> mListUserForAdapter = new ArrayList<>();
    private RecyclerView rvUser;
    private UserAdapter mUserAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getUserData();

        toolbar = findViewById(R.id.toolbar);
        rvUser = (RecyclerView) findViewById(R.id.recyclerview);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_sortir);

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

        String[] filterCuti = getResources().getStringArray(R.array.list_cuti);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filterCuti));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        prepareUserData();
                        break;
                    case 1:
                        sortByCutiTahunan();
                        break;
                    case 2:
                        sortByCutiHamil();
                        break;
                    case 3:
                        sortByCutiBesar();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

    }

    private List<UserModel> getDataCuti() {
        return null;
    }

    private void sortByCutiTahunan() {
        mListUser.clear();
        for (UserModel userModel : mListUserForAdapter) {
            if (userModel.getCuti().contains("Tahunan")) {
                mListUser.add(userModel);
            }
        }
        mUserAdapter.notifyDataSetChanged();
    }

    private void sortByCutiHamil() {
        mListUser.clear();
        for (UserModel userModel : mListUserForAdapter) {
            if (userModel.getCuti().contains("Hamil")) {
                mListUser.add(userModel);
            }
        }
        mUserAdapter.notifyDataSetChanged();
    }

    private void sortByCutiBesar() {
        mListUser.clear();
        for (UserModel userModel : mListUserForAdapter) {
            if (userModel.getCuti().contains("Besar")) {
                mListUser.add(userModel);
            }
        }
        mUserAdapter.notifyDataSetChanged();
    }

    private void getUserData() {
        mListUserForAdapter = Arrays.asList(
                new UserModel("Veni Fela Yanuarita", "Pengajuan Cuti Besar", "2018"),
                new UserModel("Eni Nofita Sari", "Pengajuan Cuti Hamil", "2018"),
                new UserModel("Reza Amalia", "Pengajuan Cuti Hamil", "2018"),
                new UserModel("Narto Hidayat", "Pengajuan Cuti Tahunan", "2018"),
                new UserModel("Renaldi Pramudia", "Pengajuan Cuti Hamil", "2018"),
                new UserModel("Fani Enda", "Pengajuan Cuti Tahunan", "2018"),
                new UserModel("Nanang Hidayat", "Pengajuan Cuti Tahunan", "2018"),
                new UserModel("Aldo Galih", "Pengajuan Cuti Besar", "2018"),
                new UserModel("Tias Karisma", "Pengajuan Cuti Hamil", "2018"),
                new UserModel("Alif fitrawan", "Pengajuan Cuti Besar", "2018")
        );
    }

    private void prepareUserData() {
        mListUser.clear();
        mListUser.addAll(mListUserForAdapter);
        mUserAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClickItem(UserModel usermodel) {
        // TODO: 31/07/2018 buatkan intent ke activity selanjutnya

        Intent intent;
        if(usermodel.getCuti().contains("Tahunan")){
            intent = new Intent(this, PersetujuanTahunanActivity.class);
        }else if(usermodel.getCuti().contains("Hamil")){
            intent = new Intent(this, PersetujuanHamilActivity.class);
        }else{
            intent = new Intent(this, PersetujuanCutiBesarActivity.class);
        }

        startActivity(intent);
    }
}
