package com.example.cryptotrackerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class currencyRVadapter extends RecyclerView.Adapter<currencyRVadapter.ViewHolder> {
   private ArrayList<CurrencyModal> currencyModalArrayList;
   private Context context;
   private static DecimalFormat df2 =new DecimalFormat("#.##");

    public currencyRVadapter(ArrayList<CurrencyModal> currencyModalArrayList, Context context) {
        this.currencyModalArrayList = currencyModalArrayList;
        this.context = context;
    }
    public void filterList(ArrayList<CurrencyModal> filterllist) {
        // adding filtered list to our
        // array list and notifying data set changed
        currencyModalArrayList = filterllist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public currencyRVadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.currency_rv_item,parent,false);
        return new currencyRVadapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull currencyRVadapter.ViewHolder holder, int position) {
        CurrencyModal currencyModal =currencyModalArrayList.get(position);
        holder.currencyNameTV.setText(currencyModal.getName());
        holder.symbolTV.setText(currencyModal.getSymbol());
        holder.rateTV.setText("$ "+df2.format(currencyModal.getPrice()));
    }

    @Override
    public int getItemCount() {
        return currencyModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView currencyNameTV,symbolTV,rateTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            currencyNameTV=itemView.findViewById(R.id.idTVName);
            symbolTV=itemView.findViewById(R.id.idTVSymbol);
            rateTV=itemView.findViewById(R.id.idTVRate);
        }
    }
}
