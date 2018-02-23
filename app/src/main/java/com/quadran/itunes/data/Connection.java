package com.quadran.itunes.data;

/**
 * Created by mario on 27/11/2017.
 */

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Esta clase decuelve una instacia de retrofit para poder hacer conexiones
 */
public class Connection {
    private static Retrofit retrofit;
    private final static String URL = "https://itunes.apple.com/es/rss/";

    //Patron singleton
    public static Retrofit getRetrofitInstance(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getClient())

                    .build();
        }
        return retrofit;
    }

    static OkHttpClient getClient(){

        HttpLoggingInterceptor interceptorBasic = new HttpLoggingInterceptor();
        interceptorBasic.setLevel(HttpLoggingInterceptor.Level.BASIC);

        HttpLoggingInterceptor interceptorHeaders = new HttpLoggingInterceptor();
        interceptorHeaders.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        HttpLoggingInterceptor interceptorBody = new HttpLoggingInterceptor();
        interceptorBody.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptorBasic)
                .addInterceptor(interceptorHeaders)
                .addInterceptor(interceptorBody)
                .build();
        return client;
    }

}
