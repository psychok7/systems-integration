package controllers;

import entities.User;
import interfaces.SearchBeanRemote;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchController extends AbstractController {

    private SearchBeanRemote search;

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        HttpSession session = request.getSession();
        search = (SearchBeanRemote) getEjbInstance("SearchBean");
        String value = (String) request.getParameter("search-people");
        List<User> list = search.searchPeople(value);

        if (list != null) {
            session.setAttribute("query", value);
            session.setAttribute("list-results", list);
            response.sendRedirect("/Phasebook-war/jsp/search-results.jsp");
        }


    }
}
