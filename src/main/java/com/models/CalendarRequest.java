/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 *
 * @author Brenton
 */
public class CalendarRequest {
    private Map<String,String> data;
    private Map<String,String> headers;
    @JsonProperty("calendarShortname")
    String Shortname;
    @JsonProperty("name")
    private String FullName;
    private String background;
    private String image;
    private String method;
    private String error;
   
   public CalendarRequest(String APIkey){
       method = "POST";
       data = new HashMap<String,String>();
       headers = new HashMap<String,String>();
       headers.put("Authorization", "Stanza "+APIkey);
       
   }   
    public CalendarRequest build(){
       
       data.putIfAbsent("calendarShortname",Shortname);
       data.putIfAbsent("name", FullName);
       if(background != null)
       data.putIfAbsent("background", background);
       if(image != null)
       data.put("image", image);
       return this;
    }
   
    public CalendarRequest setShortname(String Shortname) {
        this.Shortname = Shortname;
        return this;
    }

    public CalendarRequest setFullName(String FullName) {
        this.FullName = FullName;
        return this;
    }

    public CalendarRequest setBackground(String background) {
        this.background = background;
        return this;
    }

    public CalendarRequest setImage(String image) {
        this.image = image;
        return this;
    }
}
