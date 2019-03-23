package com.cursoandroid.raone.retrofit2;

import com.cursoandroid.raone.retrofit2.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceService {

    @GET("/")
    Call<String> racine();

    @GET("maps/api/geocode/json")
    Call<Results> geocoding(@Query(value="address", encoded = true)String valeur);
}
