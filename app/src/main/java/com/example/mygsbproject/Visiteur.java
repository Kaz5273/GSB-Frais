package com.example.mygsbproject;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Visiteur implements Serializable {
    @SerializedName("id")
    private Integer id;
    @SerializedName("email")
    private String email;
    @SerializedName("vis_nom")
    private String vis_nom;
    @SerializedName("vis_prenom")
    private String vis_prenom;
    @SerializedName("vis_tel")
    private String vis_tel;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("vis_Praticiens")
    private List<String> listpraticiens;
    private ArrayList<Praticien>lespraticiens;

    public Visiteur(String username, String password) {
        this.username = username;
        this.password = password;
        this.email = username;
        this.initListPraticiens();
    }

    public void initListPraticiens(){
        lespraticiens = new ArrayList<Praticien>();
    }
    public void addPraticiens(Praticien lePraticien){
        lespraticiens.add(lePraticien);
    }


    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getVis_nom() {
        return vis_nom;
    }

    public String getVis_prenom() {
        return vis_prenom;
    }

    public String getVis_tel() {
        return vis_tel;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getListpraticiens() {
        return listpraticiens;
    }

    public ArrayList<Praticien> getLespraticiens() {
        return lespraticiens;
    }
}
