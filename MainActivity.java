package com.example.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.afinal.R;

public class MainActivity extends AppCompatActivity {

    private Button signin;
    private EditText eno;
    private EditText namee;
    private EditText eid;
    private EditText pas;
    private EditText agee;
    private EditText phno;
    String a="",b="",c="",d="",e="",f="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signin=findViewById(R.id.button_signin);
        eno=findViewById(R.id.enoentry);
        namee=findViewById(R.id.nameentry);
        eid=findViewById(R.id.emailentry);
        pas=findViewById(R.id.passentry);
        agee=findViewById(R.id.ageentry);
        phno=findViewById(R.id.pnoentry);

        a=namee.getText().toString();
        b=eid.getText().toString();
        c=pas.getText().toString();
        d=agee.getText().toString();
        e=phno.getText().toString();
        f=eno.getText().toString();


        signin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(a!="" && b!=""&& c!="" && d!=""&& e!="" && f!="" )
                    openSecondActivity();
                else
                    Toast.makeText(MainActivity.this, "Please fill details", Toast.LENGTH_SHORT).show();


            }
        });
    }

    public void openSecondActivity(){
        Intent intent= new Intent(this,SecondActivity.class);
        String x=eno.getText().toString();
        Bundle bundle= new Bundle();
        bundle.putString("stuff",x);
        intent.putExtras(bundle);
        startActivity(intent);


    }
}
