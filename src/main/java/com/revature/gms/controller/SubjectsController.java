package com.revature.gms.controller;

import java.util.List;

import com.revature.gms.model.Subjects;
import com.revature.gms.services.SubjectsServices;

public class SubjectsController {
boolean result=false;
SubjectsServices subjectsServices=new SubjectsServices();

	public boolean checkSubjectCode(int subjectCode) {
		
		return subjectsServices.checkSubjectCode(subjectCode);
		
	}
	public List<Subjects> viewSubjects() {
		return subjectsServices.viewSubjects();
		
	}
	public boolean checkSubjectName(String subjectName) {
		
		return subjectsServices.checkSubjectName(subjectName);
		
	}

}
