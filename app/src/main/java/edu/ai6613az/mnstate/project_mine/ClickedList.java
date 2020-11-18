package edu.ai6613az.mnstate.project_mine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ClickedList extends AppCompatActivity {
    private ArrayList arrayList;
    private String lname;
    private String fname;
    private String mname;
    private String phone;
    DatabaseHelper mHelper;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_list);
        Intent intent = getIntent();
        Bundle b = new Bundle();
        b = getIntent().getExtras();
        arrayList = b.getStringArrayList("list");
        int pos = b.getInt("position");
        int seek = b.getInt("seek");
        lname = arrayList.get(pos*4).toString();
        fname = arrayList.get((pos*4)+1).toString();
        mname = arrayList.get((pos*4)+2).toString();
        phone = arrayList.get((pos*4)+3).toString();
        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);
        textView4 = findViewById(R.id.text4);
        textView5 = findViewById(R.id.text5);
        textView1.setText(lname);
        textView2.setText(fname);
        textView3.setText(mname);
        textView4.setText(phone);
        textView5.setText("Rate: "+seek);

    }
    public int getItemCount() {
        return arrayList.size()/4;
    }
}
