package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/base")
public class Servlet extends HttpServlet{
    Product data;
    public Servlet(Product data){
        this.data = data;
}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
//        String author = request.getParameter("author");
        String name =  req.getParameter("book");
        System.out.println(name);

        PrintWriter out = resp.getWriter();
        out.println("<h1> Информация о товаре</h1>");
//        out.println("Название: " + data.getName()+ "</br>");
//        out.println("Автор: " + data.getAuthor() + "</br>");

        out.write("<h1>Книга: "+ name +"</h1>");//("<!DOCTYPE html> <html> <head> <title>OnlineStore</title> </head><body>" + arg + "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        String name =  req.getParameter("book");
        System.out.println(name);
        PrintWriter out = resp.getWriter();
        out.write("<h1>Hello Servlet"+ name +"</h1>");
    }

}
