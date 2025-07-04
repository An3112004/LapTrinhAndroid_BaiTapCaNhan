package com.example.Lab3_Caculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project3.R;

public class MainActivity extends AppCompatActivity {


    EditText edtA, edtB, edtResult;
    Button btnSum, btnQuotient, btnProduct, btnDifference;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnSum = findViewById(R.id.btnSum);
        btnQuotient = findViewById(R.id.btnQuotient);
        btnProduct = findViewById(R.id.btnProduct);
        btnDifference = findViewById(R.id.btnDifference);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtResult = findViewById(R.id.edtResult);
        btnSum.setOnClickListener(v -> {
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());
            int result = a + b;
            edtResult.setText(String.valueOf(result));
        });
        btnQuotient.setOnClickListener(v -> {
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());
            int result = a / b;
            edtResult.setText(String.valueOf(result));
        });
        btnProduct.setOnClickListener(v -> {
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());
            int result = a * b;
            edtResult.setText(String.valueOf(result));
        });
        btnDifference.setOnClickListener(v -> {
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());
            int result = a - b;
            edtResult.setText(String.valueOf(result));
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}