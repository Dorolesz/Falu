package com.example.falu;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextLakoNeve;
    private EditText editTextLakoCime;
    private EditText editTextLakoKora;
    private Button hozzaadButton;
    private ListView lakokListaView;
    private List<Lako> lakokLista;
    private LakokListaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();

        hozzaadButton.setOnClickListener(v -> {
            String lakoNeve = editTextLakoNeve.getText().toString();
            String lakoCime = editTextLakoCime.getText().toString();
            String lakoKora = editTextLakoKora.getText().toString();

            if (lakoNeve.isEmpty() || lakoCime.isEmpty() || lakoKora.isEmpty()) {
                Toast.makeText(MainActivity.this, "Minden mezőt ki kell tölteni!", Toast.LENGTH_SHORT).show();
                return;
            }

            int kor = Integer.parseInt(lakoKora);

            Lako lako = new Lako(lakoNeve, lakoCime, kor);
            lakokLista.add(lako);
            adapter.notifyDataSetChanged();

            editTextLakoNeve.setText("");
            editTextLakoCime.setText("");
            editTextLakoKora.setText("");
        });

        lakokListaView.setOnItemClickListener((parent, view, position, id) -> {
            Lako lako = lakokLista.get(position);
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("lako", lako);
            startActivity(intent);
            });
    }

    public void init() {
        editTextLakoNeve = findViewById(R.id.editTextLakoNeve);
        editTextLakoCime = findViewById(R.id.editTextLakoCime);
        editTextLakoKora = findViewById(R.id.editTextLakoKora);
        hozzaadButton = findViewById(R.id.hozzaadButton);
        lakokListaView = findViewById(R.id.lakokListaView);

        lakokLista = new ArrayList<>();
        adapter = new LakokListaAdapter(this, lakokLista);
        lakokListaView.setAdapter(adapter);
    }
}