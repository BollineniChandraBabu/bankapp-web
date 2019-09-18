package com.revature.gms.controller;

import com.revature.gms.model.Students;
import com.revature.gms.services.StudentServices;

public class StudentsController {
StudentServices studentServices=new StudentServices();
	public Students checkStudentById(int studentId) {
		return studentServices.checkStudentById(studentId);
		
		
	}
	public int insert(Students students) {
		return studentServices.insert(students);
	}
	public Object viewStudents() {
		return studentServices.getStudents();
	}

}
