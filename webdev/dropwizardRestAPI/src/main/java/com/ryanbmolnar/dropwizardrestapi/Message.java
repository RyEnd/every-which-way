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
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Message {
    @Length(max = 3)
    private String content;

    public Message() {
        // Jackson deserialization
    }

    @JsonProperty
    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Message(String content) {
        this.content = content;
    }
}