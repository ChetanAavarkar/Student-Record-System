package com.studentrecord.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentrecord.db.DBConnection;
import com.studentrecord.model.Student;

/**
 * StudentDAO (Data Access Object)
 * This class performs all database operations
 * related to the Student table.
 * Operations:
 * - Add Student
 * - Search Student
 * - Display All Students
 * - Update Student
 * - Delete Student
 */
public class StudentDAO {
	
	/**
     * Adds a new student to the database.
     * @param student Student object
     * @return true if student is added successfully
     */
	public boolean addStudent(Student student) {
		
		// 1. Check if ID already exists
		if (studentExists(student.getId())) {
			System.out.println("Student ID already exists.");
			System.out.println("Please enter another ID.");
			return false;
		}
		
		//2. If not exists, perform insert
		String sql = "INSERT INTO student (id, name, city) VALUES (?, ?, ?)";
		
		try (Connection con = DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getCity());
			
			int rows = ps.executeUpdate();

			return rows > 0;
			
		} catch (SQLException e) {
			System.out.println("Failed to add student.");
			System.out.println("Please check database connection or input data.");
			return false;
		}
	}
	
	/**
     * Searches a student using Student ID.
     * @param id Student ID
     * @return Student object if found, otherwise null
     */
	public Student searchStudent(int id) {
		String sql = "SELECT id, name, city FROM student WHERE id = ?";
		
		try (Connection con = DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Student student = new Student();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setCity(rs.getString("city"));
					return student;
				}
			}
		} catch (SQLException e) {
			System.out.println("Failed to search student.");
			System.out.println("Please check database connection.");
		}
		return null;
	}
	
	/**
     * Retrieves all students from the database.
     * @return List of Student objects
     */
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		String sql = "SELECT id, name, city FROM student";
		
		try (Connection con = DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setCity(rs.getString("city"));
				students.add(student);
			}
		} catch (SQLException e) {
			System.out.println("Failed to fetch student records.");
			System.out.println("Please check database connection.");
		}
		return students;
	}
	
	/**
     * Deletes a student using Student ID.
     * @param id Student ID
     * @return true if deleted successfully
     */
	public boolean deleteStudent(int id) {
		String sql = "DELETE FROM student WHERE id = ?";
		
		try (Connection con = DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			
			int rows = ps.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			System.out.println("Failed to delete student.");
			System.out.println("Please check database connection.");
			return false;
		}
	}
	
	/**
     * Updates student details.
     * @param student Updated Student object
     * @return true if update is successful
     */
	public boolean updateStudent(Student student) {
		String sql = "UPDATE student SET name = ?, city = ? WHERE id = ?";
		
		try (Connection con = DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			 
			 ps.setString(1, student.getName());
			 ps.setString(2, student.getCity());
			 ps.setInt(3, student.getId());
			 
			 int rows = ps.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			System.out.println("Failed to update student.");
			System.out.println("Please check database connection or entered data.");
			return false;
		}	 
	}
	
	/**
	 * Checks if a student with given ID already exists.
	 * @param id Student ID
	 * @return true if student exists, false otherwise
	 */
	public boolean studentExists(int id) {
		String sql = "SELECT id FROM student WHERE id = ?";
		
		try (Connection con = DBConnection.getConnection();
			 PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			try (ResultSet rs = ps.executeQuery()) {
				// If rs.next() is true, at least one record exists
				return rs.next();
			}
			
		} catch (SQLException e) {
			System.out.println("Could not check student existence.");
			System.out.println("Please check database connection.");
			//Here, we return false (assuming not exists).
			return false;
		}
	}
}
