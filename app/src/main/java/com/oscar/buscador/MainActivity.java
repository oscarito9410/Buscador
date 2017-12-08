package com.oscar.buscador;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.oscar.buscador.API.Constants;
import com.oscar.buscador.API.GeneratorClientRest;
import com.oscar.buscador.API.Model.MemeResult;
import com.oscar.buscador.API.Model.Result;
import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;

import com.oscar.buscador.Adapters.AdapterImgMeme;
import com.oscar.buscador.Adapters.ItemClickListener;
import com.oscar.buscador.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SearchView searchMeme;
    private ProgressBar pgCarga;
    private RecyclerView recyclerMeme;
    private AdapterImgMeme adpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchMeme=(SearchView)findViewById(R.id.searchMeme);
        pgCarga=(ProgressBar)findViewById(R.id.pgCarga);
        pgCarga.setVisibility(View.GONE);
        recyclerMeme=(RecyclerView)findViewById(R.id.recyclerMeme);
        searchMeme.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                if(query.length()>=3){
                    search(query);
                }
                return false;
            }
        });

    }
    private void setAdapter(ArrayList<Result>listMeme){
        recyclerMeme.setVisibility(View.VISIBLE);
        adpt=new AdapterImgMeme(listMeme,this);
        adpt.setListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position, Object objt) {
                Result r=(Result)objt;
                Toast.makeText(MainActivity.this, r.getDisplayName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        recyclerMeme.setLayoutManager(new GridLayoutManager(this,2));
        recyclerMeme.setAdapter(adpt);
    }

    private void search(String query){

        GeneratorClientRest clientRest=new GeneratorClientRest(Constants.URL_BASE);
        //PARAMETROS DE ENVÍO AL SERVICIO REST
        RequestParams params=new RequestParams();
        params.put("q",query);
        params.put("pageIndex",0);
        params.put("pageSize",25);
        params.put("apiKey",Constants.API_KEY);

        clientRest.get(Constants.ENDPOINT_SEARCH,params,new JsonHttpResponseHandler(){

            @Override
            public void onStart() {
                super.onStart();
                pgCarga.setVisibility(View.VISIBLE);
                recyclerMeme.setVisibility(View.GONE);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Gson gson=new Gson();
                MemeResult result=gson.fromJson(response.toString(),
                                                MemeResult.class);
                setAdapter((ArrayList)result.getListMemes());
                pgCarga.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Toast.makeText(MainActivity.this,throwable.getMessage(), Toast.LENGTH_SHORT).show();
                pgCarga.setVisibility(View.GONE);
            }

        });







    }



}
