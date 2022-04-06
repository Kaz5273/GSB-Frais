package com.example.mygsbproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
private Button btnConnexion;
private EditText TextEmail;
private EditText TextPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConnexion = findViewById(R.id.btnConnexion);
        TextEmail = findViewById(R.id.TextEmail);
        TextPassword = findViewById(R.id.TextPassword);
        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
                Call<Token> call = service.getToken(new Visiteur(TextEmail.getText().toString(), TextPassword.getText().toString()));


                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        if (response.code() == 200){
                            Token token = response.body();
                            Intent intent = new Intent(getApplicationContext(), PraticiensActivity.class);
                            intent.putExtra("token", token.getToken());
                            intent.putExtra("TextEmail", TextEmail.getText().toString());
                            startActivity(intent);
                           /* TextView textViewTest = findViewById(R.id.textViewTest);
                            textViewTest.setText(token.getToken());
                            Log.v("token", token.getToken());*/

                        }
                        else if (response.code() == 401){
                            Toast.makeText(MainActivity.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
