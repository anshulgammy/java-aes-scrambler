package com.techbrunch.innovation.aes_scrambler.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EntryControllServlet
 */
public class EntryControllerServlet extends HttpServlet {
   
	private static final long serialVersionUID = -348495757043923935L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public EntryControllerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Served at : " + request.getContextPath());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("static/home.html");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
