package com.example.falu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LakokListaAdapter extends BaseAdapter {
    private Context context;
    private List<Lako> lakokLista;
    private LayoutInflater inflater;

    public LakokListaAdapter(Context context, List<Lako> lakokLista){
        this.context = context;
        this.lakokLista = lakokLista;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lakokLista.size();
    }

    @Override
    public Object getItem(int position) {
        return lakokLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.lako_item, parent, false);
        }

        TextView textViewlakoNeve = convertView.findViewById(R.id.lakoNeve);
        TextView textViewlakoCime = convertView.findViewById(R.id.lakoCime);
        TextView textViewlakoKora = convertView.findViewById(R.id.lakoKora);

        Lako lako = lakokLista.get(position);

        textViewlakoNeve.setText(lako.getLakoNeve());
        textViewlakoCime.setText(lako.getLakoCime());
        textViewlakoKora.setText(String.valueOf(lako.getLakoKora()));

        return convertView;
    }
}
