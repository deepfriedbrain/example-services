package com.example.services.servlets;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.logging.Logger;

//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "HelloWorld", value = "/hello")
public class HelloWorld extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 7032595359064642923L;

    private static final Logger logger = Logger.getLogger(HelloWorld.class.getName());

    @Override
    protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException {

        logger.info("Hello World");
        response.setStatus(HttpURLConnection.HTTP_OK);
        return;
    }
}