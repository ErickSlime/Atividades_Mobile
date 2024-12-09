package com.example.atividade1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Button button = findViewById(R.id.button);

        Intent intent = getIntent();
        int counter = intent.getIntExtra("counter", 0);

        button.setText(String.valueOf(counter));

        button.setOnClickListener(v -> {
            Intent intentToMain = new Intent(Activity2.this, MainActivity.class);
            intentToMain.putExtra("counter", counter + 1);
            startActivity(intentToMain);
            finish();
        });
    }
}
