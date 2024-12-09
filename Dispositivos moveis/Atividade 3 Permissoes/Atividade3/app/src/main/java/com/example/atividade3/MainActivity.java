package com.example.atividade3;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnProcessar;
    private Handler handler = new Handler();
    private static final int CAMERA_PERMISSION_CODE = 100;
    private int seconds = 11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnProcessar = findViewById(R.id.btn_processar);

        Log.d("MeuAPP","onCreate");

        /*Log.i("MeuAPP","Log de Informacao");
        Log.e("MeuAPP","Log de Error");*/


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MeuAPP","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MeuAPP","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MeuAPP","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MeuAPP","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MeuAPP","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MeuAPP","onDestroy");
    }

    public void processar(View view){
        textView.setText( String.valueOf(seconds));
        Log.d("MeuAPP","foi");
        btnProcessar.setEnabled(false);
        executarAlgoDemorado();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
        } else {
            Toast.makeText(this, "Permissão para a câmera já concedida", Toast.LENGTH_SHORT).show();
        }
    }

    public void executarAlgoDemorado(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //SystemClock.sleep(10000);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(seconds>0) {
                            seconds--;
                            textView.setText(String.valueOf(seconds));
                            handler.postDelayed(this, 1000);
                            if (seconds == 0){
                                btnProcessar.setEnabled(true);
                            }
                        }
                    }

                });
                seconds = 11;

                /*
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(R.string.txt_finalizado);
                        btnProcessar.setEnabled(true);
                    }
                });*/
            }
        }).start();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permissão para a câmera concedida", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permissão para a câmera negada", Toast.LENGTH_SHORT).show();
            }
        }
    }
}