package com.example.reporterociudadano;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityRegistrarse extends AppCompatActivity {

    private EditText nombreUsuario;
    private EditText contrasennaUsuario1;
    private EditText contrasennaUsuario2;
    private ArrayList<Usuario> usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        nombreUsuario = findViewById(R.id.nombreUsuarioRegistro);
        contrasennaUsuario1 = findViewById(R.id.contraseñaUsuarioRegistro);
        contrasennaUsuario2 = findViewById(R.id.contraseñaUsuarioRegistro2);
        usuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("usuarios");
        System.out.println(usuarios.size());


    }


    public void GuardarRegistroUsuario(View view) {

        boolean usuarioExiste = false;

        if (nombreUsuario.getText().length() > 0 ){
            //String user = contrasennaUsuario1.getText().toString();
            //AQUÍ HAY QUE TRATAR DE HACER LA COMPARACION DE CONTRASEÑA1 Y CONTRASEÑA2 NO ME RESULTA Y DEBO DORMIR XD
            for (int i =0; i < usuarios.size(); i++) {
                System.out.println("nombre usuario array:" + usuarios.get(i).getNombreUsuario());
                System.out.println("nombre usuairo nuevo:" + nombreUsuario.getText().toString());
                if (usuarios.get(i).getNombreUsuario().equals(nombreUsuario.getText().toString())) {
                    System.out.println("usuario dentro del IF:" + usuarios.get(i).getNombreUsuario());

                    usuarioExiste = true;
                    break;
                }
            }
                if (usuarioExiste == true) {
                    Toast.makeText(this, "Usuario ya existe", Toast.LENGTH_SHORT).show();
                }else {

                    if(contrasennaUsuario2.getText().toString().equals(contrasennaUsuario1.getText().toString())){
                        try {
                            Usuario u = new Usuario(nombreUsuario.getText().toString(), contrasennaUsuario1.getText().toString());
                            usuarios.add(u);
                            Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                        } catch (Exception e){
                            Toast.makeText(this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                            System.out.println(e.getMessage().toString());
                        }

                        // Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                        Intent intento = new Intent(this, ActivityPrincipal.class);
                        intento.putExtra("usuarios",usuarios);
                        startActivity(intento);
                    }else{
                        Toast.makeText(this, "Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }

        }else {
            Toast.makeText(this, "Ingrese nombre de Usuario", Toast.LENGTH_SHORT).show();
        }
    }
}