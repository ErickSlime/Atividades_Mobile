package com.example.atividade1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        Intent intent = getIntent();
        int counter = intent.getIntExtra("counter", 1);

        button.setText(String.valueOf(counter));

        button.setOnClickListener(v -> {
            Intent intentToSecond = new Intent(MainActivity.this, Activity2.class);
            intentToSecond.putExtra("counter", counter + 1);
            startActivity(intentToSecond);
        });
    }
}