package com.example.afinal;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button  next;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        button = findViewById(R.id.button_eno1);
        next=findViewById(R.id.button_next);
        Bundle bundle=getIntent().getExtras();
        final String stuff=bundle.getString("stuff");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+stuff));

               if (ActivityCompat.checkSelfPermission(SecondActivity.this,
                        Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                   startActivity(callIntent);
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThirdActivity();
            }
        });

    }

    public void openThirdActivity(){
        Intent intent1= new Intent(this,ThirdActivity.class);
        startActivity(intent1);

    }
}


