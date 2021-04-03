package com.example.lstagram;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class InsertPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_post);

        findViewById(R.id.upload).setOnClickListener(onclickListener);
        findViewById(R.id.gallery).setOnClickListener(onclickListener);
        findViewById(R.id.picture).setOnClickListener(onclickListener);

    }

    View.OnClickListener onclickListener = v -> {
        switch (v.getId()){
            case R.id.upload:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                upload();
                break;
            case R.id.gallery:
                if (ContextCompat.checkSelfPermission(InsertPost.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(InsertPost.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                    if (ActivityCompat.shouldShowRequestPermissionRationale(InsertPost.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    } else {
                        Toast.makeText(this, "권한을 허용해 주세요", Toast.LENGTH_SHORT);
                    }
                } else {
                    gallery();
                }
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.picture:
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                picture();
                break;
        }
    };
    public void gallery(){ // 사진 선택 권한 받아야함.

        Intent intent = new Intent(this, Gallery.class);
        startActivity(intent);

    }
    public void picture(){

    }
    public void upload(){

    }

}