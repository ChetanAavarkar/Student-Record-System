package com.studentrecord;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

import com.studentrecord.dao.StudentDAO;
import com.studentrecord.model.Student;

/**
 * Student Record System
 * A simple console-based application to manage student records.
 * Supports adding, searching, removing, updating, and displaying students.
 * Uses StudentDAO for database operations.
 */
public class StudentRecordSystem {

	public static void main(String[] args) {
		// Create Scanner object for user input
		Scanner sc = new Scanner(System.in);
		
		// Create DAO object to handle database operations
		StudentDAO studentDAO = new StudentDAO();
		
		// Infinite loop to keep the menu running until user chooses to exit
		while(true) {
			// Display the main menu
			System.out.println("\n===== Student Record System =====");
			System.out.println("1. Add Student");
			System.out.println("2. Search Student");
			System.out.println("3. Remove Student");
			System.out.println("4. Update Student");
			System.out.println("5. Display Students");
			System.out.println("6. Exit");
			System.out.println("Enter your choice: ");
			
			// Read user's menu choice
			int choice = sc.nextInt();
			sc.nextLine(); // Consume the leftover newline character
			
			// Handle different menu options using switch-case
			switch (choice) {
			
				// Case 1: Add a new student
				case 1:
					System.out.print("Enter Student ID: ");
					int idToAdd = sc.nextInt();
					sc.nextLine(); // Consume newline
				
					System.out.print("Enter Student Name: ");
					String name = sc.nextLine();
					
					System.out.print("Enter Student City: ");
					String city = sc.nextLine();
					
					// Create a new Student object
					Student student = new Student(idToAdd, name, city);
					
					// Add student to the database using DAO
					boolean added = studentDAO.addStudent(student);
					if (added) {
						System.out.println("Student added successfully to database.");
					} else {
						System.out.println("Failed to add student.");
					}
					break;
				
				// Case 2: Search for a student by ID
				case 2:
					System.out.print("Enter Student ID to search: ");
					int idToSearch = sc.nextInt();
					sc.nextLine(); // Consume newline
					
					// Search student using DAO
					Student foundStudent = studentDAO.searchStudent(idToSearch);
					
					if (foundStudent != null) {
						System.out.println("Student Found:");
						System.out.println("ID : " + foundStudent.getId());
						System.out.println("Name : " + foundStudent.getName());
						System.out.println("City : " + foundStudent.getCity());
					} else {
						System.out.println("Student not found.");
					}
					break;
				// Case 3: Remove a student by ID	
				case 3:
					System.out.print("Enter studnet ID to remove: ");
					int idToRemove = sc.nextInt();
					sc.nextLine(); // Consume newline
					
					// Delete student using DAO
					boolean deleted = studentDAO.deleteStudent(idToRemove);
					if (deleted) {
						System.out.println("Student removed successfully.");
					} else {
						System.out.println("Student not found");
					}
					break;
					
				// Case 4: Update an existing student's details
				case 4:
					System.out.print("Enter Student ID to update: ");
					int idToUpdate = sc.nextInt();
					sc.nextLine(); // Consume newline
					
					System.out.print("Enter New Name: ");
					String newName = sc.nextLine();
					
					System.out.print("Enter New City: ");
					String newCity = sc.nextLine();
					
					// Create updated Student object
					Student updatedStudent = new Student(idToUpdate, newName, newCity);
					
					// Update student in the database
					boolean updated = studentDAO.updateStudent(updatedStudent);
					if (updated) {
						System.out.println("Student updated successfully.");
					} else {
						System.out.println("Student not found or update failed.");
					}
					break;
				
				// Case 5: Display all students
				case 5:
					// Retrieve list of all students from the database
					List<Student> students = studentDAO.getAllStudents();
					
					if (students.isEmpty()) {
						System.out.println("No students available.");
					} else {
						System.out.println("\n--- Student List ---");
						// Iterate through the list and display each student
						for (Student s : students) {
							System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", City: " + s.getCity());
						}
					}
					break;
				
				// Case 6: Exit the application
				case 6:
					System.out.println("Exiting program...");
					sc.close(); // Close the Scanner
					return;  // Exit the main method
					
				// Handle invalid menu choice
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
