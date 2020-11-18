package edu.ai6613az.mnstate.project_mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {


        View v=  inflater.inflate(R.layout.fragment_home, container, false);


        TextView tx2 = (TextView) v.findViewById(R.id.female);
        tx2.setOnClickListener(this);

        TextView tx3 = (TextView) v.findViewById(R.id.listname);
        tx3.setOnClickListener(this);

        TextView txt4 = v.findViewById(R.id.hometxt);
        txt4.setOnClickListener(this);




        return v;




    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {

            case R.id.female:
                Intent intent1 = new Intent(getActivity(), Female.class);
                startActivity(intent1);
                break;
            case R.id.hometxt:
                Intent intent2 = new Intent(getActivity(), MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.listname:
                Intent intent3 = new Intent(getActivity(), List.class);
                startActivity(intent3);
                break;


        }

    }

}