package com.example.afinal;

import android.content.Intent;
import android.content.res.AssetManager;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class SixthActivity extends AppCompatActivity {
    private ChatArrayAdapter chatArrayAdapter;
    private Button ans1;
    private Button ans2;
    private Button ans3;
    private Button ans4;
    private ListView listView;
    int x=1;
    private boolean side = false;
    int score=0;
    //ArrayList<Integer> number = new ArrayList<Integer>();
    //int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ques);
        ans1 = findViewById(R.id.button_next_question1);
        ans2 = findViewById(R.id.button_next_question2);
        ans3 = findViewById(R.id.button_next_question3);
        ans4 = findViewById(R.id.button_next_question4);
        listView = findViewById(R.id.msgview);

        chatArrayAdapter = new ChatArrayAdapter(getApplicationContext(), R.layout.right);
        listView.setAdapter(chatArrayAdapter);
        Question();
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatArrayAdapter.add(new ChatMessage(side, ans1.getText().toString()));
                side = !side;
                score=score+0;
                Question();

            }
        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatArrayAdapter.add(new ChatMessage(side, ans2.getText().toString()));
                side = !side;
                score=score+1;
                Question();
            }


        });
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatArrayAdapter.add(new ChatMessage(side, ans3.getText().toString()));
                side = !side;
                score=score+2;
                Question();
            }
        });
        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatArrayAdapter.add(new ChatMessage(side, ans4.getText().toString()));
                side = !side;
                score=score+3;
                Question();
            }
        });

        listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        listView.setAdapter(chatArrayAdapter);

        //to scroll the list view to bottom on data change
        chatArrayAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chatArrayAdapter.getCount() - 1);
            }
        });

    }



    public void Question(){
        String a="",b="",c="",d="";
        try {
            if(x<=7)
            {
                AssetManager am = getAssets();// If this line gives you ERROR then try AssetManager am=getActivity().getAssets();
                InputStream is = am.open("Q_set.xls");
                Workbook wb = Workbook.getWorkbook(is);
                Sheet s = wb.getSheet(2);
                Cell z = s.getCell(0, x);
                String xx = "";
                xx = xx + z.getContents();
                chatArrayAdapter.add(new ChatMessage(side, xx));
                side = !side;
                x=x+1;
            }
            else
                checkScore();

        }
        catch (Exception e){

        }

    }
    public void checkScore(){
        if(score<10){
            Intent intent= new Intent(this,EighthActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent= new Intent(this,EighthActivity.class);
            startActivity(intent);
        }




    }

}
