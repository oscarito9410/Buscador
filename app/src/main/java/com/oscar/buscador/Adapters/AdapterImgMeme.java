package com.oscar.buscador.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oscar.buscador.API.Model.Result;
import com.oscar.buscador.R;

import java.util.ArrayList;

/**
 * Created by oemy9 on 03/12/2017.
 */

public class AdapterImgMeme extends RecyclerView.Adapter<AdapterImgMeme.ViewHolderImg> {

    private ArrayList<Result>listMeme;
    private Context ctx;
    private LayoutInflater inflater;

    private ItemClickListener listener;

    public AdapterImgMeme(ArrayList<Result> listMeme, Context ctx) {
        this.listMeme = listMeme;
        this.ctx = ctx;
        this.inflater=LayoutInflater.from(this.ctx);
    }

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolderImg onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_meme,parent,false);
        return new ViewHolderImg(v);
    }

    @Override
    public void onBindViewHolder(ViewHolderImg holder, final int position) {
        final Result r=listMeme.get(position);
        holder.tvTitulo.setText(r.getDisplayName());
        Glide.with(ctx).load(r.getImageUrl())
                .fitCenter()
                .placeholder(R.drawable.placeholder)
                .into(holder.imgMeme);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    listener.onItemClick(position,r);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMeme.size();
    }

    public class ViewHolderImg extends RecyclerView.ViewHolder{
        public TextView tvTitulo;
        public ImageView imgMeme;

        public ViewHolderImg(View itemView) {
            super(itemView);
            tvTitulo=(TextView)itemView.findViewById(R.id.tvTitulo);
            imgMeme=(ImageView)itemView.findViewById(R.id.imgMeme);
        }
    }
}
