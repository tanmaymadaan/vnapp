package com.tanmaymadaan.vn;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @POST("add-patient")
    Call<Patient> postPatient(@Body Patient patient);

}
