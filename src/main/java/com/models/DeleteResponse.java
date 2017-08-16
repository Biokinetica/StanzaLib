/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.HashMap;

/**
 *
 * @author Brenton
 */
public class DeleteResponse {
    private String success;
    private HashMap<String,String> error;
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }
    
    public String getMessage() {
        return message;
    }

    
    public DeleteResponse(){
       error = new HashMap<>();
    }
    public String getSuccess() {
        return success;
    }

    public HashMap<String, String> getError() {
        return error;
    }
}
