package com.example.recyclerviewtest;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtest.Adapter.StudentAdapter;
import com.example.recyclerviewtest.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    StudentAdapter adapter;
    List<Student> studentList;
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
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentList = new ArrayList<>();
        studentList.add(new Student("Nguyễn Văn A", 17, "12A1"));
        studentList.add(new Student("Lê Thị B", 18, "12A2"));
        studentList.add(new Student("Phạm Văn C", 17, "12A3"));
        studentList.add(new Student("Trần Thị D", 19, "12A4"));
        studentList.add(new Student("Nguyễn Văn E", 17, "12A5"));
        studentList.add(new Student("Lê Thị F", 18, "12A6"));
        studentList.add(new Student("Phạm Văn G", 17, "12A7"));
        studentList.add(new Student("Trần Thị H", 19, "12A8"));
        studentList.add(new Student("Nguyễn Văn I", 17, "12A9"));
        studentList.add(new Student("Lê Thị K", 18, "12A10"));
        studentList.add(new Student("Phạm Văn L", 17, "12A11"));
        studentList.add(new Student("Trần Thị M", 19, "12A12"));
        studentList.add(new Student("Nguyễn Văn N", 17, "12A13"));
        studentList.add(new Student("Lê Thị O", 18, "12A14"));
        studentList.add(new Student("Phạm Văn P", 17, "12A15"));
        studentList.add(new Student("Trần Thị Q", 19, "12A16"));

        adapter = new StudentAdapter(this, studentList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}