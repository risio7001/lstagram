package com.example.lstagram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyInfo_Pass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info__pass);

        Button btn_pass = findViewById(R.id.btn_pass);
        btn_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView pass = findViewById(R.id.pass_text);
                sendEmail();
                pass.setText("이메일 발송 완료");
            }
        });
    }
    public void sendEmail(){

    }

}