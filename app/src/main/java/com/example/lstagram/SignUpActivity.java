package com.example.lstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "SignUpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        findViewById(R.id.SignUp).setOnClickListener(onclickListener);

    }

    View.OnClickListener onclickListener = v -> {
      switch(v.getId()){
          case R.id.SignUp:
              Toast.makeText(this, "회원가입하기", Toast.LENGTH_SHORT).show();
              SignUp();
              break;
          case R.id.reset:
              Toast.makeText(this, "재입력 바랍니다.", Toast.LENGTH_SHORT).show();
              break;
      }
    };


    public void SignUp(){
        String id = ((EditText) findViewById(R.id.signUp_email)).getText().toString();
        String pw = ((EditText) findViewById(R.id.signUp_pw)).getText().toString();
        String pw2 = ((EditText) findViewById(R.id.signUp_pw2)).getText().toString();

        if(id.isEmpty()){
            Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pw.isEmpty()){
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pw2.isEmpty()){
            Toast.makeText(this, "비밀번호확인란을 입력해주세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(!pw.equals(pw2)){
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        try{
            mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(id, pw)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                startActivity(MainActivity.class);
//                                Info(id, pw, user.getUid());
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }catch (Exception e){
            Toast.makeText(this, "형식을 확인해 주세요.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    public void startActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
        finish();
    }

//    private void Info(String id, String pw, String key){
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        DocumentReference docu = db.collection("user").document(key);
//        users users = new users(id, pw, "", "", key);
//        docu.set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                Log.d(TAG, "user 저장 성공");
//            }
//        })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "user 저장 실패", e);
//                    }
//                });
//    }
}