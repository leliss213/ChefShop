package com.example.chefshop;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import modelDominio.Receita;


public class ReceitaAdapter extends RecyclerView.Adapter<ReceitaAdapter.MyViewHolder> {
    private List<Receita> listaReceitas;
    private ReceitaOnClickListener receitaOnClickListener;

    public ReceitaAdapter(List<Receita> listaReceitas, ReceitaOnClickListener receitaOnClickListener) {
        this.listaReceitas = listaReceitas;
        this.receitaOnClickListener = receitaOnClickListener;
    }

    @Override
    public ReceitaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row_receita, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ReceitaAdapter.MyViewHolder holder, final int position) {
        Receita minhaReceita = listaReceitas.get(position);
        holder.tvReceitaNome.setText(minhaReceita.getNomeReceita());
        holder.tvReceitaCategoria.setText(minhaReceita.getTipoLiteral());
        Bitmap bitmap = BitmapFactory.decodeByteArray(minhaReceita.getImagemReceita(), 0, minhaReceita.getImagemReceita().length);
        holder.ivImagemReceita.setImageBitmap(bitmap);
        // clique no item do cliente
        if (receitaOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    receitaOnClickListener.onClickReceita(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaReceitas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvReceitaNome, tvReceitaCategoria;
        ImageView ivImagemReceita;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvReceitaNome = (TextView) itemView.findViewById(R.id.tvReceitaNome);
            tvReceitaCategoria = (TextView) itemView.findViewById(R.id.tvReceitaCategoria);
            ivImagemReceita = itemView.findViewById(R.id.ivImagemReceita);
        }
    }

    public interface ReceitaOnClickListener {
        public void onClickReceita(View view, int position);
    }

}