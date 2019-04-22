package com.example.afinal;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class EighthActivity extends AppCompatActivity {
    private TextView t0;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private TextView t5;
    private TextView t6;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        t0=findViewById(R.id.text1);
        t1=findViewById(R.id.text2);
        t2=findViewById(R.id.text3);
        t3=findViewById(R.id.text4);
        t1=findViewById(R.id.text5);

        try {

            AssetManager am = getAssets();// If this line gives you ERROR then try AssetManager am=getActivity().getAssets();
            InputStream is = am.open("Book2.xls");
            Workbook wb = Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            Cell z1 = s.getCell(0, 0);
            String xx = "";
            xx = xx + z1.getContents();
            t1.setText(xx);
            Cell z2 = s.getCell(0, 9);
            xx = "";
            xx = xx + z2.getContents();
            t2.setText(xx);
            Cell z3 = s.getCell(0, 10);
            xx = "";
            xx = xx + z3.getContents();
            t3.setText(xx);

        }
        catch (Exception e){

        }

    }


}
