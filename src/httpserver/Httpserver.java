/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpserver;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;

/**
 *
 * @author Hermite
 */
public class Httpserver {
    private static int HTTP_NB_THREAD = 5;
    private static String HTTP_NB_THREADS;
    private static int HTTP_SERVER_PORT = 9000;

    /**
     * @param args the command line arguments
     */
   
        
     private static void startServer() throws Exception
     {
      final ExecutorService pool = Executors.newFixedThreadPool(HTTP_NB_THREAD);
      Handler handler = new AbstractHandler() {

             @Override
             public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException {
                 request.setCharacterEncoding("UTF-8");
                 //recuperer le parametre reqe q=
                 //traiter la requete dans un callable pool.sbmit(..)
                 //recuperer le resultar via un futre
                 
                 ((Request) request).setHandled(true);
                 
             }
         };   
         System.out.println("....Starting http server with" + HTTP_NB_THREADS + "threads");
         Server httpServer = new Server(HTTP_SERVER_PORT);
         httpServer.setHandler(handler);
         httpServer.start();
         System.out.println("....done,waiting for request on " + HTTP_SERVER_PORT + " port");
         httpServer.join();
        
     }
     
   public static void main(String[] arg) {
        try {
            startServer();
        } catch (Exception e) {
            System.err.println("error starting server" + e.getMessage());
            System.exit(1);
        }
       
       
   }
    
     
     
 }
