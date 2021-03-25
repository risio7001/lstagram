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

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_signUp).setOnClickListener(onclickListener);
        findViewById(R.id.btn_forgot).setOnClickListener(onclickListener);
        findViewById(R.id.Login).setOnClickListener(onclickListener);

    }

    View.OnClickListener onclickListener = v -> {
      switch(v.getId()){
          case R.id.btn_signUp:
              Toast.makeText(this, "회원가입", Toast.LENGTH_SHORT).show();
              startActivity(SignUpActivity.class);
              finish();

              break;
          case R.id.btn_forgot:
              Toast.makeText(this, "계정찾기", Toast.LENGTH_SHORT).show();
              break;
          case R.id.Login:
              Toast.makeText(this, "로그인", Toast.LENGTH_SHORT).show();
              Login();
              break;

      }
    };
    public void Login(){
        EditText id = findViewById(R.id.signUp_email);
        EditText pw = findViewById(R.id.signUp_pw);

        String id2 = id.getText().toString();
        String pw2 = pw.getText().toString();

        if(id2.isEmpty()){
            Toast.makeText(this, "이메일을 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pw2.isEmpty()){
            Toast.makeText(this, "비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(id2, pw2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "로그인 성공");
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(MainActivity.class);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }
    public void startActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

}