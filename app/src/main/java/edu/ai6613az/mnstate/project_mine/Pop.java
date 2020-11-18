package edu.ai6613az.mnstate.project_mine;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.util.ArrayList;

public class Pop extends Female {


    TextView txt = findViewById(R.id.tv_text2);




    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);





        setContentView(R.layout.activity_list2);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)width*8,(int)height*6);




    }


}
