package controllers;

import entities.User;
import interfaces.PostBeanRemote;
import interfaces.UserBeanRemote;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.MailClient;

public class ProfileController extends AbstractController {
    
    private UserBeanRemote userBean;
    private PostBeanRemote newPost;
    private User userLoggedIn;
    private User userProfile;
    
    public void viewProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
       
        
        HttpSession session = request.getSession();
        userBean = (UserBeanRemote) getEjbInstance("UserBean");
       
        userLoggedIn = (User) session.getAttribute("login");
        userBean.setUser(userLoggedIn);
       
        userProfile = userBean.getUserById(Integer.parseInt(request.getParameter("id")));

        session.setAttribute("profileUser", userProfile);
        session.setAttribute("profilePosts", userBean.getPostsByID(userProfile.getIduser()));
        session.setAttribute("profileFriends", userBean.getFriendsByID(userProfile.getIduser()));
        if (userBean.isFriend(userProfile.getIduser())) {
            
            session.setAttribute("status", (Character) 'y');
        } else if (userBean.isFriend(userProfile.getIduser())) {
        } else {
            Character status = 'n';
            session.setAttribute("status", status);
        }
        
        response.sendRedirect("/Phasebook-war/jsp/profile.jsp");
    }
    
    public void viewFriends(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        
        HttpSession session = request.getSession();
        userBean = (UserBeanRemote) getEjbInstance("UserBean");
        userLoggedIn = (User) session.getAttribute("login");
        userBean.setUser(userLoggedIn);
        session.setAttribute("friends", userBean.getFriends());
        session.setAttribute("pendingRequests", userBean.getPendingRequests());
        userProfile = userBean.getUserById(Integer.parseInt(request.getParameter("id")));
        session.setAttribute("profileUser", userProfile);
        session.setAttribute("profileFriends", userBean.getFriendsByID(userProfile.getIduser()));
        
        if (userBean.isFriend(userProfile.getIduser())) {
            session.setAttribute("status", (Character) 'y');
        } else if (userBean.isPending(userProfile.getIduser())) {
            session.setAttribute("status", (Character) 'p');
        } else {
            session.setAttribute("status", (Character) 'n');
        }
        response.sendRedirect("/Phasebook-war/jsp/friends.jsp");
        
    }
    
    public void addFriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        
        HttpSession session = request.getSession();
        userBean = (UserBeanRemote) getEjbInstance("UserBean");
        userLoggedIn = (User) session.getAttribute("login");
        userBean.setUser(userLoggedIn);
        userProfile = (User) session.getAttribute("profileUser");
        boolean addFriend = userBean.addFriend(userProfile.getIduser());
        
        if (addFriend){
            this.sendMailRequest(userProfile);
        }
        
        if (userBean.isFriend(userProfile.getIduser())) {
            session.setAttribute("status", (Character) 'y');
        } else if (userBean.isPending(userProfile.getIduser())) {
            session.setAttribute("status", (Character) 'p');
        } else {
            session.setAttribute("status", (Character) 'n');
        }
        session.setAttribute("profileUser", userLoggedIn);
        response.sendRedirect("/Phasebook-war/jsp/pending-requests.jsp");
        
    }
    
    public void acceptRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        
        
        HttpSession session = request.getSession();
        userBean = (UserBeanRemote) getEjbInstance("UserBean");
        
        userLoggedIn = (User) session.getAttribute("login");
        
        userBean.setUser(userLoggedIn);
        
        userProfile = userBean.getUserById(Integer.parseInt(request.getParameter("id")));
        session.setAttribute("profileUser", userProfile);
        
        boolean acceptRequest = userBean.acceptRequest(userProfile.getIduser());
        if (acceptRequest){
            this.sendMailAcceptedRequest(userProfile);
        }
        if (userBean.isFriend(userProfile.getIduser())) {
            session.setAttribute("status", (Character) 'y');
        } else if (userBean.isPending(userProfile.getIduser())) {
            session.setAttribute("status", (Character) 'p');
        } else {
            session.setAttribute("status", (Character) 'n');
        }
        session.setAttribute("friends", userBean.getFriends());
        session.setAttribute("pendingRequests", userBean.getPendingRequests());
        session.setAttribute("profileUser", userLoggedIn);
       
        response.sendRedirect("/Phasebook-war/jsp/pending-requests.jsp");
        
    }
    
    private void sendMailRequest(User destination) {

        String server = "smtp.gmail.com";
        String username = "phasebooknotify";
        String password = "supergay";
        //A enviar email..

        String receiver = destination.getEmail();
        System.out.println("mail:" + receiver);
        String body = "---- Por favor não responda a este email pois foi gerado automaticamente ----\n\n\n"
                + "Ola " + receiver + "\n" + "o utilizador " + userLoggedIn.getName() + " wants to be your friend \n\n\n"
                + "\n\n\n---- Por favor não responda a este email pois foi gerado automaticamente ----";
        try {
            new MailClient().sendMail(username, password, server, receiver, "Novo post no seu mural", body);
            System.out.println("Email enviado!");
        } catch (MessagingException ex) {
            System.out.println("Email não foi enviado!");
        }
    }
    
    private void sendMailAcceptedRequest(User destination) {

        String server = "smtp.gmail.com";
        String username = "phasebooknotify";
        String password = "supergay";
        //A enviar email..

        String receiver = destination.getEmail();
        System.out.println("mail:" + receiver);
        String body = "---- Por favor não responda a este email pois foi gerado automaticamente ----\n\n\n"
                + "Ola " + receiver + "\n" + "o utilizador " + userLoggedIn.getName() + " accepted your friend request \n\n\n"
                + "\n\n\n---- Por favor não responda a este email pois foi gerado automaticamente ----";
        try {
            new MailClient().sendMail(username, password, server, receiver, "Novo post no seu mural", body);
            System.out.println("Email enviado!");
        } catch (MessagingException ex) {
            System.out.println("Email não foi enviado!");
        }
    }
}
