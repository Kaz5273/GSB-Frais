package com.example.mygsbproject;

import com.google.gson.annotations.SerializedName;

public class Visites {
    @SerializedName("id")
    private Integer id;
    @SerializedName("vst_praticiens_id_id")
    private String vst_praticiens_id_id;
    @SerializedName("vst_visiteur_id_id")
    private String vst_visiteur_id_id;
    @SerializedName("vst_motif_id_id")
    private String vst_motif_id_id;
    @SerializedName("vst_date")
    private String vst_date;
    @SerializedName("vst_commentaire")
    private String vst_commentaire;
}
