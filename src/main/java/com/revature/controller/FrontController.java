package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.gms.controller.DepartmentsController;
import com.revature.gms.controller.GradesController;
import com.revature.gms.controller.MarksController;
import com.revature.gms.controller.StudentsController;
import com.revature.gms.controller.SubjectsController;
import com.revature.gms.controller.UsersController;
import com.revature.gms.exception.ServiceException;
import com.revature.gms.model.Departments;
import com.revature.gms.model.Marks;
import com.revature.gms.model.Students;
import com.revature.gms.model.Subjects;
import com.revature.gms.model.Users;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        
		        System.out.println("-----GET---------");
		        String requestURI = request.getRequestURI();
		        System.out.println("RequestURI:" + requestURI);
		        
		        String contextPath = request.getContextPath();
		        System.out.println("ContextPath:" + contextPath);
		        
		        String path = requestURI.substring(contextPath.length());
		        System.out.println("path:" + path);
		        
		         Object object = null;
				try {
					object = sendRequest(path,request);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         sendResponse(response, object);
		    }

		    public Object sendRequest(String path,HttpServletRequest request) throws ServiceException {
		       Object object=null;
		        Users users = null;
		        System.out.println(path);
		        switch(path) 
		        {  
		        
		        case "/FrontController/addEmployee.do": 
	        	{
	        		users=new Users();
	        		users.setName(request.getParameter("name"));
	        		users.setFatherName(request.getParameter("fathername"));
	        		users.setEmail(request.getParameter("email"));
	        		Departments departments=new Departments();
	        		departments.setId(Integer.parseInt(request.getParameter("department")));
	        		users.setDepartment(departments);
	        			UsersController usersController = new UsersController();
	        			object = usersController.insertController(users);
	        			break;
	        	}
	        	
		        case "/FrontController/addStudent.do": 
	        	{
	        		Students students=new Students();
	        		students.setName(request.getParameter("name"));
	        		students.setFatherName(request.getParameter("fathername"));
	        		students.setAddress(request.getParameter("address"));
	        		students.setDateOfBirth(request.getParameter("dob"));
	        		Departments departments=new Departments();
	        		departments.setId(Integer.parseInt(request.getParameter("department")));
	        		students.setDepartment(departments);
	        			StudentsController studentsController = new StudentsController();
	        			object = studentsController.insert(students);
	        			break;
	        	}
	        	
	        	
		        case "/FrontController/checkEmail.do": 
	        	{
	        			UsersController usersController = new UsersController();
	        			String mail=request.getParameter("email");
	        			object = usersController.checkByMailId(mail);
	        			break;
	        	}
		        case "/FrontController/activateEmployee.do": 
	        	{
	        			UsersController usersController = new UsersController();
	        			String mail=request.getParameter("email");
	        			int eid=Integer.parseInt(request.getParameter("eid"));
	        			String password=request.getParameter("password");
	        			object = usersController.activateAccount(eid,mail,password);
	        			break;
	        	}
		        case "/FrontController/viewEmployees.do": 
	        	{
	        			UsersController usersController = new UsersController();
	        			
	        			object = usersController.viewAllUsers();
	        			break;
	        	}
	        	
		        case "/FrontController/checkStudentId.do": 
	        	{
	        			StudentsController studentsController = new StudentsController();
	        			int studentId=Integer.parseInt(request.getParameter("id"));
	        			object = studentsController.checkStudentById(studentId);
	        			break;
	        	}
	        	
		        case "/FrontController/insertMarks.do": 
	        	{
	        		Marks marks=new Marks();
	        			MarksController marksController = new MarksController();
	        			
	        			Students student =new Students();
	        			int regno=Integer.parseInt(request.getParameter("id"));
	        			student.setRegistrationNumber(regno);
	        			marks.setStudent(student);
	        			Subjects subjects=new Subjects();
	        			int sid=Integer.parseInt(request.getParameter("subjectdetails"));
	        			subjects.setId(sid);
	        			marks.setSubjects(subjects);
	        			int mark=Integer.parseInt(request.getParameter("marks"));
	        			marks.setMarks(mark);
	        			object = marksController.insertOrUpdate(marks);
	        			break;
	        	}
	        	
		        case "/FrontController/viewStudents.do": 
	        	{
	        			StudentsController studentsController = new StudentsController();
	        			
	        			object = studentsController.viewStudents();
	        			break;
	        	}
		        case "/FrontController/checkdetails.do": 
	        	{
	        		object=false;
	        		int eid=Integer.parseInt(request.getParameter("eid"));
	        			UsersController usersController = new UsersController();
	        			String mail=request.getParameter("email");
	        			int id = usersController.findIdByMail(mail);
	        			if(id==eid)
	        			{
	        				object=true;
	        			}
	        			break;
	        	}
	        	
	        	
		        case "/FrontController/checkDepartment.do": 
	        	{
	        			DepartmentsController departmentsController = new DepartmentsController();
	        			int id=Integer.parseInt(request.getParameter("department"));
	        			object = departmentsController.checkDepartment(id);
	        			break;
	        	}
		        
		        	case "/FrontController/viewtop.do": 
		        	{
		        			MarksController marksController = new MarksController();
		        			object = marksController.findMaxMarks();
		        			break;
		        	}
		        	case "/FrontController/viewallmarks.do": 
		        	{
		        			MarksController marksController = new MarksController();
		        			object = marksController.viewAllMarks();
		        			break;
		        	}
		        	case "/FrontController/viewgrade.do": 
		        	{
		        		GradesController gradesController = new GradesController();
		        		object = gradesController.viewGrades();
		        		break;
		        	}
		        	
		        	case "/FrontController/viewByGrade.do": 
		        	{
		        		MarksController marksController = new MarksController();
		        		String grade=request.getParameter("grade");
		        		object =marksController.getMarksByGrade(grade.charAt(0));
		        		break;
		        	}
		        	
		        	case "/FrontController/viewBySubject.do": 
		        	{
		        		MarksController marksController = new MarksController();
		        		try {
		        		int subject=Integer.parseInt(request.getParameter("subjectdetails"));
		        		
	        			object = marksController.viewBySubjectCode(subject);
		        		}
		        		catch(NumberFormatException nfe)
		        		{
		        			String subject=request.getParameter("subjectdetails");
			        		
		        			object = marksController.viewBySubjectName(subject);
		        		}
	        			break;
		        	}
		        	
		        	case "/FrontController/viewAvailableSubjects.do": 
		        	{
		        		SubjectsController subjectsController=new SubjectsController();
	        			object = subjectsController.viewSubjects();
	        			break;
		        	}
		        	
		        	case "/FrontController/login.do": 
		        	{
		        		UsersController usersController = new UsersController();
		        		users = usersController.loginController(request.getParameter("email"), request.getParameter("password"));
		        		if (users != null) {
		        			HttpSession session = request.getSession();
		        			session.setAttribute("email", request.getParameter("email"));
		        			session.setAttribute("password", request.getParameter("password"));
		        			session.setAttribute("roles", users.isRoles());
		        			session.setAttribute("Users", users);
		        		}
		        		object = users;
		        		break;
		        	}
		        	default:
		        		System.out.println("Path not found:" + path);
		                
		        }
				return object;
		    }

		    private void sendResponse(HttpServletResponse response, Object result) throws IOException {
		        String json = null;
		        Gson gson = new Gson();
		        if ( result != null) {
		            if ( result instanceof List) {
		                System.out.println("Convert to List JSON");
		                json = gson.toJson(result);
		            }
		            else if ( result instanceof Boolean) {
		                System.out.println("Convert Boolean JSON");
		                JsonObject jsonObject = new JsonObject();
		                jsonObject.addProperty("result", (Boolean) result);
		                json = jsonObject.toString();
		            }
		            else if ( result instanceof Object) {
		                System.out.println("Convert to Object JSON");
		                json = gson.toJson(result);
		            }            
		            
		        }
		        else {
		            System.out.println("No conversion required");
		        }
		        PrintWriter out = response.getWriter();
		        out.print(json);
		        out.flush();
		    }

		   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
