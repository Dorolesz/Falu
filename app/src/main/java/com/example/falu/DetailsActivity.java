package com.example.falu;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class DetailsActivity extends AppCompatActivity {
    private TextView textViewlakoNeve;
    private TextView textViewlakoCime;
    private TextView textViewlakoKora;
    private Button visszaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        textViewlakoNeve = findViewById(R.id.textViewLakoNeve);
        textViewlakoCime = findViewById(R.id.textViewLakoCime);
        textViewlakoKora = findViewById(R.id.textViewLakoKora);
        visszaButton = findViewById(R.id.visszaButton);

        Lako lako = (Lako) getIntent().getSerializableExtra("lako");
        textViewlakoNeve.setText(lako.getLakoNeve());
        textViewlakoCime.setText(lako.getLakoCime());
        textViewlakoKora.setText(lako.getLakoKora());


        visszaButton.setOnClickListener(v -> finish());

    }


}
