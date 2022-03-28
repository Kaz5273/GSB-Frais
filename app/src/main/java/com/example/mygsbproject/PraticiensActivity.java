package com.example.mygsbproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mygsbproject.databinding.ActivityPraticiensBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PraticiensActivity extends AppCompatActivity {
    private String token;
    private String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praticiens);
        Bundle bundle = getIntent().getExtras();

/*        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Call<Token> call = service.getAllVisiteurs(new Visiteur());*/


        token = bundle.getString("token");
        mail = bundle.getString("TextEmail");
        Toast.makeText(PraticiensActivity.this, mail, Toast.LENGTH_SHORT ).show();
        Toast.makeText(PraticiensActivity.this, token, Toast.LENGTH_SHORT ).show();



    }
}


