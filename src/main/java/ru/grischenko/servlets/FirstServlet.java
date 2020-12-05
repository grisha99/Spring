package ru.grischenko.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "FirstServlet", urlPatterns = "/prod")
public class FirstServlet extends HttpServlet {

    private static Logger logger = LogManager.getLogger(FirstServlet.class);
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request");
        PrintWriter out = servletResponse.getWriter();
        out.println("<h1>Product list</h1>");
        List<Product> products= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            products.add(new Product("Milk_" + i, 34.40f + i));
        }
        for(Product item : products) {
            out.println(String.format("<p>ID: %d, title: %s, cost: %.2f</p>", item.getId(), item.getTitle(), item.getCost()));
        }
    }

    @Override
    public String getServletInfo() {
        return "My First Servlet";
    }

    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());
    }
}
