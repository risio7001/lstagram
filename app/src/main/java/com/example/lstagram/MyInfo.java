package com.example.lstagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        findViewById(R.id.myInfo_delete).setOnClickListener(onclickListener);
        findViewById(R.id.myInfo_none).setOnClickListener(onclickListener);
        findViewById(R.id.myInfo_pass).setOnClickListener(onclickListener);
        findViewById(R.id.myInfo_post).setOnClickListener(onclickListener);

    }
    View.OnClickListener onclickListener = v -> {
        switch (v.getId()){
            case R.id.myInfo_delete:
                Toast.makeText(this, "삭제하기", Toast.LENGTH_SHORT).show();
                delete();
                break;
            case R.id.myInfo_none:
                Toast.makeText(this, "비활성화", Toast.LENGTH_SHORT).show();
                none();
                break;
            case R.id.myInfo_pass:
                Toast.makeText(this, "비밀번호 재설정", Toast.LENGTH_SHORT).show();
                pass();
                break;
            case R.id.myInfo_post:
                Toast.makeText(this, "게시물 보기", Toast.LENGTH_SHORT).show();
                post();
                break;
        }
    };

    private void delete(){
        startActivity(MyInfo_Delete.class);
    }
    private void none(){

    }
    private void pass(){
        startActivity(MyInfo_Pass.class);
    }
    private void post(){
        startActivity(MyInfo_Post.class);
    }
    public void startActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
        finish();
    }
}