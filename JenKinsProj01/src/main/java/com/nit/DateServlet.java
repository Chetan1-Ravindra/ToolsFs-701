package com.nit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dateServlet")
public class DateServlet extends HttpServlet{

@Override
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter pw=resp.getWriter();
	Date date = new Date();
	pw.println("<h1>Date and time "+date+ "</h1>");
	pw.println("<br><h1><a href=index.jsp>home</a><h1>");
	pw.close();
}

}
