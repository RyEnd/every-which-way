/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryanbmolnar.dropwizardrestapi;

/**
 *
 * @author ryan
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/emp-details")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    private final String message;
    private final String defaultText1;
    private final String defaultText2;
    public EmployeeResource(String message, String defaultText1, String defaultText2) {
        this.message = message;
        this.defaultText1 = defaultText1;
        this.defaultText2 = defaultText2;
    }

    @GET
    @Timed
    public Message sayHello(@QueryParam("param1") Optional<String> 
    param1, @QueryParam("param2") Optional<String> param2) {
        final String value = String.format(message, param1.or(defaultText1),
        		param2.or(defaultText2));
        return new Message(value);
    }     
}