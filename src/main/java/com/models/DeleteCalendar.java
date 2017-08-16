/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Brenton
 */
public class DeleteCalendar {
    @JsonProperty("calendarShortname")
    String Shortname;
    private Map<String,String> headers;
    private String method;
    public DeleteCalendar(String APIkey){
       method = "DELETE";
       headers = new HashMap<String,String>();
       headers.put("Authorization", "Stanza "+APIkey);
   }  

    public void setShortname(String Shortname) {
        this.Shortname = Shortname;
    }

    public String getShortname() {
        return Shortname;
    }
}
