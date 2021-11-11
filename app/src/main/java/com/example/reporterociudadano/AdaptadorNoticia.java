package com.example.reporterociudadano;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AdaptadorNoticia extends RecyclerView.Adapter<AdaptadorNoticia.ViewHolder> {

    private ArrayList<Noticia> noticias;

    public AdaptadorNoticia(ArrayList<Noticia> noticias){

        this.noticias = noticias;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_noticias, parent, false );

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        File imagenFile = new File(noticias.get(position).getFoto());

        holder.titulo.setText(noticias.get(position).getTitulo());

        if(imagenFile.exists()){
            Bitmap imgBitmap = BitmapFactory.decodeFile(imagenFile.getAbsolutePath());
            holder.foto.setImageBitmap(imgBitmap);
        }

        //holder.foto.setImageResource(noticias.get(position).getFoto());

    }

    @Override
    public int getItemCount() {

        return noticias.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titulo;
        private ImageView foto;

        public ViewHolder(View itemView){
            super(itemView);

            titulo = itemView.findViewById(R.id.TituloNoticia);
            foto = itemView.findViewById(R.id.fotoNoticia);
            
        }
    }
}
