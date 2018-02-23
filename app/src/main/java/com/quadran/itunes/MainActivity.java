package com.quadran.itunes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.quadran.itunes.data.Calls;
import java.util.logging.Level;
import retrofit2.Call;
import retrofit2.Callback;
import com.quadran.itunes.domain.model.Response;

public class MainActivity extends AppCompatActivity implements Callback<com.quadran.itunes.domain.model.Response>{

    private RecyclerView recyclerView;

    //Ciclo de vida de la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getApps();
    }

    //Con este metodo inicializamos la UI (interfaz de usuario)
    private  void initUi(){
        recyclerView = findViewById(R.id.recylerApps);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

    }
    //WEB SERVICE
    public void getApps(){
        Calls.getTopPaid(this);
    }

    @Override
    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
        Log.d("QUADRAM","YUHUUUU HE LLEGADOOO !!!");
        recyclerView.setAdapter(new AdapterPaidApps(response.body().getFeed().getEntry(),this));
    }

    @Override
    public void onFailure(Call<Response> call, Throwable t) {
        Log.d("QUADRAM","ALGO HA FALLADO");
    }
}
