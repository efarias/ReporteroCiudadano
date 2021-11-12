package com.example.reporterociudadano;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.pm.ShortcutInfoCompatSaver;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String[] permisos = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private boolean hayPermiso;
    private ArrayList<Noticia> noticias;
    private int cantidad;
    private ImageView fotoPrincipal;
    private ArrayList<Usuario> usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hayPermiso = false;
        fotoPrincipal = findViewById(R.id.imagenPrincipal);
        noticias = (ArrayList<Noticia>) getIntent().getSerializableExtra("noticias");
        usuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("usuarios");

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            requestPermissions(permisos, 100);
        }
    }
    private void comprobarPermisos(){

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permisos OK", Toast.LENGTH_SHORT).show();
                hayPermiso = true;
            }else {
                solicitarPermisos();
            }
        }
    }

    private void solicitarPermisos(){
        new AlertDialog.Builder(this)
                .setTitle("Se requiere permisos de cámara y de escritura")
                .setMessage("Esta aplicación hace uso de la cámara para tomar una foto. Por favor " +
                        "otorgue este permiso para que la aplicación funcione correctamente")
                .setPositiveButton("Ver Permiso", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        requestPermissions(permisos, 100);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create().show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                hayPermiso = true;
            } else {
                Toast.makeText(this, "Se requiere permisos de cámara para funcionar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void crearNoticia (View view){
        comprobarPermisos();
        if (hayPermiso){
            Intent intento = new Intent(this, ActivityCrearNoticia.class);
            intento.putExtra("noticias", noticias);
            intento.putExtra("usuarios", usuarios);
            startActivity(intento);

        }
    }

    public void ListadoDeNoticias(View view){

        Intent intento = new Intent(this, ActivityListaDeNoticias.class);
        intento.putExtra("noticias",noticias);
        startActivity(intento);
    }


    public void CerrarSesion(View view) {
        Intent intento = new Intent(this, ActivityPrincipal.class);
        intento.putExtra("noticias",noticias);
        intento.putExtra("usuarios", usuarios);
        startActivity(intento);
    }
}
