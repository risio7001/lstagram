package com.example.lstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            DocumentReference docRef = db.collection("users").document(user.getUid());
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                            TextView textView2 = findViewById(R.id.textView2);
                            textView2.setText(user.getEmail());
                        } else {
                            startActivity(SignUp2Activity.class);
                            Log.d(TAG, "No such document");
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            getMenuInflater().inflate(R.menu.menu, menu);
        }
        else{
            getMenuInflater().inflate(R.menu.menu2, menu);
        }
        return true;
    }
    public void onclick(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.menu2_myPost:
                Toast.makeText(this, "내정보", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2_cs:
                Toast.makeText(this, "고객센터", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2_signOut:
                Toast.makeText(this, "로그아웃", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                startActivity(LoginActivity.class);
                break;
        }
    }
    public void startActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
        finish();
    }
}