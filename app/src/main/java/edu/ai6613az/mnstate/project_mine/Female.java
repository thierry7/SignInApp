/**
 * Name: Thierry Oke
 * Project 1
 * description: The following program is a android prgram intend to sign people information and save it to a list and show the list of all signed
 * Date: Feb 23 2020
 * Updated: April 5, 2020
 *
 */
package edu.ai6613az.mnstate.project_mine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Female extends AppCompatActivity implements CalendarFrag.OnCalendarFragment{

    CalendarFrag mcalandarFragment;
    DisplayFragment mDisplayFragment;
    Button buttonstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_female);


        FragmentManager fragmentManager =getSupportFragmentManager();
        mDisplayFragment = (DisplayFragment) fragmentManager.findFragmentById(R.id.display);
        if(mDisplayFragment ==null)
        {
            mDisplayFragment = new DisplayFragment();
            fragmentManager.beginTransaction().add(R.id.display, mDisplayFragment).commit();
        }
        mcalandarFragment = (CalendarFrag) fragmentManager.findFragmentById(R.id.calandar);
        if(mcalandarFragment ==null)
        {
            mcalandarFragment = new CalendarFrag();
            fragmentManager.beginTransaction().add(R.id.calandar, mcalandarFragment).commit();
        }

    }

    @Override
    public void passLName(String a) {
        mDisplayFragment.getLname(a);
    }

    @Override
    public void passMName(String x) {
        mDisplayFragment.getMname(x);

    }

    @Override
    public void passFName(String y) {
        mDisplayFragment.getFname(y);

    }

    public  void messageFromCalandarFragment(int a, int b, int c)
    {
        mDisplayFragment.msgReceived(a, b, c);
    }


    @Override
    public void radioSender(String a) {
        mDisplayFragment.sradioSender(a);

    }




}