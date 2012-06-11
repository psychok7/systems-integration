/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import client.artefact.UserWSService;
import interfaces.UserBeanRemote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.IOException;

/**
 *
 * @author psychok7
 */
public class UserController extends AbstractController {

    private UserBeanRemote userBean;
    private static final String WEBUSER_XML = "./webuser-jaxb.xml";

    public void register(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String email = request.getParameter("e-mail");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        userBean = (UserBeanRemote) getEjbInstance("UserBean");

        if (userBean.register(name, email, password)) {
            response.sendRedirect("/Phasebook-war/jsp/login.jsp");
        } else {
            response.sendRedirect("/Phasebook-war/jsp/invaliduser.jsp");
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String email = request.getParameter("e-mail");
        String password = request.getParameter("password");
        
        System.out.println(new UserWSService().getUserWSPort().loginWS(email, password));
        
        
        
        
//        userBean = (UserBeanRemote) getEjbInstance("UserBean");
//
//        if (userBean.authenticate(email, password)) {
//
//            HttpSession session = request.getSession(true);
//            User userLoggedIn = (User) userBean.getUser();
//            session.setAttribute("login", userLoggedIn);
//            session.setAttribute("profileUser", userLoggedIn);
//            session.setAttribute("posts", userBean.getPosts());
//            session.setAttribute("friends", userBean.getFriends());
//            session.setAttribute("pendingRequests", userBean.getPendingRequests());
//
//            response.sendRedirect("/Phasebook-war/jsp/profile.jsp");
//        } else {
//            response.sendRedirect("/Phasebook-war/jsp/invaliduser.jsp");
//        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        request.getSession().removeAttribute("login");
        request.getSession().invalidate();
        response.sendRedirect("/Phasebook-war/index.jsp");
    }

    public void viewFriends(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        HttpSession session = request.getSession();
        session.setAttribute("friends", userBean.getFriends());
        session.setAttribute("profileUser",userBean.getUser());
        response.sendRedirect("/Phasebook-war/jsp/friends.jsp");

        
    }
    
//    public Marshaller marshall(WebUser webuser) throws JAXBException, IOException{
//        
//        	JAXBContext context = JAXBContext.newInstance(WebUser.class);
//		Marshaller m = context.createMarshaller();
//		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//		m.marshal(webuser, System.out);
//
//		Writer w = null;
//		try {
//			w = new FileWriter(WEBUSER_XML);
//			m.marshal(webuser, w);
//		} finally {
//			try {
//				w.close();
//			} catch (Exception e) {
//			}
//		}
//                
//                return m;
//        
//        
//    }
//    
//        public WebUser unmarshall(Marshaller webuser) throws JAXBException, IOException{        
//        	System.out.println("Output from our XML File: ");
//                JAXBContext context = JAXBContext.newInstance(WebUser.class);
//		Unmarshaller um = context.createUnmarshaller();
//                System.out.println((WebUser) um.unmarshal(new FileReader(WEBUSER_XML)));
//		return (WebUser) um.unmarshal(new FileReader(WEBUSER_XML));
//        
//        
//    }
}
