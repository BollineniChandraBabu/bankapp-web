package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.gms.dao.impl.DepartmentsDaoImpl;
import com.revature.gms.model.Departments;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentsDaoImpl departmentsDaoImpl=new DepartmentsDaoImpl();
	List<Departments> departmentsList=	departmentsDaoImpl.viewDepartments();
	  Gson gson = new Gson();
      String json = gson.toJson(departmentsList);
      
     
      PrintWriter out = response.getWriter();
      out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
