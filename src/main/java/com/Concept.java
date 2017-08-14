/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Brenton
 */
abstract class Concept {
    StanzaClient client;
    ObjectMapper mapper;

    public Concept(StanzaClient client) {
        this.client = client;
        mapper = client.getMapper();
    }
}
