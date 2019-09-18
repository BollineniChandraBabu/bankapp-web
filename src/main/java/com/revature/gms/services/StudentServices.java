package com.revature.gms.services;

import java.util.List;

import com.revature.gms.dao.impl.StudentsDaoImpl;
import com.revature.gms.model.Students;

public class StudentServices {
	StudentsDaoImpl studentsDaoImpl=new StudentsDaoImpl();

	public List<Students> getStudents() {
		return studentsDaoImpl.viewAllStudents();
	}

	public Students checkStudentById(int studentId) {
		return studentsDaoImpl.checkStudentById(studentId);
	}

	public  int insert(Students students) {
		return studentsDaoImpl.insert(students);
	}

	public Object viewStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
