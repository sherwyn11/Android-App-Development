package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greeting);
        next=findViewById(R.id.button_letsdothis);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTPFActivity();
            }
        });
    }

    public void openTPFActivity(){
        Intent intent= new Intent(this,ThreepFiveActivity.class);
        startActivity(intent);

    }
}


