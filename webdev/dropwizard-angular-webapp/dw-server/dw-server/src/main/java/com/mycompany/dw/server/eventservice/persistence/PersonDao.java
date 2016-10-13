/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dw.server.eventservice.persistence;

import com.mycompany.dw.server.eventservice.representations.Person;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 *
 * @author james
 */
@RegisterMapper(PersonMapper.class)
public interface PersonDao {
    @SqlUpdate("create table PERSON (id int auto_increment primary key, name varchar(80), email varchar(80), phone varchar(20))")
    void createPersonTable();

    @SqlUpdate("insert into PERSON (name, email, phone) values (:name, :email, :phone)")
    void insert(@BindBean Person person);

    @SqlUpdate("update PERSON set name = :p.name, email = :p.email, phone = :p.phone where id = :p.id")
    void update(@BindBean("p") Person person);

    @SqlQuery("select * from PERSON where id = :id")
    Person findById(@Bind("id") int id);

    @SqlQuery("select * from PERSON")
    List<Person> getAll();

    @SqlUpdate("delete from PERSON where id = :it")
    void deleteById(@Bind int id);

    @SqlUpdate("delete from PERSON where email = :it")
    void deleteByEmail(@Bind String email);
}