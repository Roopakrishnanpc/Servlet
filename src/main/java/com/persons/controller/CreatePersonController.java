package com.persons.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.persons.DAO.PersonDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class CreatePersonCotroller
 */
public class CreatePersonController extends HttpServlet {
 private PersonDAO p;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("Servlet is working!");
		int personID=Integer.parseInt(request.getParameter("PersonID"));
		response.getWriter().write(personID);
		System.out.println("Received PersonID: " + personID);
		String firstName=request.getParameter("FirstName");
		response.getWriter().write(firstName);
		String lastName=request.getParameter("LastName");
		response.getWriter().write(lastName);
		//PersonDAO 
		p=new PersonDAO();
		try {
			
			p.savePerson(personID,firstName,lastName);
			response.getWriter().write("Servlet is working!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("personID", personID);
		RequestDispatcher rd=request.getRequestDispatcher("CreateSuccess.jsp");
		rd.forward(request, response);
	}

}

    /**
     * @see HttpServlet#HttpServlet()
     */
