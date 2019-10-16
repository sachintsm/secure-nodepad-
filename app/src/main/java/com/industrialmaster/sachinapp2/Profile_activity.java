package com.industrialmaster.sachinapp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Profile_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);
    }
    public void save(View v){
        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);
        SharedPreferences.Editor profileEditor =profile.edit();

        EditText etName = findViewById(R.id.etName);
        EditText etPassword = findViewById(R.id.etPassword);

        profileEditor.putString("Name" , etName.getText().toString());
        profileEditor.putString("Password" , etPassword.getText().toString());

        profileEditor.commit();

        Toast.makeText(this, "Saved !",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
