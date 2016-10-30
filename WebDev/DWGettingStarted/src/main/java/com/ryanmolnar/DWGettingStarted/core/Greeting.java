package com.ryanmolnar.DWGettingStarted.core;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author ryan
 */
public class Greeting {

    @JsonProperty
    private String greeting;

    public Greeting() {
    }

    public Greeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}