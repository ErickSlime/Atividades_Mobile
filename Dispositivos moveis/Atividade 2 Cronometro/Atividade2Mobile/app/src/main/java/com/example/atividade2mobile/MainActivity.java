package com.example.atividade2mobile;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView timerTextView;
    private Button startStopButton;

    private boolean isRunning = false;
    private int seconds = 0;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = findViewById(R.id.tv_timer);
        startStopButton = findViewById(R.id.btn_start_stop);

        runnable = new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    seconds++;
                    timerTextView.setText(String.valueOf(seconds));
                    handler.postDelayed(this, 1000);
                }
            }
        };

        startStopButton.setOnClickListener(v -> {
            if (isRunning) {
                stopTimer();
            } else {
                startTimer();
            }
        });
    }

    private void startTimer() {
        isRunning = true;
        startStopButton.setText("Parar");
        handler.post(runnable);
    }

    private void stopTimer() {
        isRunning = false;
        startStopButton.setText("Começar");
        handler.removeCallbacks(runnable);
    }
}