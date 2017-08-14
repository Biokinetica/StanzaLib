/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author Brenton
 */


public class StanzaClient {
    private Request.Builder requestBuilder;
    private String Key;
    private ObjectMapper mapper;
    private OkHttpClient httpClient;
  public StanzaClient(String APIKey){
      Key = APIKey;
      httpClient = new OkHttpClient();
      mapper = new ObjectMapper();
  }
  
  public Request.Builder getRequestBuilder() {
      requestBuilder = new Request.Builder();
      requestBuilder.addHeader("Authorization", "Stanza " + Key);
        return requestBuilder;
    }
  public Response executeRequest(Request request){
      try {
            return this.httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
      return null;
  }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public OkHttpClient getHttpClient() {
        return httpClient;
    }
}
