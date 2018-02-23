package com.quadran.itunes.data;

import com.quadran.itunes.domain.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mario on 27/11/2017.
 */

public interface Services {

    String URL_PAID = "toppaidapplications/limit=10/json";

    @GET(URL_PAID)
    Call<Response> getPaidApps();

}
