package com.aro.stailishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import API.ApiInterface;
import API.ServiceGenerator;
import Model.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText etNombre = findViewById(R.id.etNameRegistro);
        EditText etUsuario = findViewById(R.id.etUsuarioRegistro);
        EditText etEmail = findViewById(R.id.etEmailRegistro);
        EditText etPassword = findViewById(R.id.editTextTextPassword);



        Button btnReg = findViewById(R.id.btnRegistro);
        btnReg.setOnClickListener(new View.OnClickListener() {
            ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
            @Override
            public void onClick(View view) {
                String nombre, usuario, email, password;
                nombre = etNombre.getText().toString();
                usuario = etUsuario.getText().toString();
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();
                Call<Integer> call = apiInterface.registro(nombre, usuario, email, password);
                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Te has registrado correctamente!",Toast.LENGTH_LONG);
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "El usuario o contraseña no son correctos",Toast.LENGTH_LONG);
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
    }
}