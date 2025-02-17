package com.CrudServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 String id=request.getParameter("id");
		 String name=request.getParameter("name");
		 String password=request.getParameter("password");
		 String email=request.getParameter("email");
		 String city=request.getParameter("city");
		 
		 Emp e=new Emp();
		 e.setId(id);
		 e.setName(name);
		 e.setPassword(password);
		 e.setEmail(email);
		 e.setCity(city);
		 
		 int status=EmpDao.save(e);
		 if(status>0){
			 out.print("<p>Record saved successfully!</p>");
			 request.getRequestDispatcher("index.html").include(request, response);
		 }else {
			 out.print("Sorry! unable to save record");
		 }
		 out.close();
	}

}
