package com.example.tpn1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView txtResult;
    private String input = "";
    private String operator = "";
    private double operand1 = 0;
    private boolean isOperatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtResult = findViewById(R.id.txtResult);

        findViewById(R.id.btn0).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn1).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn2).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn3).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn4).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn5).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn6).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn7).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn8).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn9).setOnClickListener(this::onNumberClick);

        findViewById(R.id.btnAdd).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnSubtract).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnMultiply).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btnDivide).setOnClickListener(this::onOperatorClick);

        findViewById(R.id.btnEqual).setOnClickListener(this::onEqualClick);

        findViewById(R.id.btnClear).setOnClickListener(v -> onClearClick());
    }

    private void onNumberClick(View view) {
        Button button = (Button) view;
        if (isOperatorClicked) {
            input = button.getText().toString();
            isOperatorClicked = false;
        } else {
            input += button.getText().toString();
        }
        txtResult.setText(input);
    }

    private void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        operand1 = Double.parseDouble(input);
        isOperatorClicked = true;
    }

    private void onEqualClick(View view) {
        double operand2 = Double.parseDouble(input);
        double result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
        }
        txtResult.setText(String.valueOf(result));
        input = String.valueOf(result);
    }

    private void onClearClick() {
        txtResult.setText("0");
        input = "";
        operator = "";
        operand1 = 0;
        isOperatorClicked = false;
    }
}
