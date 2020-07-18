package com.example.services.main;

import com.example.services.servlets.HelloWorld;

// import com.example.services.servlets.HelloWorld;

// import com.sun.net.httpserver.HttpServer;

import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.eclipse.jetty.servlet.ServletHandler;
// import org.eclipse.jetty.webapp.WebAppContext;
// import org.eclipse.jetty.webapp.Configuration.ClassList;
import org.slf4j.LoggerFactory;

// import java.io.IOException;
// import java.io.OutputStream;
// import java.net.InetSocketAddress;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) throws Exception {

    logger.info("Logging INFO with Logback");
    logger.error("Logging ERROR with Logback");

    // System.setProperty("org.eclipse.jetty.util.log.class", "org.eclipse.jetty.util.log.StrErrLog");
    // System.setProperty("org.eclipse.jetty.LEVEL", "INFO");

    // Create a basic Jetty server object that will listen on port defined by
    // the PORT environment variable when present, otherwise on 8080.
    int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
    Server server = new Server(port);

    // The WebAppContext is the interface to provide configuration for a web
    // application. In this example, the context path is being set to "/" so
    // it is suitable for serving root context requests.
    // WebAppContext webapp = new WebAppContext();
    // webapp.setContextPath("/");

    ServletHandler handler = new ServletHandler();
    server.setHandler(handler);
    handler.addServletWithMapping(HelloWorld.class, "/hello");

    // // webapp.setWar(args[0]);
    // ClassList classlist = ClassList.setServerDefault(server);

    // // Enable Annotation Scanning.
    // classlist.addBefore(
    //     "org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
    //     "org.eclipse.jetty.annotations.AnnotationConfiguration");

    // Set the the WebAppContext as the ContextHandler for the server.
    //server.setHandler(webapp);

    // Start the server! By using the server.join() the server thread will
    // join with the current thread. See
    // "http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.html#join()"
    // for more details.
    server.start();
    server.join();
  }
}