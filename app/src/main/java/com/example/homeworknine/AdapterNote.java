package com.example.homeworknine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class AdapterNote extends RecyclerView.Adapter<AdapterNote.MyViewHolder> {

    private CardSource dataSource;

    public AdapterNote(CardSource dataSource) {
        this.dataSource = dataSource;
    }

    private MyOnClickListener listener;

    public void setOnMyOnClickListener(MyOnClickListener listener){
        this.listener = listener;
    }

    public void setData(CardSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textNote.setText(dataSource.getCardData(position).getNote());
        holder.textDescription.setText(dataSource.getCardData(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textNote;
        private TextView textDescription;

        public MyViewHolder(View itemView) {
            super(itemView);
            textNote = itemView.findViewById(R.id.textNote);
            textDescription = itemView.findViewById(R.id.textDescription);

            textNote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onMyClick(view, getAdapterPosition());
                }
            });
        }
    }
}
