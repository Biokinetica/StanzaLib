/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

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
   private Date updated;
   private boolean official;
   private boolean searchable;
   private int count;
   private Date created;
   //private List<Map<String,String>> tags; I don't know what these will be

    public Date getCreated() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
df.setTimeZone(tz);
df.format(created);
        return created;
    }

    public int getCount() {
        return count;
    }

    public boolean isOfficial() {
        return official;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public Date getUpdated() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
df.setTimeZone(tz);
df.format(updated);
        return updated;
    }

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
