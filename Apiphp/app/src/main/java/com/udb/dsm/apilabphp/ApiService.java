package com.udb.dsm.apilabphp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("APIRESTPHP/displayAll.php")
    Call<PersonResponse> getInfo();
}
