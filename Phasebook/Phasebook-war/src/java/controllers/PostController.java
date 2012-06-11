package controllers;

import entities.Posts;
import entities.User;
import interfaces.PostBeanRemote;
import interfaces.UserBeanRemote;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import util.MailClient;

public class PostController extends AbstractController {

    private UserBeanRemote userBean;
    private PostBeanRemote newPost;
    private User userLoggedIn;
    private User userProfile;

    public void sharePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        HttpSession session = request.getSession();
        System.out.println("SHARE POST!!!!!");
        
        
        FileItem pic = this.uploadPhoto(request);       //returns null if no file!
        
        this.parsePost(request);
        

        userBean = (UserBeanRemote) getEjbInstance("UserBean");
        userBean.setUser((User) session.getAttribute("login"));
        userLoggedIn = (User) userBean.getUser();
        userProfile = userBean.getUserById(Integer.parseInt(request.getParameter("id")));

        newPost = (PostBeanRemote) getEjbInstance("PostBean");
        Posts post = parsePost(request);

        if (newPost.insertPost(post, userLoggedIn, userProfile)) {
            sendMail(userProfile, post.getContent());
            List<Posts> list = (List<Posts>)userBean.getPostsByID(userProfile.getIduser());
            for (int i=0;i<list.size();i++){
                System.out.println("Content " + list.get(i).getContent());
            }
            if (userLoggedIn.getIduser()==userProfile.getIduser()){
                session.setAttribute("posts", userBean.getPosts());
            }
            session.setAttribute("profilePosts", userBean.getPostsByID(userProfile.getIduser()));
            response.sendRedirect("/Phasebook-war/jsp/profile.jsp");
        } else {
            
            System.out.println("ERRO");
            response.sendRedirect("/Phasebook-war/index.jsp");
        }
    }

    private FileItem uploadPhoto(HttpServletRequest request) {
         System.out.println("IS MULTIPART DATA!!!!!");
        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (!isMultipart) {
                System.out.println("type " + request.getContentType());
                return null;
            }
            System.out.println("IS MULTIPART DATA!!!!!");
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(factory);

            Boolean valid = false;
            Boolean checked = false;
            List items = (List) sfu.parseRequest(request);
            FileItem pic = null;
            Iterator iterator = items.iterator();

            while (iterator.hasNext()) {
                FileItem item = (FileItem) iterator.next();
                if (!item.isFormField()) {
                    pic = item;
                } else {
                    if (item.getFieldName().equalsIgnoreCase("attach-image")) {
                        if (item.getString().equalsIgnoreCase("on")) {
                            System.out.println("Image!!!! checked!!!!!!!!!!!!!!!!!!");
                            checked = true;
                        }
                        else{
                            System.out.println("Image!!!! NOOOOOOOOOOO checked!!!!!!!!!!!!!!!!!!");
                        }
                    }
                    System.out.println("HERE!!!");
                }
                 
                if (pic != null) {
                    if (pic.getFieldName().equalsIgnoreCase("file")) {
                        String source = item.getName();
                        String pattern = "(.*?).(jpg|png|gif|bmp)";
                        Pattern p;
                        Matcher m;

                        p = Pattern.compile(pattern);
                        m = p.matcher(source);

                        if (m.find()) {
                            System.out.println("file type:" + item.getName());
                            valid = true;

                        } else {
                            System.out.println("Invalid file type");
                            valid = false;
                        }
                    }
                }

                if (pic != null && valid && checked) {
                    return pic;
                }
                return null;
            }

        } catch (FileUploadException ex) {
            Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    private Posts parsePost(HttpServletRequest request) {
        Posts post = new Posts();
        post.setContent(request.getParameter("post_msg"));
        post.setCreationDate(new java.util.Date());
        if (request.getParameter("privacy").equals("1")) {
            post.setPrivacy(false); //public
        } else {
            post.setPrivacy(true); //private
        }
        return post;
    }

    private void sendMail(User destination, String content) {

        String server = "smtp.gmail.com";
        String username = "phasebooknotify";
        String password = "supergay";
        //A enviar email..

        String receiver = destination.getEmail();
        System.out.println("mail:" + receiver);
        String body = "---- Por favor não responda a este email pois foi gerado automaticamente ----\n\n\n"
                + "Ola " + receiver + "\n" + "o utilizador " + userLoggedIn.getName() + " comentou no seu mural: \n\n\n" + content
                + "\n\n\n---- Por favor não responda a este email pois foi gerado automaticamente ----";
        try {
            new MailClient().sendMail(username, password, server, receiver, "Novo post no seu mural", body);
            System.out.println("Email enviado!");
        } catch (MessagingException ex) {
            System.out.println("Email não foi enviado!");
        }
    }

    public List listPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        userLoggedIn = (User) request.getSession().getAttribute("login");
        PostBeanRemote postBean = (PostBeanRemote) getEjbInstance("PostBean");
        return (List) postBean.listPost(userLoggedIn.getIduser());

    }
}
