package com.jono.app;
import android.os.Bundle; import android.widget.Button; import android.widget.Toast; import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity { @Override protected void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_main); Button btn=findViewById(R.id.btnFeed); btn.setOnClickListener(v->Toast.makeText(this,"Jono Home Feed is ready for the next module.",Toast.LENGTH_SHORT).show()); } }
