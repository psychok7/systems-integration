
package controllers;

import entities.User;
import interfaces.UserBeanRemote;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EditController extends AbstractController {
    
        private UserBeanRemote user;
        
        public void processRequest(HttpServletRequest request, HttpServletResponse response)throws Exception {
                
        String email = request.getParameter("e-mail");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        user = (UserBeanRemote) getEjbInstance("UserBean");
        HttpSession session = request.getSession();
        
        
        if(user.edit(name,email, password,(User)session.getAttribute("login"))){
            session.setAttribute("login", user.getUser());
            session.setAttribute("profileUser", user.getUser());
            response.sendRedirect("/Phasebook-war/jsp/profile.jsp");
        }
        else
            response.sendRedirect("/Phasebook-war/jsp/invaliduser.jsp");


    }
}
