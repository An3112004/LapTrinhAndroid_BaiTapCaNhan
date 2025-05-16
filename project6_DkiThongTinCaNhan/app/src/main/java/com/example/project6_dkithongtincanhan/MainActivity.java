package com.example.project6_dkithongtincanhan;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen;
    EditText edtCMND;
    RadioGroup radioGroupBangCap;
    CheckBox ckDocBao;
    CheckBox ckDocSach;
    CheckBox ckDocCoding;
    EditText edtThongTinBoSung;
    Button btnGuiThongTin;


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
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCMND = findViewById(R.id.edtCMND);
        radioGroupBangCap = findViewById(R.id.radioGroupBangCap);
        ckDocBao = findViewById(R.id.ckDocBao);
        ckDocSach = findViewById(R.id.ckDocSach);
        ckDocCoding = findViewById(R.id.ckDocCoding);
        btnGuiThongTin = findViewById(R.id.btnGuiThongTin);
        btnGuiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doShow();
            }
        });
    }

    public void doShow(){
        String ten = edtHoTen.getText().toString();
        ten = ten.trim();
        if(ten.length()<3){
            edtHoTen.requestFocus();
            edtHoTen.selectAll();
            Toast.makeText(this , "Họ phải nhiều hơn 3 kí tự" , Toast.LENGTH_SHORT).show();
            return;
        }

        String cmnd = edtCMND.getText().toString();
        cmnd = cmnd.trim();
        if(cmnd.length()!=9){
            edtCMND.requestFocus();
            edtCMND.selectAll();
            Toast.makeText(this , "CMND phải 9 kí tự" , Toast.LENGTH_SHORT).show();
            return;
        }

        String bangCap = "";
        int id = radioGroupBangCap.getCheckedRadioButtonId();
        radioGroupBangCap = findViewById(R.id.radioGroupBangCap);
        if (id == -1){
            Toast.makeText(this , "Chưa chọn bằng cấp" , Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioButton = findViewById(id);
        bangCap = radioButton.getText().toString();
        String sothich = "";
        if(ckDocBao.isChecked()){
            sothich += ckDocBao.getText().toString() + "";
        }
        if(ckDocSach.isChecked()){
            sothich += ckDocSach.getText().toString() + "";
        }
        if(ckDocCoding.isChecked()){
            sothich += ckDocCoding.getText().toString() + "";
        }
        String thongtin = edtThongTinBoSung.getText().toString();
        thongtin = thongtin.trim();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        String msg = ten+"\n";
        msg += cmnd+"\n";
        msg += bangCap+"\n";
        msg += sothich+"\n";
        msg +="----------";
        msg += "Thông tin bổ sung:\n";
        msg += thongtin+"";
        msg +="----------";
        builder.setMessage(msg);
        builder.create().show();
    }
    @SuppressWarnings("deprecation")
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure");
        b.setIcon(R.drawable.inform);
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        b.create().show();
    }
}