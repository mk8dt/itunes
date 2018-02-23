package com.quadran.itunes.data;

import retrofit2.Call;
import retrofit2.Callback;
import com.quadran.itunes.domain.model.Response;

/**
 * Created by mario on 27/11/2017.
 */

public class Calls {

    public static void getTopPaid(Callback<Response> callback){

        Call<Response> call = Connection.getRetrofitInstance()
                .create(Services.class)
                .getPaidApps();

        call.enqueue(callback);
    }

}
