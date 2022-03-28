package com.example.mygsbproject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Visiteur {
    @SerializedName("id")
    private Integer id;
    @SerializedName("email")
    private String email;
    @SerializedName("roles")
    private String roles;
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

    public Visiteur(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRoles() {
        return roles;
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
}
