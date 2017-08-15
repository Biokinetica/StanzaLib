/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.models.CalendarRequest;
import com.models.CalendarResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author Brenton
 */
public class Calendars extends Concept {
    public static final MediaType URL
        = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    public Calendars(StanzaClient client){
        super(client);
    }
    public CalendarResponse getCalendar(String shortName){
        Request.Builder request = client.getRequestBuilder()
                .get()
                .url("https://www.stanza.co/api/developer/retrieve_calendar")
                .addHeader("calendarShortnam", shortName);
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
                    .post(RequestBody.create(URL, mapper.writeValueAsString(cal)))
                    .url("https://www.stanza.co/api/developer/retrieve_calendar");
            Response calResponse = client.executeRequest(request.build());
            
            return mapper.readValue(calResponse.toString(), CalendarResponse.class);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Calendars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Calendars.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
