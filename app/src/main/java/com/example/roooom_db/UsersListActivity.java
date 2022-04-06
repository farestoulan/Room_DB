package com.example.roooom_db;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roooom_db.Adpter.UserAdapter;
import com.example.roooom_db.EntntyClass.DatabaseClass;

public class UsersListActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        recyclerView=findViewById(R.id.recycler_v);
        getData();
    }

    private void getData() {
        recyclerView.setAdapter(new UserAdapter(getApplicationContext(),
                DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData()));

    }
}