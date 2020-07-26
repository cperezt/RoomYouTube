package com.example.roomyoutube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etUsuario, etPassword, etConsulta;
    Button btnGuardar, btmMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.etNombre);
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        etConsulta = findViewById(R.id.etConsulta);
        btmMostrar = findViewById(R.id.btnMostrar);
        btnGuardar = findViewById(R.id.btnGuardar);



        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataBase db = Room.databaseBuilder(MainActivity.this,
                        AppDataBase.class, "BaseDeDatosI").allowMainThreadQueries().build();
                Usuarios usuarios = new Usuarios(etNombre.getText().toString(), etUsuario.getText().toString(), etPassword.getText().toString());
                Long reg = db.usuariosDao().insert(usuarios);
                Toast.makeText(getApplicationContext(),"reg",Toast.LENGTH_LONG).show();
            }
        });

        btmMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataBase db = Room.databaseBuilder(MainActivity.this,
                        AppDataBase.class, "BaseDeDatosI").allowMainThreadQueries().build();
                List<Usuarios> lista = db.usuariosDao().getAll();
                String  valores = "";

                for(int i = 0; i<lista.size();i++){

                    valores+=""+lista.get(i).getId()+": "+lista.get(i).nombreUsuario+" usuario: "+lista.get(i).usuario+" pass: "+lista.get(i).password+"\n";

                }

                etConsulta.setText(valores);

            }
        });

    }

}