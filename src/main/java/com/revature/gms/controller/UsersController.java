package com.revature.gms.controller;

import com.revature.gms.exception.ServiceException;
import com.revature.gms.model.Users;
import com.revature.gms.services.UsersServices;

public class UsersController {
	Users users = new Users();
	UsersServices userServices = new UsersServices();

	public Users loginController(String email, String password) {
		try {
			users = userServices.login(email, password);

		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		return users;
	}

	public int insertController(Users users) {
		int id = 0;

		try {
			id = userServices.insert(users);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
		return id;
	}

	public boolean validateName(String name) {
		boolean result = false;

		result = userServices.validateName(name);
		return result;
	}

	public String getEmail() {
		return userServices.getEmail();
	}

	public boolean validateDate(String sDate) {
		boolean result = false;

		result = userServices.validateDate(sDate);
		return result;
	}

	public void activateAccount() throws ServiceException {
		userServices.activateAccount();
	}

		public boolean checkByMailId(String mail) throws ServiceException {
			return userServices.checkByMailId(mail);
			
		}
}
