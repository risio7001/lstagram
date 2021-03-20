package com.example.lstagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            DocumentReference docRef = db.collection("users").document(user.getUid());
            if(docRef == null){
                startActivity(SignUp2Activity.class);
            }
        }



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public void onclick(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
        }
    }
    public void startActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
        finish();
    }

}