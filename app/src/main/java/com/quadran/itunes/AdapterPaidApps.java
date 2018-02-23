package com.quadran.itunes;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.quadran.itunes.domain.model.Entry;

import java.util.ArrayList;

/**
 * Created by mario on 27/11/2017.
 */

public class AdapterPaidApps extends RecyclerView.Adapter<AdapterPaidApps.PaidAppsViewHolder>{

    private ArrayList<Entry> listEntries;
    public MainActivity main;

    public AdapterPaidApps(ArrayList<Entry> listEntries, MainActivity main) {
        this.listEntries = listEntries;
        this.main = main;
    }

    @Override
    public PaidAppsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creamos un layout  y lo devolvemos como un holder para pintar los datos.
        View v = LayoutInflater.from(main).inflate(R.layout.item_apps,parent, false);
        return new PaidAppsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PaidAppsViewHolder holder, int position) {

        holder.titulo.setText(getItem(position).getTitle().getLabel());
        holder.name.setText(getItem(position).getName().getLabel());
        holder.indice.setText(String.valueOf(position+1));

    }


    @Override
    public int getItemCount() {

       // return listEntries == null? 0 : listEntries.size();  Otra manera de escribir la condicion del if.

        if (listEntries == null){
            return 0;
        }else {
            return listEntries.size();
        }
    }

    public Entry getItem(int position){
        return listEntries.get(position);
    }

    public class PaidAppsViewHolder extends RecyclerView.ViewHolder {

        TextView indice, titulo, name;
        ImageView image;

        public PaidAppsViewHolder(View itemView){
            super(itemView);
            indice = itemView.findViewById(R.id.textIndex);
            titulo = itemView.findViewById(R.id.textTitle);
            name = itemView.findViewById(R.id.textAuthor);
            image = itemView.findViewById(R.id.imageApp);
        }
    }
}
