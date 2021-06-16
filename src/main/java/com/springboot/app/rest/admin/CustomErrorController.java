package com.springboot.app.rest.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class CustomErrorController implements ErrorController{

	/*
	 * @RequestMapping("/error") public String handleError(HttpServletRequest
	 * request) { Object status =
	 * request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	 * 
	 * if (status != null) { Integer statusCode =
	 * Integer.valueOf(status.toString());
	 * 
	 * //404 : sai đường địa chỉ link if(statusCode == HttpStatus.NOT_FOUND.value())
	 * { return "/views/errors/error-404"; } //500 lỗi ở server (Tomcat) else
	 * if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) { return
	 * "/views/errors/error-500"; } //không có quyền truy cập else if (statusCode ==
	 * HttpStatus.UNAUTHORIZED.value()) { return "/views/errors/error-401"; } }
	 * return "/views/errors/error"; }
	 */
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
