package com.aro.stailishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import API.ApiInterface;
import API.ServiceGenerator;
import Model.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Si los datos de inicio de sesión no están almacenados, el usuario aún no ha iniciado sesión.
        // En este caso, permita que el usuario ingrese sus credenciales en la actividad de inicio de sesión.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-4735587225445673/7065039908");
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        EditText etUsuario = findViewById(R.id.etUsuarioLogin);
        EditText etContrasena = findViewById(R.id.etContrasenaLogin);

        Button btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        Button btnRegister = findViewById(R.id.btnRegister); //Este es el que lleva a la pagina de registro

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);

            @Override
            public void onClick(View view) {
                String usuario = etUsuario.getText().toString();
                String contrasena = etContrasena.getText().toString();
                Call<Integer> call = apiInterface.login(usuario, contrasena);
                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        if (response.body() != -1) {
                            Toast.makeText(getApplicationContext(), "Bienvenido!", Toast.LENGTH_LONG).show();
                            //Guardar la variable de sesion de usuario
                            SharedPreferences.Editor editor = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE).edit();
                            editor.putInt(String.valueOf(Constants.KEY_ID), response.body());
                            editor.apply();
                            //Mandar los datos del usuario a la siguiente actividad para uso de base de datos
                            Bundle bundle = new Bundle();
                            bundle.putInt("idusuario", response.body());
                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Credenciales no correctas.", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        //ha fallado mostrar aviso de que es posible de que no tenga intertet
                        Log.e("tag", t.getMessage());
                    }
                });
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
