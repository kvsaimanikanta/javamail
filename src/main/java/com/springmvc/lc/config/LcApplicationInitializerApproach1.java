package com.springmvc.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LcApplicationInitializerApproach1
{

	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub

		//
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(LcApplicationConfig.class);

		// creating dispatcher servlet object
		DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

		// register dispatcher servlet with servlet context
		ServletRegistration.Dynamic myDispatcherServlet = servletContext.addServlet("myDispatcherServlet",
				dispatcherServlet);

		// adding load on start up
		myDispatcherServlet.setLoadOnStartup(1);

		// adding url mapping
		myDispatcherServlet.addMapping("/");

	}

}
