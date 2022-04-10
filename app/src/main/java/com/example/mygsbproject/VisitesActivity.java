package com.example.mygsbproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mygsbproject.databinding.ActivityVisitesBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisitesActivity extends AppCompatActivity {
    private ActivityVisitesBinding binding;
    private String _token;
    private String _idPraticien;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVisitesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        _token = intent.getStringExtra("token");
        _idPraticien = intent.getStringExtra("idPraticien");
        getPraticien(Integer.valueOf(_idPraticien));
    }
    public void getPraticien(int intPraticien) {
        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Call<Praticien> call = service.getPraticiens("Bearer " + _token, intPraticien);
        call.enqueue(new Callback<Praticien>() {

            @Override
            public void onResponse(Call<Praticien> call, Response<Praticien> response) {
                Praticien praticien = response.body();

                binding.tvNom.setText(praticien.getPra_nom());
                binding.tvPrenom.setText(praticien.getPra_prenom());
                binding.tvMail.setText(praticien.getPra_mail());
                binding.tvTel.setText(praticien.getPra_tel());
                binding.tvCodePostal.setText(praticien.getPra_code_postal());
                binding.tvVille.setText(praticien.getPra_ville());
                binding.tvRue.setText(praticien.getPra_rue());
            }

            @Override
            public void onFailure(Call<Praticien> call, Throwable t) {
                Toast.makeText(VisitesActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}