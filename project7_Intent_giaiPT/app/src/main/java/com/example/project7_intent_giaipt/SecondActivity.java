package com.example.project7_intent_giaipt;

import android.content.Intent;
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

public class SecondActivity extends AppCompatActivity {
    private TextView txtkq;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtkq = findViewById(R.id.textView4);
        btnBack = findViewById(R.id.button4);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bde");
        int a = bundle.getInt("a");
        int b = bundle.getInt("b");

        String kq = "";
        if(a == 0 && b ==0) {
            kq = "Vô số nghiệm";
        }
        else if(a == 0 && b != 0) {
            kq = "Vô nghiệm";
        }
        else {
            DecimalFormat dcf = new DecimalFormat("0.##");
            kq = "x = " + (-b / a);
        }
        txtkq.setText(kq);
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}