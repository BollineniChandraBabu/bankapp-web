package com.revature.gms.controller;

import java.util.List;

import com.revature.gms.exception.ServiceException;
import com.revature.gms.model.Marks;
import com.revature.gms.services.MarksServices;

public class MarksController {
Marks marks=new Marks();
MarksServices marksServices = new MarksServices();
	public List<Marks> findMaxMarks() throws ServiceException {
		List<Marks> marksList = marksServices.findMaxMarks();
		return marksList;
	}
	public List<Marks> viewAllMarks() throws ServiceException {
		return marksServices.viewAllMarks();
	
	}
	public boolean insertOrUpdate(Marks marks) throws ServiceException {
		return marksServices.insertOrUpdate(marks);
	}
	public Object viewBySubjectCode(int subjectCode) {
		return marksServices.viewBySubjectCode(subjectCode);
	
		
	}
	public List<Marks> viewBySubjectName(String subjectName) {
		return marksServices.viewBySubjectName(subjectName);
		
	}
	public List<Marks> getMarksByGrade(char grade) throws ServiceException {
		return marksServices.viewMarksByGrade(grade);
		
	}
	public boolean checkSubjectById(int subjectId) {
		return marksServices.checkSubjectById(subjectId);
	}
	
	

}
