package com.aro.stailishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import Model.Constants;

public class PresentationActivity extends AppCompatActivity {
    private ImageButton ib_flecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        ib_flecha = findViewById(R.id.flecha);
        ib_flecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener una instancia de SharedPreferences
                SharedPreferences prefs = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE);
                // Obtener el valor almacenado en la sesión y si no hay por defecto asignar el 0
                int idusuario = prefs.getInt(String.valueOf(Constants.KEY_ID), 0);
                // Verificar si los datos de inicio de sesión ya están almacenados
                if (idusuario != 0) {
                    // Si los datos de inicio de sesión están almacenados, el usuario ya inició sesión anteriormente.
                    // En este caso, puedes iniciar la actividad siguiente en lugar de la actividad de inicio de sesión.
                    //Mandar los datos del usuario a la siguiente actividad para uso de base de datos
                    Bundle bundle = new Bundle();
                    bundle.putInt("idusuario", idusuario);
                    Intent intent = new Intent(PresentationActivity.this, MenuActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}