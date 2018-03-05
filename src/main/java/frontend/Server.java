package frontend;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;

public class Server extends HttpServlet {
    public static void main(String[] args) throws Exception {


        Frontend frontend = new Frontend();
        ServletContextHandler sC = new ServletContextHandler(ServletContextHandler.SESSIONS);
        sC.addServlet(new ServletHolder(frontend), "/mirror");

        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8080);
        server.setHandler(sC);
        server.start();
        System.out.println("Server started");
        server.join();
    }
}
