package com.baba.todoapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.nio.DoubleBuffer;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

class Adapter extends RecyclerView.Adapter<Adapter.Cviewholder> {
   List<Notes> notesList;

   private Context context;

    public Adapter(List<Notes> notesList, Context context) {
        this.context = context;
        this.notesList=notesList;



    }


    @NonNull
    @Override
    public Cviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        @SuppressLint("ResourceType") View view = inflater.inflate(R.layout.item,parent,false);


        return new Cviewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Cviewholder holder, int position) {

       Notes data = notesList.get(position);
       holder.textView.setText(data.getTital());
       holder.textView1.setText(data.getDesc());

    }

    @Override
    public int getItemCount() {

        return notesList.size();

    }

    public static class Cviewholder extends RecyclerView.ViewHolder{



        TextView textView;
        TextView textView1;

        public Cviewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            textView1 = itemView.findViewById(R.id.text2);



        }
    }
}
