package com.example.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThreepFiveActivity extends AppCompatActivity {
    private Button Dep;
    private Button Str;
    private Button Anx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threep_five);

        Dep=findViewById(R.id.button2);
        Str=findViewById(R.id.button1);
        Anx=findViewById(R.id.button3);
        Dep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDep();
            }
        });
        Anx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAnx();
            }
        });
    }

    public void openDep(){
        Intent intent= new Intent(this,FourthActivity.class);
        startActivity(intent);

    }

    public void openAnx(){
        Intent intent= new Intent(this,SixthActivity.class);
        startActivity(intent);

    }

}
