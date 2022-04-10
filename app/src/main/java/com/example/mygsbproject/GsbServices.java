package com.example.mygsbproject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GsbServices {
    @GET("/api/visiteurs")
    Call<Visiteurs> getAllVisiteurs(@Header("Authorization") String authorization);

    @POST("/api/visiteurs")
    Call<Visiteur> createVisiteur(@Body Visiteur visiteur);

    @POST("/api/login_check")
    Call<Token> getToken(@Body Visiteur visiteur);

    @GET("/api/praticiens")
    Call<Praticien> getAllPraticiens(@Header("Authorization") String authorization);

    @GET("/api/praticiens/{id}")
    Call<Praticien> getPraticiens(@Header("Authorization") String authorization, @Path("id") int id);

}
