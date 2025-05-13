package com.example.project4_bmi;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCalculate;
    EditText edtName, edtHeight, edtWeight;
    TextView txtBMI, txtDiagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCalculate = findViewById(R.id.btnCalculate);
        edtName = findViewById(R.id.edtName);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        txtBMI = findViewById(R.id.txtBMI);
        txtDiagnosis = findViewById(R.id.txtDiagnosis);

        btnCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                double H = Double.parseDouble(edtHeight.getText().toString());
                double W = Double.parseDouble(edtWeight.getText().toString());
                double BMI = W / (H * H);
                String chuandoan = "";

                if (BMI < 18){
                    chuandoan = "Bạn gầy";
                } else if (BMI <= 24.9){
                    chuandoan = "Bạn bình thường";
                } else if (BMI <= 29.9){
                    chuandoan = "Bạn béo phì cấp độ 1";
                }
                else if(BMI <= 34.9){
                    chuandoan = "Bạn béo phì cấp độ 2";
                }
                else{
                    chuandoan = "Bạn béo phì cấp độ 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.00");
                txtBMI.setText(dcf.format(BMI)+"");
                txtDiagnosis.setText(chuandoan);


            }
        });
    }
}