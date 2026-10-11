package com.jono.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth; private FirebaseFirestore db;
    private EditText email, password;

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b); setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance(); db=FirebaseFirestore.getInstance();
        email=findViewById(R.id.email); password=findViewById(R.id.password);
        findViewById(R.id.login).setOnClickListener(v -> login());
        findViewById(R.id.register).setOnClickListener(v -> register());
    }
    private void login() {
        String e=email.getText().toString().trim(), p=password.getText().toString();
        if(e.isEmpty()||p.isEmpty()){toast("Email ও Password দিন");return;}
        auth.signInWithEmailAndPassword(e,p).addOnCompleteListener(t -> {
            if(t.isSuccessful()) showHome(); else toast("Login failed");
        });
    }
    private void register() {
        String e=email.getText().toString().trim(), p=password.getText().toString();
        if(e.isEmpty()||p.length()<6){toast("Email দিন এবং Password কমপক্ষে ৬ অক্ষরের দিন");return;}
        auth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(t -> {
            if(t.isSuccessful()){
                String uid=auth.getCurrentUser().getUid(); Map<String,Object> u=new HashMap<>();
                u.put("uid",uid); u.put("email",e); u.put("displayName","Jono User");
                u.put("followersCount",0); u.put("followingCount",0); u.put("friendsCount",0);
                u.put("verified",false); u.put("role","user");
                db.collection("users").document(uid).set(u).addOnCompleteListener(x -> showHome());
            } else toast("Register failed");
        });
    }
    private void showHome() {
        TextView home=new TextView(this); home.setText("Jono\n\nHome Feed\n\nআপনি সফলভাবে Login করেছেন।");
        home.setTextSize(24); home.setPadding(40,80,40,40); setContentView(home);
    }
    private void toast(String s){Toast.makeText(this,s,Toast.LENGTH_LONG).show();}
}
