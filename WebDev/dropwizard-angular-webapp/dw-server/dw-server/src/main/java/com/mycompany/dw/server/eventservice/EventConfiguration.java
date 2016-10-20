/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dw.server.eventservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author james
 */
class EventConfiguration extends Configuration{
    @NotEmpty
    @JsonProperty
    private String template;
    
    @NotEmpty
    @JsonProperty
    private String defaultName = "Stranger";
    
    @JsonProperty
    public String getTemplate() {
        return template;
    }
    
    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }
}
