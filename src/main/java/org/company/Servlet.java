package org.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/base")
public class Servlet extends HttpServlet{
    Object arg;

    Servlet(Object arg){
        this.arg = arg;
}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        getServletContext().getRequestDispatcher("/page.jsp").forward(request, response);
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("<!DOCTYPE html> <html> <head> <title>OnlineStore</title> </head><body>" + arg + "</body></html>");
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String protocol = req.getProtocol();
//        String msg = lStrings.getString("http.method_post_not_supported");
//        if (protocol.endsWith("1.1")) {
//            resp.sendError(405, msg);
//        } else {
//            resp.sendError(400, msg);
//        }
//    }

}
