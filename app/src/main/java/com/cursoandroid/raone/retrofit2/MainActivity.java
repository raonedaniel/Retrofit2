package com.cursoandroid.raone.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.cursoandroid.raone.retrofit2.model.Results;

import java.io.IOException;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ServiceService service = RetrofitUtil.get();

        service.geocoding("london").enqueue(new Callback<Results>() {
            @Override
            public void onRensponse(Call<Results> call, Response<Results> response) {
                if (response.isSuccessful()){
                    Results results = response.body();
                    Toast.makeText(getApplicationContext(),response.body().status,Toast.LENGTH_SHORT).show();
                    Long.i("Retrofit2", results.toString());
                    for (Result r : results.results);
                    Long.i("Retrofit2", r.formatted_address());
                }
                else{
                    Long.i("Retrofit2", "code d'erruer est" + response.code());
                }

            }

            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {

            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

            }
        };

    }
}

