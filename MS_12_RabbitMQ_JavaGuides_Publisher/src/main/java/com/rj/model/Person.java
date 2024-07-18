package com.rj.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Person implements Serializable
{

	private String name;
	private String city;
	private String profile;
	
	
}
