/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.models.CalendarRequest;
import com.models.CalendarResponse;
import com.models.DeleteCalendar;
import com.models.DeleteResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author Brenton
 */
public class Calendars extends Concept {
    public static final MediaType JSON
        = MediaType.parse("application/json; charset=utf-8");
    public Calendars(StanzaClient client){
        super(client);
    }
    public CalendarResponse getCalendar(String shortName){
        HttpUrl.Builder url = new HttpUrl.Builder();
        url.scheme("https")
                .host("www.stanza.co")
                .addEncodedPathSegment("/api/developer/")
                .addEncodedPathSegment("retrieve_calendar")
                .addEncodedQueryParameter("calendarShortname", shortName);
        
        Request.Builder request = client.getRequestBuilder()
                .get()
                .url(url.build());
        Response Stanza = client.executeRequest(request.build());
            CalendarResponse calResponse = new CalendarResponse();
        try {
            calResponse = mapper.readValue(Stanza.body().string(), mapper.getTypeFactory().constructType(CalendarResponse.class));
        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(Calendars.class.getName()).log(Level.SEVERE, null, e);
        }
        return calResponse;
    }
    
    public CalendarResponse createCalendar(CalendarRequest cal){
 
        try {
            Request.Builder request = client.getRequestBuilder()
                    .post(RequestBody.create(JSON, mapper.writeValueAsString(cal)))
                    .url("https://www.stanza.co/api/developer/create_calendar");
            Response calResponse = client.executeRequest(request.build());
            
            return mapper.readValue(calResponse.body().string(), mapper.getTypeFactory().constructType(CalendarResponse.class));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Calendars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Calendars.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public DeleteResponse deleteCalendar(DeleteCalendar shortName){
        
        HttpUrl.Builder url = new HttpUrl.Builder();
        url.scheme("https")
                .host("www.stanza.co")
                .addEncodedPathSegment("/api/developer/")
                .addEncodedPathSegment("delete_calendar")
                .addEncodedPathSegment(shortName.getShortname());
        try {
            Request.Builder request = client.getRequestBuilder()
                    .delete(RequestBody.create(JSON, mapper.writeValueAsString(shortName)))
                    .url(url.build());
            Response delResponse = client.executeRequest(request.build());
            
            return mapper.readValue(delResponse.body().string(), mapper.getTypeFactory().constructType(DeleteResponse.class));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Calendars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Calendars.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
