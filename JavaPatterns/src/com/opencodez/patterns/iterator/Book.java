package com.opencodez.patterns.iterator;

public class Book {

	private String name;
	private String publication;
	
	//Constructor; Getters; Setters;
	
	public Book(String n, String p) {
		name = n;
		publication = p;
	}

	//Getters; Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	@Override
	public String toString() {
		return String.format("Book[%s,%s]", name,publication);
	}

}
