package com.example.roooom_db;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.roooom_db.EntntyClass.DatabaseClass;
import com.example.roooom_db.EntntyClass.UserModel;


public class MainActivity extends AppCompatActivity {
    EditText name , address , date ;
    Button save , getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name_et);
        address = findViewById(R.id.address_et);
        date = findViewById(R.id.date_et);
        save = findViewById(R.id.save_btn);
        getData = findViewById(R.id.getData_btn);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.SaveData();
            }
        });

        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity
                        (new Intent(MainActivity.this.getApplicationContext(), UsersListActivity.class));
            }
        });

    }
    private void SaveData(){
        String name_et = name.getText().toString().trim();
        String address_et = address.getText().toString().trim();
        String date_et = date.getText().toString().trim();

            UserModel userModel= new UserModel();

            userModel.setName(name_et);
            userModel.setAddress(address_et);
            userModel.setDate(date_et);

            DatabaseClass.getDatabase(getApplicationContext()).getDao().insartAllData(userModel);

        name.setText("");
        address.setText("");
        date.setText("");
            Toast.makeText(this , "Data Successfully Saved",Toast.LENGTH_LONG).show();



        }
    }
