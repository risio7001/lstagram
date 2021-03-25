package com.example.lstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import DTO.userInfo;

public class SignUp2Activity extends AppCompatActivity {
    private static final String TAG = "SignUp2Activity";
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        findViewById(R.id.btn_signUp2).setOnClickListener(onclickListener);
        findViewById(R.id.signUp_reset).setOnClickListener(onclickListener);

    }

    View.OnClickListener onclickListener = v -> {
        switch(v.getId()){
            case R.id.btn_signUp2:
                signUp2();
                Toast.makeText(this, "입력완료", Toast.LENGTH_SHORT).show();
                break;
            case R.id.signUp_reset:
                Toast.makeText(this, "초기화", Toast.LENGTH_SHORT).show();
                reset();
                break;
        }
    };

    public void signUp2(){
        String name = ((EditText) findViewById(R.id.signUp2_name)).getText().toString();
        String age = ((EditText) findViewById(R.id.signUp2_age)).getText().toString();
        String phone = ((EditText) findViewById(R.id.signUp2_phone)).getText().toString();
        user = FirebaseAuth.getInstance().getCurrentUser();
        userInfo userInfo = new userInfo(user.getEmail(), name, age, phone);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").document(user.getUid())
                .set(userInfo).addOnSuccessListener(new OnSuccessListener<Void>() { // 추가정보 입력 성공시
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(SignUp2Activity.this, "추가 정보입력에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                startActivity(MainActivity.class);
            }
        })
                .addOnFailureListener(new OnFailureListener() {  //추가정보 입력 실패시
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignUp2Activity.this, "회원 정보입력에 실패하였습니다!", Toast.LENGTH_SHORT).show();
                        Log.w(TAG, "Error writing document", e);
                        return;
                    }
                });
    }
    public void reset(){
        EditText name = findViewById(R.id.signUp2_name);
        EditText age = findViewById(R.id.signUp2_age);
        EditText phone = findViewById(R.id.signUp2_phone);
        name.getText().clear();
        age.getText().clear();
        phone.getText().clear();
    }
    public void startActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
        finish();
    }
}