/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dw.server.eventservice.persistence;

import com.mycompany.dw.server.eventservice.representations.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author james
 */
public class PersonMapper implements ResultSetMapper<Person> {
    @Override
    public Person map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        return new Person(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
    }
}