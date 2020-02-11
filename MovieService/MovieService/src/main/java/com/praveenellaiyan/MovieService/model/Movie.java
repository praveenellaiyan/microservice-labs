package com.praveenellaiyan.MovieService.model;

import java.io.Serializable;

public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String locale;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String name, String locale) {
		super();
		this.name = name;
		this.locale = locale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}
