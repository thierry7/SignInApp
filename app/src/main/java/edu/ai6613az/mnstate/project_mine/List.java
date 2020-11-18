package edu.ai6613az.mnstate.project_mine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static android.os.Build.VERSION_CODES.O;
import static edu.ai6613az.mnstate.project_mine.RecyclerViewAdapter.*;

public class List extends AppCompatActivity {
   String t1;

    ArrayList arrayList1;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    ArrayList arrayList;
    DatabaseHelper mHelper;
    String [] spn = {"SORTED", "NOTSORTED"};
    Spinner spinner;
    ImageView imageView;
    FloatingActionButton myFab;
    SeekBar seekBar;
    int sekkbarnum =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        imageView = findViewById(R.id.supp);
        seekBar = findViewById(R.id.seekbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                sekkbarnum= progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        spinner = findViewById(R.id.Spiner);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spn));
        myFab = (FloatingActionButton) findViewById(R.id.imgFour);
        mHelper = new DatabaseHelper(this);
        arrayList = mHelper.retrievementEmployees();
        arrayList1 = mHelper.retrievementNameEmployees();

        recyclerView = findViewById(R.id.recycleView);
        adapter = new RecyclerViewAdapter(arrayList1, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                    sortbyFnameame();
                }
                else
                    sortbyLname();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                        Intent intent = new Intent(List.this, ClickedList.class);
                        Bundle bundle = new Bundle();
                        intent.putExtra("position", position);
                        intent.putExtra("list", arrayList);
                        intent.putExtra("seek", sekkbarnum);
                        startActivity(intent);

            }

            @Override
            public void onImageClick(int position) {
                mHelper.deleteRow(arrayList1.get(position).toString());

                arrayList1.remove(position);
                adapter.notifyDataSetChanged();

            }
        });
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(List.this, Female.class);
                startActivity(intent1);
            }
        });



    }

    private void sortbyFnameame() {
        Collections.sort(arrayList1);
        adapter.notifyDataSetChanged();
    }
    private void sortbyLname()
    {
        Collections.shuffle(arrayList1);
        adapter.notifyDataSetChanged();
    }


}
