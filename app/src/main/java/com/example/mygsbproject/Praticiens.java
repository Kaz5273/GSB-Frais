package com.example.mygsbproject;

import com.google.gson.annotations.SerializedName;

public class Praticiens {
    @SerializedName("id")
    private Integer id;
    @SerializedName("pra_nom")
    private String pra_nom;
    @SerializedName("pra_prenom")
    private String pra_prenom;
    @SerializedName("pra_tel")
    private String pra_tel;
    @SerializedName("pra_mail")
    private String pra_mail;
    @SerializedName("pra_rue")
    private String pra_rue;
    @SerializedName("pra_code_postal")
    private String pra_code_postal;
    @SerializedName("pra_ville")
    private String pra_ville;
    @SerializedName("pra_coef_notoriete")
    private String pra_coef_notoriete;
}
