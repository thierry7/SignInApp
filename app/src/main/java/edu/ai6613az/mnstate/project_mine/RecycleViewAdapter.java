package edu.ai6613az.mnstate.project_mine;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Viewholder>
{
    private OnItemClickListener mListener;
    public interface OnItemClickListener
    {
        void onItemClick(int position);
        void onImageClick(int position);
    }
    private ArrayList<String> mEmpNames ;
    private Context mContex;


    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }


    public RecyclerViewAdapter(ArrayList<String> mEmpNames, Context mContex) {
        this.mEmpNames = mEmpNames;
        this.mContex = mContex;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list2, parent,false);
        Viewholder holder = new Viewholder(view, mListener);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Log.d(TAG, "onBindViewHolder: ");
        holder.name.setText(mEmpNames.get(position));



    }

    @Override
    public int getItemCount() {
        return mEmpNames.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;


        public Viewholder(@NonNull final View itemView, final OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_text2);
            image = itemView.findViewById(R.id.supp);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                            listener.onImageClick(position);
                    }
                }
            });

        }


    }



}
