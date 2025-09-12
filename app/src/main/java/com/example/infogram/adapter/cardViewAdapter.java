package com.example.infogram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infogram.R;
import com.example.infogram.model.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class cardViewAdapter extends RecyclerView.Adapter<cardViewAdapter.cardViewHolder> {

    //lista de imagenes
    private ArrayList<Image> images;
    private int resource;
    private Activity activity;

    public cardViewAdapter(ArrayList<Image> images, int resorce, Activity activity) {
        this.images = images;
        this.resource = resorce;
        this.activity = activity;
    }

    @NonNull
    @Override
    public cardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);


        return new cardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cardViewHolder holder, int position) {
        Image image = images.get(position);
       //image
        Picasso.get().load(image.getUrlImagen()).into(holder.imagesCardView);
        holder.userNameCardView.setText(image.getUserName());
        holder.cantidadDias.setText(image.getCantidadDias());
        holder.cantidadMeGusta.setText(image.getCantidadMeGusta());


    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class cardViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagesCardView;
        private TextView userNameCardView;
        private TextView cantidadDias;
        private TextView cantidadMeGusta;

        public cardViewHolder(@NonNull View itemView) {
            super(itemView);
            imagesCardView = itemView.findViewById(R.id.imagesCardView);
            userNameCardView = itemView.findViewById(R.id.userNameCardView);
            cantidadDias = itemView.findViewById(R.id.cantidadDias);
            cantidadMeGusta = itemView.findViewById(R.id.cantidadMeGusta);
        }
    }


}
