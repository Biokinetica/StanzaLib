/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Brenton
 */

public class CalendarResponse {
    @JsonProperty("calendarShortname")
    String Shortname;
    @JsonProperty("name")
   private String FullName;
   private String background;
   private String image;
   private List<Category> categories;
   private String error;


    public String getError() {
        return error;
    }


    public String getShortname() {
        return Shortname;
    }

    public String getFullName() {
        return FullName;
    }

    public String getBackground() {
        return background;
    }

    public String getImage() {
        return image;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
