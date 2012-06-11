/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;




import entities.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import javax.servlet.http.HttpSession;
import test.artefact.user.UserWS2Service;
import util.XmlManager;

/**
 *
 * @author psychok7
 */
public class UserController extends AbstractController {

    public void register(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String email = request.getParameter("e-mail");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
    //    if(new UserWSService().getUserWSPort().registerWS(email, password,name).equalsIgnoreCase("OK"))
        if(new UserWS2Service().getUserWS2Port().registerWS2(email, password,name).equalsIgnoreCase("OK"))
            response.sendRedirect("/PhasebookWT-war/jsp/login.jsp");
        else
            response.sendRedirect("/PhasebookWT-war/jsp/invaliduser.jsp");
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String email = request.getParameter("e-mail");
        String password = request.getParameter("password");
        
        XmlManager manager=new XmlManager();
                
        //falta meter os getposts e etc no parser
  //      User new_user=manager.ReadUserXmlFile(manager.loadXMLFromString(new UserWSService().getUserWSPort().loginWS(email, password)));
        
        System.out.println(new UserWS2Service().getUserWS2Port().loginWS2(email, password));
        User new_user=manager.ReadUserXmlFile(manager.loadXMLFromString(new UserWS2Service().getUserWS2Port().loginWS2(email, password)));
        
        if (new_user!=null) {

            HttpSession session = request.getSession(true);
            session.setAttribute("login", new_user);
            session.setAttribute("profileUser", new_user);
    //        session.setAttribute("posts", userLoggedIn.getPosts());     // e preciso dizer do lado do ejb k tenho k enviar todos posts e friends e etc tb
     //       session.setAttribute("friends", userLoggedIn.getFriends());
     //       session.setAttribute("pendingRequests", userLoggedIn.getPendingRequests());

            response.sendRedirect("/PhasebookWT-war/jsp/profile.jsp");
            
        } else {
            response.sendRedirect("/PhasebookWT-war/jsp/invaliduser.jsp");
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        request.getSession().removeAttribute("login");
        request.getSession().invalidate();
        response.sendRedirect("/PhasebookWT-war/index.jsp");
    }

    public void viewFriends(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        HttpSession session = request.getSession();
        User userLoggedIn =(User) session.getAttribute("login");        
  //      session.setAttribute("friends", userLoggedIn.getFriends());
        session.setAttribute("profileUser",userLoggedIn);
        response.sendRedirect("/PhasebookWT-war/jsp/friends.jsp");

        
    }
   
}