package com.persons.controller;

import java.io.IOException;

//import jakarta.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;


import com.persons.bean.Person;
import com.persons.DAO.PersonDAO;

/**
 * Servlet implementation class GetPersonController
 */
public class GetPersonController extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int personID=Integer.parseInt(request.getParameter("PersonID"));
		PersonDAO p=new PersonDAO();
		Person person=p.getPerson(personID);
		request.setAttribute("person", person);
		RequestDispatcher rd=request.getRequestDispatcher("showPerson.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
