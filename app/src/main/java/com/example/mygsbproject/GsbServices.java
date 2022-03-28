package com.example.mygsbproject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface GsbServices {
    @GET("visiteurs")
    Call<Visiteurs> getAllVisiteurs(@Header("Authorization") String authorization);
    @POST("login_check")
    Call<Token> getToken(@Body Visiteur visiteur);
    @GET("praticiens")
    Call<Praticiens> getAllPraticiens(@Header("Authorization") String authorization);

}
