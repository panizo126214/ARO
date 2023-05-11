package com.aro.stailishapp;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import Model.Constants;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageView ivDesign = findViewById(R.id.ivDesign);
        ImageView ivGallery = findViewById(R.id.ivGallery);
        ImageView ivLogout = findViewById(R.id.ivLogout);

        ivDesign.setImageResource(R.drawable.icon_prompt);
        ivGallery.setImageResource(R.drawable.icon_gallery);
        ivLogout.setImageResource(R.drawable.logouticon);

        ivDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                int idusuario = 0;
                if (bundle != null) {
                    Intent intent = new Intent(MenuActivity.this, PromptActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(MenuActivity.this, "Algo ha fallado al mandar el bundle", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ivGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });

        ivLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences(Constants.MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putInt(String.valueOf(Constants.KEY_ID), 0);
                editor.apply();
                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}