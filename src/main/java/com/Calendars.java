/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import com.models.CalendarResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author Brenton
 */
public class Calendars extends Concept {
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
    
}
