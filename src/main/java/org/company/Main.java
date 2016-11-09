package org.company;

import org.eclipse.jetty.server.Server;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

//import java.nio.file.Files;
//import java.nio.file.Paths;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;



public class Main {

    public static void main(String[] args) throws Exception {
        DataBase db = new DataBase();
        Product product = db.getProduct(3);
        String data = product.toString();
        List<Product> list = new ArrayList<Product>();
        list = db.getAllProducts();


        Servlet servlet = new Servlet(list);
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        handler.addServlet(new ServletHolder(servlet), "/base");
        server.setHandler(handler);
        server.start();
        server.join();

        db.getConnection().close();
    }
}
