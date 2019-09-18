package com.revature.gms.services;

import java.util.List;
import java.util.Scanner;

import com.revature.gms.controller.GradesController;
import com.revature.gms.dao.impl.GradesDaoImpl;
import com.revature.gms.dao.impl.MarksDaoImpl;
import com.revature.gms.dao.impl.UsersDaoImpl;
import com.revature.gms.exception.DBException;
import com.revature.gms.exception.ServiceException;
import com.revature.gms.model.Grades;
import com.revature.gms.model.Marks;
import com.revature.gms.model.Students;

public class MarksServices {
Marks marks=new Marks();
MarksDaoImpl marksDAOImpl = new MarksDaoImpl();
GradesController gradesController=new GradesController();
UsersDaoImpl usersDaoImpl=new UsersDaoImpl();
StudentServices studentServices=new StudentServices();
Grades grades=new Grades();
List<Marks> marksList;
Scanner scanner=new Scanner(System.in);
	public List<Marks> findMaxMarks() throws ServiceException {
		try {
			marksList = marksDAOImpl.findMaxMarks();
		} catch (DBException e) {
			throw new ServiceException("Unable to login");
			
		}
		return marksList;
	}
	public List<Marks> viewAllMarks() throws ServiceException {
		try {
			marksList = marksDAOImpl.viewAllMarks();	
		}
			catch (DBException e) {
				throw new ServiceException("Unable to View" +e);	
			}
		return marksList;

	}
	public List<Marks> viewMarksByGrade(char grade) throws ServiceException {
		try {
			List<Students> studentsList=studentServices.getStudents();
			GradesDaoImpl gradesDaoImpl=new GradesDaoImpl();
			List<Marks> marksList;
			System.out.println("-------------------------------------------------------------------------------");
			for(Students students:studentsList)
			{
				int average=marksDAOImpl.getAverage(students.getRegistrationNumber());
				String grade1=gradesDaoImpl.getGrade(average);
				if(grade1.trim().charAt(0)==grade)
				{
					marksList=marksDAOImpl.getMarksById(students.getRegistrationNumber());
					for(Marks marks:marksList)
					{
						System.out.print("\nStudent Id :"+marks.getStudent().getRegistrationNumber()+"  Student Name :"+marks.getStudent().getName()+"\n");
						break;
					}
					for(Marks marks:marksList)
					{
						System.out.print(marks.getSubjects().getName() +":"+marks.getMarks() +"\t");
					}
					System.out.println("\n-------------------------------------------------------------------------------");					
				}
			}
			
			
		} catch (DBException e) {
			throw new ServiceException("Unable to View" +e);
			
		}
		return marksList;
	}
	public Marks checkAvailability(int studentId,int subjectId) throws ServiceException {
			return marksDAOImpl.checkAvailability(studentId,subjectId);
	}
	public boolean insertOrUpdate(Marks marks) throws ServiceException {
		boolean result=false;
		try 
		{
			result=marksDAOImpl.updateMarks(marks);
		}
		catch (DBException e) {
			result=marksDAOImpl.insertMarks(marks);
			throw new ServiceException("Unable to View" +e);
		}
		return result;
	}
	
	
	public int getNumber() 
	{
		boolean result=false;
		int number = 0;
		while(result!=true) {
		try{
			String s=scanner.next();
			number=Integer.parseInt(s);
			result=true;
			break;
		}
		catch(Exception e) 
		{
			System.out.println("enter correct choice....");
			result=false;
		}}
		return number;
	}
	public Marks getMarks(int i)
	{
		return marks;

	}
public int marksValidator() {
	
	int number;
	while(true)
	{
		number=getNumber();
		if(number>=0 && number<=100 )
		{
			break;
		}
		else 
		{
			System.out.println("marks should be >=0 and <= 100");
		}
		
	}
	return number;
	}
public Object viewBySubjectCode(int subjectCode) {
	GradesDaoImpl gradesDaoImpl=new GradesDaoImpl();

	marksList = marksDAOImpl.viewBySubjectCode(subjectCode);
	System.out.println("------------------------------------------------------");
	for(Marks marks:marksList) {
		System.out.println("subject code :"+marks.getSubjects().getId());
		System.out.println("subject name :"+marks.getSubjects().getName());
		break;
	}
	System.out.println("ID\tName\tmarks\tGrade");
	for(Marks marks1:marksList) {
	System.out.println(marks1.getStudent().getId()+"\t"+marks1.getStudent().getName()+"\t"+marks1.getMarks()+"\t"+gradesDaoImpl.getGrade(marks1.getMarks()));
	}
	System.out.println("------------------------------------------------------");
return marksList;
	
}
public List<Marks> viewBySubjectName(String subjectName) {
	GradesDaoImpl gradesDaoImpl=new GradesDaoImpl();
	marksList = marksDAOImpl.viewBySubjectName(subjectName);
	System.out.println("------------------------------------------------------");
	
	System.out.println("ID\tName\tsubject code\tsubject name\tmarks\tGrade");
	for(Marks marks1:marksList) {
	System.out.println(marks1.getStudent().getId()+"\t"+marks1.getStudent().getName()+"\t\t"+marks1.getSubjects().getId()+"\t    "+marks1.getSubjects().getName()+"\t"+marks1.getMarks()+"\t"+gradesDaoImpl.getGrade(marks1.getMarks()));
	}
	System.out.println("------------------------------------------------------");
return marksList;
	
}
public boolean checkSubjectById(int subjectId) {
	return marksDAOImpl.checkSubjectById(subjectId);
}

}
