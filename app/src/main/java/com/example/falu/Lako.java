package com.example.falu;

import java.io.Serializable;

public class Lako implements Serializable {
    private String lakoNeve;
    private String lakoCime;
    private int lakoKora;

    public Lako(String lakoNeve, String lakoCime, int lakoKora) {
        this.lakoNeve = lakoNeve;
        this.lakoCime = lakoCime;
        this.lakoKora = lakoKora;
    }

    public String getLakoNeve() {
        return lakoNeve;
    }

    public void setLakoNeve(String lakoNeve) {
        this.lakoNeve = lakoNeve;
    }

    public String getLakoCime() {
        return lakoCime;
    }

    public void setLakoCime(String lakoCime) {
        this.lakoCime = lakoCime;
    }

    public int getLakoKora() {
        return lakoKora;
    }

    public void setLakoKora(int lakoKora) {
        this.lakoKora = lakoKora;
    }

}
