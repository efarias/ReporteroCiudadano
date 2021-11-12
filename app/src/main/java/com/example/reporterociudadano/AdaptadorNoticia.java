package com.example.reporterociudadano;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        int p = position;
        Noticia noticia = new Noticia(noticias.get(p).getTitulo(),noticias.get(p).getNota(),noticias.get(p).getFoto(),noticias.get(p).getFecha(),noticias.get(p).getUbicacion(),noticias.get(p).getUsuario());

        holder.titulo.setText(noticias.get(position).getTitulo());
        holder.fecha.setText(noticias.get(position).getFecha());
        holder.mostrarNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MostrarNoticia.class);
                intent.putExtra("noticia", noticia);
                view.getContext().startActivity(intent);

            }
        });

        File imagenFile = new File(noticias.get(position).getFoto());
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
        private TextView fecha;
        private ImageView foto;
        private Button mostrarNoticia;

        public ViewHolder(View itemView){
            super(itemView);

            titulo = itemView.findViewById(R.id.TituloNoticia);
            foto = itemView.findViewById(R.id.fotoNoticia);
            fecha = itemView.findViewById(R.id.tvFecha);
            mostrarNoticia = itemView.findViewById(R.id.btnVerNoticias);
            
        }
    }
}
