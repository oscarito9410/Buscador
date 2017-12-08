package com.oscar.buscador.API;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by oemy9 on 03/12/2017.
 */

public class GeneratorClientRest {

    private String urlBase;  //http://version1.api.memegenerator.net/

    private AsyncHttpClient client=new AsyncHttpClient();

    public GeneratorClientRest(String urlBase) {
        this.urlBase = urlBase;
    }

    public void get(String endPoint, RequestParams params,
                    AsyncHttpResponseHandler handler)
    {
        client.get(urlBase+endPoint,params,handler);
    }




}
