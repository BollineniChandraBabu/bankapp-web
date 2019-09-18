package com.revature.gms.services;

import java.util.List;
import java.util.Scanner;

import com.revature.gms.dao.UsersDao;
import com.revature.gms.dao.impl.UsersDaoImpl;
import com.revature.gms.exception.DBException;
import com.revature.gms.exception.ServiceException;
import com.revature.gms.loginPage.AdminLogin;
import com.revature.gms.loginPage.Login;
import com.revature.gms.loginPage.UserLogin;
import com.revature.gms.model.Users;
import com.revature.gms.validator.UsersValidator;

public class UsersServices {
	UsersValidator usersValidator=new UsersValidator();
	UsersDaoImpl userDAOImpl = new UsersDaoImpl();
	MarksServices marksServices=new MarksServices();
	Scanner scanner=new Scanner(System.in);
Users users=new Users();

	public Users login(String email, String password) throws ServiceException {
		users = null;
		try {
			users = userDAOImpl.login(email,password);
		} catch (DBException e) {
			throw new ServiceException("Unable to login");
			
		}
		return users;

	}

	public int insert(Users users) throws ServiceException {
		int id;
		try {
			
			id = userDAOImpl.insert(users);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to insert new users");	
		}
		return id;
	}
	public void validatingUser(Users users) throws ServiceException
	{
		if (users!= null) {
			if (users.isRoles()==true) {
				AdminLogin adminLogin=new AdminLogin();
				adminLogin.adminLogin();
			} else if (users.isRoles()==false) {
				UserLogin userLogin=new UserLogin();
				userLogin.userLogin(users);
			}
		} else {
			System.out.println("Invalid Login Credentials");
			Login login=new Login();
			login.login();
		}
	}

	public boolean validateName(String name) {
		boolean result=usersValidator.validateName(name);
		return result;
	}

	public String getEmail() {
		boolean result=false;
		String email;
		while(true) {
			System.out.println("enter your email");
			email=scanner.next();
			result=usersValidator.emailValidator(email);
			if(result==true) { 
			break;
			}
			else { System.out.println("please enter valid email id....");}
			}
		return email;
	}

	public boolean validateDate(String sDate) {
		boolean result=usersValidator.dateValidator(sDate);
		return result;
	}

	public boolean checkByMailId(String mailId) throws DBException
	{boolean result=false;
		try {
			result = userDAOImpl.checkByMailId(mailId);
		} catch (DBException e) {
			e.printStackTrace();
			throw new DBException("Unable to insert new users");
			
		}
		return result;
	}
	
	
	public boolean activateAccount(int eid, String mail, String password) throws ServiceException {
		
		return userDAOImpl.activateAccount(mail,eid,password);
	}

	public int findIdByMail(String string) {
		return userDAOImpl.findIdByMail(string);
	}

	public  List<Users> viewAllUsers() {
		return userDAOImpl.viewAllUsers();
	}
	
}
