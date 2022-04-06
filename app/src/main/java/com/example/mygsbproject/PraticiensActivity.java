package com.example.mygsbproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PraticiensActivity extends AppCompatActivity {
    private String token;
    private String mail;
    private Visiteur levisiteur;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praticiens);
        Bundle bundle = getIntent().getExtras();
        token = bundle.getString("token");
        mail = bundle.getString("TextEmail");


//        Toast.makeText(PraticiensActivity.this, mail, Toast.LENGTH_SHORT ).show();
//        Toast.makeText(PraticiensActivity.this, token, Toast.LENGTH_SHORT ).show();


        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Call<Visiteurs> call = service.getAllVisiteurs("Bearer " + token);
        call.enqueue(new Callback<Visiteurs>() {
            @Override
            public void onResponse(Call<Visiteurs> call, Response<Visiteurs> response) {
                Visiteurs visiteurs = response.body();
                for (Visiteur visiteur : visiteurs.getVisiteurs()){
                    if(visiteur.getEmail().equals(mail))
                    {
                        levisiteur = visiteur;
                        levisiteur.initListPraticiens();
                        TextView tvmail = findViewById(R.id.TextEmail);
                        tvmail.setText(visiteur.getUsername());
                        TextView tvnom = findViewById(R.id.Nom);
                        tvnom.setText(visiteur.getVis_nom());
                        TextView tvprenom = findViewById(R.id.Prenom);
                        tvprenom.setText(visiteur.getVis_prenom());
                        TextView tvtel = findViewById(R.id.Tel);
                        tvtel.setText(visiteur.getVis_tel());



                        for(String unPraticien : levisiteur.getListpraticiens()){
                            unPraticien = unPraticien.substring(16);
                            int lePraticien = Integer.parseInt(unPraticien);
                            GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
                            Call<Praticien> call1 = service.getPraticiens("Bearer " + token, lePraticien);
                            call1.enqueue(new Callback<Praticien>() {
                                @Override
                                public void onResponse(Call<Praticien> call1, Response<Praticien> response) {
                                    Praticien praticien = response.body();
                                    levisiteur.addPraticiens(praticien);
                                    recyclerView = findViewById(R.id.praticien);
                                    recyclerView.setHasFixedSize(true);
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                                    recyclerView.setLayoutManager(layoutManager);
                                    recyclerView.setFocusable(false);

                                    RecyclerViewAdapter adapter  = new RecyclerViewAdapter(levisiteur.getLespraticiens());
                                    recyclerView.setAdapter(adapter);

                                }

                                @Override
                                public void onFailure(Call<Praticien> call1, Throwable t) {

                                }
                            });
                        }



                    }
                }
            }

            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {
                Toast.makeText(PraticiensActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

//        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecylcerviewClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                Toast.makeText(PraticiensActivity.this, )
//            }
//        }));
    }
}


