package com.example.lstagram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MyInfo_Pass extends AppCompatActivity {
    FirebaseUser user;
    private static final String TAG = "MyInfo_Pass";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info__pass);

        Button btn_pass = findViewById(R.id.btn_pass);
        btn_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }
    public void sendEmail(){
        String et_email = ((EditText)findViewById(R.id.pass_email)).getText().toString();
        user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String email = user.getEmail();
        if(email.equals(et_email)){
            auth.sendPasswordResetEmail(user.getEmail()).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        TextView pass = findViewById(R.id.pass_text);
                        pass.setText("이메일 발송 완료");
                        Toast.makeText(MyInfo_Pass.this, email + "로 비밀번호 재설정 메일이 발송되었습니다. \n자동 로그아웃 되었습니다.", Toast.LENGTH_LONG).show();
                        FirebaseAuth.getInstance().signOut();
                    }else{
                        Toast.makeText(MyInfo_Pass.this, "이메일을 확인해 주세요.", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }else{
            Toast.makeText(this, "로그인된 이메일과 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}