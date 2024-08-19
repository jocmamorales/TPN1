package com.example.tpn1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SumaActivity extends AppCompatActivity {

    private EditText txtNum1;
    private EditText txtNum2;
    private TextView txtResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_suma);

        txtNum1 = (EditText)findViewById(R.id.etNum1);
        txtNum2 = (EditText)findViewById(R.id.etNum2);
        txtResultado = (TextView)findViewById(R.id.tvRes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Sumar (View view){
        int num1 = Integer.parseInt(txtNum1.getText().toString());
        int num2 = Integer.parseInt(txtNum2.getText().toString());

        int suma = num1 + num2;

        txtResultado.setText(String.valueOf(suma));
    }

    public void Regresar (View view){
        Intent regresar = new Intent(this, MainActivity.class);
        startActivity(regresar);
    }
}