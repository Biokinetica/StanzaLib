/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Brenton
 */
public class CalendarRequest {
    @JsonProperty("calendarShortname")
    String Shortname;
    @JsonProperty("name")
   private String FullName;
   private String background;
   private String image;

    public void setShortname(String Shortname) {
        this.Shortname = Shortname;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setImage(String image) {
        this.image = image;
    }
   private String error;
}
