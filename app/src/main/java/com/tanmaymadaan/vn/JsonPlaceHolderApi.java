package com.tanmaymadaan.vn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface JsonPlaceHolderApi {

    @POST("add-patient")
    Call<Patient> postPatient(@Body Patient patient);

    @GET("get-counter")
    Call<List<Counter>> getCounter();

    @PUT("update-counter")
    Call<Counter> updateCounter();

}
