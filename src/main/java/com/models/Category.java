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

class Category {
    String name;
    String categoryShorname;
    String calendarShortname;
    boolean rolling;
    boolean geoEnabled;
    @JsonProperty("private")
    boolean isPrivate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryShorname() {
        return categoryShorname;
    }

    public void setCategoryShorname(String categoryShorname) {
        this.categoryShorname = categoryShorname;
    }

    public String getCalendarShortname() {
        return calendarShortname;
    }

    public void setCalendarShortname(String calendarShortname) {
        this.calendarShortname = calendarShortname;
    }

    public boolean isRolling() {
        return rolling;
    }

    public void setRolling(boolean rolling) {
        this.rolling = rolling;
    }

    public boolean isGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
    
    
}
