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
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<EmployeeConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<EmployeeConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(EmployeeConfiguration configuration,
                    Environment environment) {
        final EmployeeResource resource = new EmployeeResource(
            configuration.getMessage(),
            configuration.getDefaultText1(),configuration.getDefaultText2());
        environment.jersey().register(resource);
    }  

}
