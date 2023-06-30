package com.example.masterremote;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        databaseHelper = new DatabaseHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredUsername = username.getText().toString();
                String enteredPassword = password.getText().toString();

                if (databaseHelper.checkCredentials(enteredUsername, enteredPassword)) {
                    Toast.makeText(MainActivity.this, "Sucesso no Login", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, BlocoNotasActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Falha no Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
