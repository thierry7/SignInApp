package edu.ai6613az.mnstate.project_mine;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Context.NOTIFICATION_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFrag extends Fragment {

    private OnCalendarFragment mCallback;
    private  CalendarView mcalendarView;
    RadioGroup radiogroup;
    Spinner spinner;
    String selectedValue;
    String value;
    RadioButton selected;
    SeekBar seekBar;
    EditText editText;
    ImageButton imageButton;

    int y, m, d;

    ArrayList<String> mylist = new ArrayList<>();
    DatabaseHelper mhelper;
    SharedPreferences sharedPreferences;
    private EditText txt1;
    private  EditText txt2;
    private  EditText txt3;
    private  EditText txt4;

    public static final String MY_PREFS = "Myprefs";
    public static final String MY_NAME = "fname";
    public static final String FNAME = "lname";
    public static final String M_NAME = "mname";
    public static final String PHONE_NUM = "phone";



    public CalendarFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_calendar, container, false);


        mhelper = new DatabaseHelper(getContext());
        txt1 = v.findViewById(R.id.editText);
        txt2 = v.findViewById(R.id.editText1);
        txt3 = v.findViewById(R.id.editText2);
        txt4 = v.findViewById(R.id.editText3);
        sharedPreferences = getContext().getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        Button ref = v.findViewById(R.id.shareref);

        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = "None";
                String text2= "None";
                String text3= "NONE";
                String text4="NONE";
                String uname = sharedPreferences.getString(MY_NAME, text1);
                String fName = sharedPreferences.getString(FNAME, text2);
                String Mname = sharedPreferences.getString(M_NAME, text3);
                String phn = sharedPreferences.getString(PHONE_NUM, text4);

                mCallback.passFName(uname);
                mCallback.passLName(fName);
                mCallback.passMName(Mname);
                mCallback.radioSender(phn);
/*
                txt1.setText(uname);
                txt2.setText(fName);
                txt3.setText(Mname);
                txt4.setText(phn);
*/
            }
        });


        Button button = v.findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {

                if (txt1.getText().toString().trim().length() > 0 &&
                        txt2.getText().toString().trim().length() > 0 &&
                        txt3.getText().toString().trim().length() > 0 &&
                        txt4.getText().toString().trim().length() > 0
                ) {
                    mhelper.insert(txt1.getText().toString().trim(),
                            txt2.getText().toString().trim(),
                            txt3.getText().toString().trim(),txt4.getText().toString().trim());
                    String a = txt1.getText().toString();
                    String b = txt2.getText().toString();
                    String c = txt3.getText().toString();
                    String d = txt4.getText().toString();
                    SharedPreferences.Editor ed = sharedPreferences.edit();
                    ed.putString(MY_NAME, a);
                    ed.putString(FNAME, b);
                    ed.putString(M_NAME, c);
                    ed.putString(PHONE_NUM, d);
                    ed.commit();

                    txt1.getText().clear();
                    txt2.getText().clear();
                    txt3.getText().clear();
                    txt4.getText().clear();



                    Toast.makeText(getContext(), "Added", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(getContext(), "Not added One or more element missing!!!", Toast.LENGTH_LONG).show();


            }


        });

        mcalendarView = v.findViewById(R.id.calendarView);

        imageButton = v.findViewById(R.id.imageButton1);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = "None";
                String text2= "None";
                String text3= "NONE";
                String text4="NONE";
                String uname = sharedPreferences.getString(MY_NAME, text1);
                String fName = sharedPreferences.getString(FNAME, text2);
                String Mname = sharedPreferences.getString(M_NAME, text3);
                String phn = sharedPreferences.getString(PHONE_NUM, text4);
/*
                mCallback.passFName(uname);
                mCallback.passLName(fName);
                mCallback.passMName(Mname);
                mCallback.radioSender(phn);
*/
                txt1.setText(uname);
                txt2.setText(fName);
                txt3.setText(Mname);
                txt4.setText(phn);

            }
        });

        radiogroup = v.findViewById(R.id.radio);
        mcalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                y = year;
                m = month;
                d = dayOfMonth;
                mCallback.messageFromCalandarFragment(y, m, d);

            }
        });


        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.married: {
                        selected = radiogroup.findViewById(checkedId);
                        txt4.setText(selected.getText().toString());
                    }

                    break;
                    case R.id.single:
                    {
                        selected = radiogroup.findViewById(checkedId);
                        txt4.setText(selected.getText().toString());
                        // Fragment 2
                        break;
                    }
                    case R.id.widow:
                    {
                        selected = radiogroup.findViewById(R.id.widow);
                        txt4.setText(selected.getText().toString());
                        break;
                    }

                    case R.id.divorced:
                    {
                        selected = radiogroup.findViewById(R.id.divorced);
                        txt4.setText(selected.getText().toString());
                        break;
                    }
                }
            }
        });




        return v;
    }


    public void onAttach(Context context)
    {
        super.onAttach(context);
        if(context instanceof OnCalendarFragment)
        {
            mCallback =(OnCalendarFragment) context;
        }
        else
            throw new RuntimeException(context.toString() + "Must implement the Onfragment_greenListener");


    }
    public  void onDetach()
    {
        super.onDetach();
        mCallback= null;
    }


    public  interface OnCalendarFragment
    {
        void passLName(String a);
        void passMName(String x);
        void passFName(String y);
        void messageFromCalandarFragment(int yr, int mth, int dy);
        void radioSender(String a);

    }

}
