/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dw.server.eventservice.resources;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.dw.server.eventservice.persistence.PersonDao;
import com.mycompany.dw.server.eventservice.representations.Person;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author james
 */
@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonsResource {
    private PersonDao personDao;

    public PersonsResource(PersonDao dao) {
        personDao = dao;
    }

    @GET
    @Path("/{id}")
    @Timed
    public Person getPerson(@PathParam("id") Integer id) {
        Person p = personDao.findById(id);
        if (p != null) {
            return p;
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    @GET
    @Timed
    public List<Person> listPersons() {
        return personDao.getAll();
    }

    @POST
    @Timed
    public void save(Person person) {
        if (person != null && person.isValid()) {
            if (person.getId() != null) {
                personDao.update(person);
            } else {
                personDao.insert(person);
            }
        }
    }

    @DELETE
    @Path("/{id}")
    @Timed
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    public void deletePerson(@PathParam("id") Integer id) {
        /**
         * Note: AngularJS $resource will send a DELETE request as content-type test/plain for some reason;
         * so therefore we must add MediaType.TEXT_PLAIN here.
         */
        if (personDao.findById(id) != null) {
            personDao.deleteById(id);
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
}