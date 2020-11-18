package edu.ai6613az.mnstate.project_mine;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {
    private TextView MsgReceiver;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_display, container, false);
        MsgReceiver = v.findViewById(R.id.date);
        textView = v.findViewById(R.id.lname);
        textView3 = v.findViewById(R.id.Mname);
        textView4 = v.findViewById(R.id.Fname);
        textView5 = v.findViewById(R.id.status);


        return v;


    }
    @SuppressLint("SetTextI18n")
    public void msgReceived(int y, int m, int d )
    {
        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        int Nd = today.monthDay;
        int Nm = today.month+1;
        int Ny = today.year;
        int ageY = Ny-y;

        if(Nm ==1)
            MsgReceiver.setText("Today is: January" +" "+ Nd +"," + Ny);
        if(Nm ==2)
            MsgReceiver.setText("Today is: Febuary" +" "+ Nd +"," + Ny);
        if(Nm ==3)
            MsgReceiver.setText("Today is: March" +" "+ Nd +"," + Ny);
        if(Nm ==4)
            MsgReceiver.setText("Today is: April" +" "+ Nd +"," + Ny);
        if(Nm ==5)
            MsgReceiver.setText("Today is: May" +" "+ Nd +"," + Ny);
        if(Nm ==6)
            MsgReceiver.setText("Today is: June" +" "+ Nd +"," + Ny);
        if(Nm ==7)
            MsgReceiver.setText("Today is: July" +" "+ Nd +"," + Ny);
        if(Nm ==8)
            MsgReceiver.setText("Today is: August" +" "+ Nd +"," + Ny);
        if(Nm ==9)
            MsgReceiver.setText("Today is: September" +" "+ Nd +"," + Ny);
        if(Nm ==10)
            MsgReceiver.setText("Today is: October" +" "+ Nd +"," + Ny);
        if(Nm ==11)
            MsgReceiver.setText("Today is: November" +" "+ Nd +"," + Ny);
        if(Nm ==12)
            MsgReceiver.setText("Today is: December" +" "+ Nd +"," + Ny);



    }


    public void sradioSender(String a)
    {

        textView5.setText(a);

    }

    public void getLname(String a) {

        textView.setText(a);
    }

    public void getMname(String x) {
        textView3.setText(x);
    }

    public void getFname(String y) {
        textView4.setText(y);
    }
}
