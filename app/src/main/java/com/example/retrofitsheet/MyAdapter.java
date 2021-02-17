package com.example.retrofitsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitsheet.Model.Model;
import com.example.retrofitsheet.Model.Sheet1;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {

    private Context context;
    private ArrayList<Sheet1> data;


    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView id;
        TextView name;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.id);
            name = (TextView) itemView.findViewById(R.id.name);

        }
    }

    public MyAdapter(Context context, ArrayList<Sheet1> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false);

        return new MyViewholder(view);

    }



    public void onBindViewHolder(@NonNull MyAdapter.MyViewholder holder, final int i) {

        Sheet1 user = data.get(i);

        holder.id.setText(user.getName());
        holder.name.setText(user.getCountry());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }




}
