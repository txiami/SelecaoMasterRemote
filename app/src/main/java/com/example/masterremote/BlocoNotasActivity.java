package com.example.masterremote;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class BlocoNotasActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "BlocoNotasPrefs";
    private static final String PREFS_KEY_NOTAS = "notas";

    private EditText editTextBlocoNotas;
    private Button buttonSalvar;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloco_notas);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        editTextBlocoNotas = findViewById(R.id.editTextBlocoNotas);
        buttonSalvar = findViewById(R.id.buttonSalvar);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notas = editTextBlocoNotas.getText().toString();
                salvarNotas(notas);
            }
        });

        carregarNotas();
    }

    private void salvarNotas(String notas) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREFS_KEY_NOTAS, notas);
        editor.apply();
    }

    private void carregarNotas() {
        String notas = sharedPreferences.getString(PREFS_KEY_NOTAS, "");
        editTextBlocoNotas.setText(notas);
    }
}
