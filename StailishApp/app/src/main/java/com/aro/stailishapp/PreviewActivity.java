package com.aro.stailishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        ImageView camiseta = findViewById(R.id.ivCamiseta);
        ImageView prompt = findViewById(R.id.ivPrompt);

        camiseta.setImageResource(R.drawable.camiseta_negra);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String url = bundle.getString("imagenUrl");
        Picasso.with(this)
                .load(url)
                .resize(100, 100)
                .into(prompt);
    }
}