package controllers;

import entities.User;
import interfaces.BetBeanRemote;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BetController extends AbstractController {

    
    private BetBeanRemote betBean;
    private User userLoggedIn;

    public void placeBet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {


        HttpSession session = request.getSession();
        userLoggedIn = (User) session.getAttribute("login");
        String number = request.getParameter("number");
        betBean = (BetBeanRemote) getEjbInstance("BetBean");
        betBean.doBet(Integer.valueOf(number), userLoggedIn);
        response.sendRedirect("/Phasebook-war/jsp/profile.jsp");
    }
}
