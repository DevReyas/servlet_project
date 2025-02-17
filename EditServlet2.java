package com.CrudServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 
		 String id=request.getParameter("id");
		 
		 String name=request.getParameter("name");
		 String password=request.getParameter("password");
		 String email=request.getParameter("email");
		 String country=request.getParameter("city");
		 
		 Emp e=new Emp();
		 e.setId(id);
		 e.setName(name);
		 e.setPassword(password);
		 e.setEmail(email);
		 e.setCity(country);
		 
		 int status=EmpDao.update(e);
		 if(status>0) {
			 response.sendRedirect("ViewServlet");
		 }else {
			out.print("Sorry! unable to update record");
		}
		 
		 out.close();
	}

}
