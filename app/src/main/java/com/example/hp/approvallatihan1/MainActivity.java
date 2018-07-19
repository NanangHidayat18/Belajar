package com.example.hp.approvallatihan1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUser;
    private List<UserModel> mListUser;
    private UserAdapter mUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUser = (RecyclerView) findViewById(R.id.recyclerview);
        mListUser = new ArrayList<>();

        UserModel user1 = new UserModel("Veni", "20");
        UserModel user2 = new UserModel("Nanang", "20");
        UserModel user3 = new UserModel("Eni", "19");
        UserModel user4 = new UserModel("Reza", "22");
        UserModel user5 = new UserModel("Nazar", "20");
        UserModel user6 = new UserModel("Fani", "21");

        mListUser.add(user1);
        mListUser.add(user2);
        mListUser.add(user3);
        mListUser.add(user4);
        mListUser.add(user5);
        mListUser.add(user6);

        mUserAdapter = new UserAdapter(mListUser, this);
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        rvUser.setItemAnimator(new DefaultItemAnimator());
        rvUser.setAdapter(mUserAdapter);
        mUserAdapter.notifyDataSetChanged();

    }
}