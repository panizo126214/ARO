package com.aro.stailishapp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import androidx.appcompat.app.AppCompatActivity;

import android.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import API.ApiInterface;
import API.ServiceGenerator;
import Model.ImageRequest;
import Model.Mensaje;
import Model.MensajeAdapter;
import Model.Pregunta;
import Model.Respuesta;
import Model.RespuestaImagen;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class PromptActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    ListView listView;
    EditText etEditPrompt;
    Button btnSendPrompt;
    TextView tvResponse;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_prompt);

        listView = findViewById(R.id.lvMensajes);
        etEditPrompt = findViewById(R.id.etEditPrompt);
        btnSendPrompt = findViewById(R.id.btnSendPrompt);

        ArrayList<Mensaje> arrayList = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        int idusuario = 0;
        if (bundle != null) {
            idusuario = bundle.getInt("idusuario");
        }

        int finalIdUsuario = idusuario;
        btnSendPrompt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prompt = etEditPrompt.getText().toString();
                ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
                Pregunta request = new Pregunta(prompt);
                Call<Respuesta> call = apiInterface.generateImageByPrompt(request);
                call.enqueue(new Callback<Respuesta>() {
                    @Override
                    public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                        Respuesta resp = response.body();
                        ArrayList<String> link_img = response.body().getOutput();
                        String img = link_img.get(0);
                        arrayList.add(new Mensaje(prompt,img));

                        MensajeAdapter mensajeAdapter = new MensajeAdapter(getApplicationContext(),R.layout.list_row,arrayList);
                        listView.setAdapter(mensajeAdapter);
                        Call<Integer> call2 = apiInterface.addImg(prompt, finalIdUsuario, img);

                        call2.enqueue(new Callback<Integer>() {
                            @Override
                            public void onResponse(Call<Integer> call, Response<Integer> response) {
                                Log.e("tag", response.message());
                                Toast.makeText(PromptActivity.this, "Cargando imagen...Espere un poco", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<Integer> call, Throwable t) {
                                //ha fallado mostrar aviso de que es posible de que no tenga intertet
                                Log.e("tag", t.getMessage());
                                Toast.makeText(PromptActivity.this, "Cargando imagen...Si no carga vuelva a enviar", Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<Respuesta> call, Throwable t) {
                        //ha fallado mostrar aviso de que es posible de que no tenga intertet
                        Log.e("tag", t.getMessage());
                        Toast.makeText(PromptActivity.this, "Ha fallado la conexión, intentelo de nuevo", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}