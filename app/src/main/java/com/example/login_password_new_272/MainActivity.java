package com.example.login_password_new_272;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText ed_login, ed_password;
    Button button1;
    StringBuilder login = new StringBuilder("123457@mail.ru");
    StringBuilder password = new StringBuilder("123457");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.reaction);
        ed_login = findViewById(R.id.login);
        ed_password = findViewById(R.id.password);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            String loginn = ed_login.getText().toString();
            String passwordd = ed_password.getText().toString();
            if (loginn.equals(login.toString())&&passwordd.equals(password.toString())) {
                tv.setText(R.string.right);}
            if (!loginn.equals(login.toString())||(!passwordd.equals(password.toString()))) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(i, 1);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                String new_login = data.getStringExtra("new_login");
                String new_password = data.getStringExtra("new_password");
                String new_reaction = data.getStringExtra("new_reaction");
                int right_l = login.length();
                int right_p = password.length();
                ed_login.setText(new_login);
                ed_password.setText("");
                tv.setText("");
                login.delete(0, right_l);
                login.append(new_login);
                password.delete(0, right_p);
                password.append(new_password);
                break;
        }
    }
}