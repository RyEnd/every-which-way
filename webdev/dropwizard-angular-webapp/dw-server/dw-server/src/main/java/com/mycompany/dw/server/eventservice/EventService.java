/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dw.server.eventservice;

import com.mycompany.dw.server.eventservice.health.TemplateHealthCheck;
import com.mycompany.dw.server.eventservice.persistence.PersonDao;
import com.mycompany.dw.server.eventservice.representations.Person;
import com.mycompany.dw.server.eventservice.resources.PersonsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.h2.jdbcx.JdbcConnectionPool;
import org.skife.jdbi.v2.DBI;

/**
 *
 * @author james
 */
public class EventService extends Application<EventConfiguration> {
    private static List<Person> persons;

    static {
        persons = Collections.synchronizedList(new ArrayList<Person>());
        persons.add(new Person("Per", "per@kodemaker.no", "12345678"));
        persons.add(new Person("Magnus", "magnus@kodemaker.no"));
        persons.add(new Person("Ronny", "ronny@kodemaker.no"));
        persons.add(new Person("August", "august@kodemaker.no"));
        persons.add(new Person("Helge", "helge.jensen@finn.no"));
    }

    public static void main(String[] args) throws Exception {
        new EventService().run(args);
    }

    @Override
    public void initialize(Bootstrap<EventConfiguration> bootstrap) {
    }

    @Override
    public void run(EventConfiguration conf, Environment env) throws ClassNotFoundException {
        String template = conf.getTemplate();
        String defaultName = conf.getDefaultName();

        //DBIFactory factory = new DBIFactory();
        //final DBI jdbi = factory.build(env, conf.getDatabaseConfiguration(), "postgresql");
        // using in-memory H2 database here for simplicity during development
        JdbcConnectionPool jdbcConnectionPool = JdbcConnectionPool.create("jdbc:h2:mem:test", "username", "password");
        DBI jdbi = new DBI(jdbcConnectionPool);
        PersonDao personDao = jdbi.onDemand(PersonDao.class);
        personDao.createPersonTable();
        seedTheDatabase(personDao);  // add some test data

        env.jersey().register(new PersonsResource(personDao));
        env.jersey().register(new TemplateHealthCheck(template));
    }
    
    private void seedTheDatabase(PersonDao personDao) {
        for (Person p : persons) {
            personDao.insert(p);
        }
    }
}