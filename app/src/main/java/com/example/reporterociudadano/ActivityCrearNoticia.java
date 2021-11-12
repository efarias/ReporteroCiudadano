package com.example.reporterociudadano;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ActivityCrearNoticia extends AppCompatActivity {


    private ImageView foto;
    private EditText titulo;
    private EditText nota;
    private boolean fotoTomada;
    private ArrayList<Noticia> noticias;
    private String rutaImagen;
    private ArrayList<Usuario> usuarios;
    private EditText fecha;
    private String ubicacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_noticia);

        foto = findViewById(R.id.MostrarFotoNoticia);
        titulo = findViewById(R.id.tituloNoticia);
        nota = findViewById(R.id.textoNoticia);
        fecha = findViewById(R.id.tdFecha);
        fotoTomada = false;
        noticias = (ArrayList<Noticia>) getIntent().getSerializableExtra("noticias");
        usuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("usuarios");

        // Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] valores = {"Arica","Iquique","Antofagasta", "Santiago"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                ubicacion = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio

            }


    });
    }

    public void tomarFoto(View view) {

        Intent intento = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File imagenArchivo = null;

        try{
            imagenArchivo = crearImagen();

        }catch(IOException ex){
            Log.e("Error", ex.toString());
        }

        if(imagenArchivo != null){
            Uri fotoUri = FileProvider.getUriForFile(this, "com.example.reporterociudadano.fileprovider", imagenArchivo);
            intento.putExtra(MediaStore.EXTRA_OUTPUT,fotoUri);
            startActivityForResult(intento, 0);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

           // Bitmap b = (Bitmap) data.getExtras().get("data");
            Bitmap b = BitmapFactory.decodeFile(rutaImagen);
            fotoTomada = true;
            foto.setImageBitmap(b);
        }
    }

    public void guardarNoticia(View view) {

        if (fotoTomada && titulo.getText().length() != 0 && nota.getText().length() != 0) {

            Noticia n = new Noticia (titulo.getText().toString(),nota.getText().toString(),rutaImagen,fecha.getText().toString(),ubicacion,usuarios.get(0));
            noticias.add(n);
            titulo.setText("");
            nota.setText("");
            //foto.setImageBitmap(null);
            int cantidad = noticias.size();
            Toast.makeText(this, "hay " + cantidad + " noticias", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Noticia Guardada", Toast.LENGTH_SHORT).show();

            //pruebas
            System.out.println(ubicacion);
//            String t = noticias.get(titulo.getVerticalScrollbarPosition()).getTitulo();
//            Toast.makeText(this, t, Toast.LENGTH_SHORT).show();
//            String p = noticias.get(nota.getVerticalScrollbarPosition()).getNota();
//            Toast.makeText(this, p, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this,rutaImagen,Toast.LENGTH_SHORT).show();

            fotoTomada = false;
            Intent intento = new Intent(this, MainActivity.class);
            intento.putExtra("noticias", noticias);
            intento.putExtra("usuarios", usuarios);
            startActivity(intento);
        } else {
            Toast.makeText(this, "error, faltan datos por ingresar", Toast.LENGTH_SHORT).show();
        }

    }

    private File crearImagen() throws IOException {
        String nombreImagen = "foto_";
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen = File.createTempFile(nombreImagen, ".jpg", directorio);

        rutaImagen = imagen.getAbsolutePath();
        return imagen;
    }

    public void AbrirMapa(View view) {
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);

    }
}