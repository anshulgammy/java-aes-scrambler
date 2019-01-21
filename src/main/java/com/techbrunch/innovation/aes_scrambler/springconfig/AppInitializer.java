package com.techbrunch.innovation.aes_scrambler.springconfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.scan("com.techbrunch.innovation.aes_scrambler");
		container.addListener(new ContextLoaderListener(context));
		ServletRegistration.Dynamic dispatcher = container.addServlet("mvc", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}