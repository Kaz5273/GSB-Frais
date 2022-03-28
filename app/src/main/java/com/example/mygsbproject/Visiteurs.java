package com.example.mygsbproject;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Visiteurs implements Serializable {
    @SerializedName("visiteurs") //notation retrofit2
    private List<Visiteurs> visiteurs;

    public Visiteurs(List<Visiteurs> visiteurs) {
        this.visiteurs = visiteurs;
    }



}

