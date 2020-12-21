package com.example.login_password_new_272;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText ed_new_login, ed_new_password;
    Button create;
    String field = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed_new_login = findViewById(R.id.login22);
        ed_new_password = findViewById(R.id.password22);
        create = findViewById(R.id.button2);
        create.setOnClickListener(v->{
            Intent i = new Intent();
            i.putExtra("new_login", ed_new_login.getText().toString());
            i.putExtra("new_password", ed_new_password.getText().toString());
            i.putExtra("new_reaction", field);
            setResult(1, i);
            finish();
        });
    }
}