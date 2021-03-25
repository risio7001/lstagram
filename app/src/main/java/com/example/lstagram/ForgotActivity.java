package com.example.lstagram;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseUser;

public class ForgotActivity extends AppCompatActivity {
    private static final String TAG = "ForgotActivity";
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        findViewById(R.id.myInfo_delete).setOnClickListener(onclickListener);
        findViewById(R.id.myInfo_none).setOnClickListener(onclickListener);
        findViewById(R.id.myInfo_pass).setOnClickListener(onclickListener);
        findViewById(R.id.myInfo_post).setOnClickListener(onclickListener);

    }

    View.OnClickListener onclickListener = v -> {
      switch (v.getId()){
          case R.id.myInfo_delete:
              Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
              delete();
              break;
          case R.id.myInfo_none:
              Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
              none();
              break;
          case R.id.myInfo_pass:
              Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
              pass();
              break;
          case R.id.myInfo_post:
              Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
              post();
              break;
      }
    };

    private void delete(){

    }
    private void none(){

    }
    private void pass(){

    }
    private void post(){

    }
}