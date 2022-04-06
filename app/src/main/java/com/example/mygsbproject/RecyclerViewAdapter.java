package com.example.mygsbproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private ArrayList<Praticien> dataModelList;

    public RecyclerViewAdapter(ArrayList<Praticien> dataModelList){ this.dataModelList = dataModelList; }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.tvnom.setText(String.valueOf(dataModelList.get(position).getPra_nom()));
        holder.tvprenom.setText(String.valueOf(dataModelList.get(position).getPra_prenom()));
    }

    public long getItemId(int position ){
        return super.getItemId(position);
    }
    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvnom;
        TextView tvprenom;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
             tvnom = itemView.findViewById(R.id.Nom);
             tvprenom = itemView.findViewById(R.id.Prenom);

        }
    }
}
