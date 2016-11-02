package com.spring.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class LoginController extends SimpleFormController {
	final static Logger LOGGER = Logger.getLogger(LoginController.class);

	/**********************************************************/
	public ModelAndView onSubmit(Object command, BindException errors)
			throws ServletException {
		LOGGER.info("onSubmit() method called");
		System.out.println("inside onSumbit() method");
		User user = (User) command;
		String un = user.getUsername();
		String pw = user.getPassword();
		String view = "";
		if (un.equals(pw)) {
			view = getSuccessView();
		} else {
			view = getFormView();
		}
		return new ModelAndView(view, "user", user);
	}

	/*****************************************************/
	public Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		LOGGER.info("formBackingObject() method called");
		System.out.println("inside formBackingObject() method");
		User user = new User();
		user.setUsername("manjit");
		return user;
	}

}
