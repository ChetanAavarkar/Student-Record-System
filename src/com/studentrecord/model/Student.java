package com.studentrecord.model;

/**
 * Student Model Class
 * This class represents a Student entity.
 * It stores the student's ID, name, and city,
 * along with constructors, getters, setters,
 * and a toString() method.
 */
public class Student {
	
	// Student ID
	private int id;
	
	// Student Name
	private String name;
	
	// Student City
	private String city;
	
	/**
     * Default Constructor
     */
	public Student() {
		
	}
	
	/**
     * Parameterized Constructor
     *
     * @param id Student ID
     * @param name Student Name
     * @param city Student City
     */
	public Student(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	// Getter Methods
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}
	
	// Setter Methods
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}	
	
	/**
     * Returns Student details in a readable format.
     */
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
}