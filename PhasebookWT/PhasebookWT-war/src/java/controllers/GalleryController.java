//package controllers;
//
//import entities.User;
//import interfaces.UserBeanRemote;
//
//import java.io.File;
//import java.util.Iterator;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileItemFactory;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
//public class GalleryController extends AbstractController {
//
//    private UserBeanRemote user;
//    private User userLoggedIn;
//    private String dir = "media";
//
//    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
////            String email = request.getParameter("e-mail");
////            String password = request.getParameter("password");
////
////            user = (UserBeanRemote) getEjbInstance("UserBean");
////
////            if (user.authenticate(email, password)) {
////                HttpSession session = request.getSession(true);
////                session.setAttribute("user", user);
////                session.setAttribute("my_name", user.getUsername());
////                response.sendRedirect("/Phasebook-war/jsp/profile.jsp");
////            } else {
////                response.sendRedirect("/Phasebook-war/index.jsp");
////            }
//    }
//
//    public void upload(HttpServletRequest request, HttpServletResponse response) {
//        userLoggedIn = (User) request.getSession().getAttribute("login");
//        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//        if (!isMultipart) {
//            System.out.println("type " + request.getContentType());
//            return;
//        }
//
//
//        try {
//            Picture pic = new Picture();
//            user = (UserBeanRemote) getEjbInstance("UserBean");
//            if (user == null) {
//                System.out.println("No user setted");
//                return;
//            }
//
//            FileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload sfu = new ServletFileUpload(factory);
//            try {
//                Boolean profile = false;
//                Boolean file_selected = false;
//                FileItem file = null;
//
//                List items = sfu.parseRequest(request);
//                Iterator iter = items.iterator();
//
//                while (iter.hasNext()) {
//                    FileItem item = (FileItem) iter.next();
//                    if (item.isFormField()) {
//                        if (item.getFieldName().equalsIgnoreCase("title")) {
//                            pic.setTitle(item.getString());
//                        } else if (item.getFieldName().equalsIgnoreCase("profile")) {
//                            if (item.getString().equalsIgnoreCase("on")) {
//                                pic.setProfile(true);
//                            }
//                        }
//
//                    } else {
//                        if (item.getFieldName().equalsIgnoreCase("file")) {
//                            String source = item.getName();
//                            String pattern = "(.*?).(jpg|png|gif|bmp)";
//                            Pattern p;
//                            Matcher m;
//
//                            p = Pattern.compile(pattern);
//                            m = p.matcher(source);
//
//                            if (m.find()) {
//                                System.out.println("file type:" + item.getName());
//                                file_selected = true;
//
//                            } else {
//                                System.out.println("Invalid file type");
//                            }
//                        }
//                        pic.setItem(item);
//                    }
//                }
//                if (file_selected) {
//                    String uri = writeFile(pic, user);
//                    if (!uri.isEmpty()) {
//                        pic.setUri(uri);
//                      //  showPicture(pic);
//                       
//                       request.getSession().setAttribute("photo", pic.getItem());
//                       response.sendRedirect("/Phasebook-war/jsp/upload-photo.jsp");
//                    }
//                    else{
//                       //request.getSession().setAttribute("photo", null);
//                       response.sendRedirect("/Phasebook-war/jsp/upload-photo.jsp");
//                    }
//                }
//                else{
//                     System.out.println("Invalid file type or file not selected");
//                }
//
//            } catch (FileUploadException e) {
//                e.toString();
//            }
//        } catch (Exception ex) {
//            ex.toString();
//        }
//    }
//
//    private String writeFile(Picture pic, UserBeanRemote user) {
//        
//        if (pic.getItem() != null) {
//            
//            System.out.println("User " + userLoggedIn.getName());
//            String destination = dir + File.separator + userLoggedIn.getIduser() + File.separator;
//            
//            Boolean mkdirs = new File(destination).mkdirs(); 
//            System.out.println(mkdirs);
//            if (pic.getProfile()) {
//                destination += "profile" + File.separator;
//                 
//                mkdirs = new File(destination).mkdirs();
//                destination += "user.jpg";
//            } else {
//                destination += "album" + File.separator;
//                 
//                mkdirs = new File(destination).mkdirs();
//                if (!pic.getTitle().isEmpty()) {
//                    destination += pic.getTitle() + ".jpg";
//                }
//            }
//            try {
//                
//                File file = new File(destination);
//                pic.getItem().write(file);
//                System.out.println("File at: " + file.getAbsolutePath());
//                return destination;
//
//            } catch (Exception ex) {
//                System.out.println("Exception, no write!");
//                ex.toString();
//            }
//        }
//        return "";
//    }
//
//    private void showPicture(Picture pic) {
//    }
//
//    private class Picture {
//
//        private String title;
//        private String uri;
//        private Boolean profile;
//        private FileItem item;
//
//        private Picture() {
//            this.profile = false;
//            this.title = "";
//        }
//
//        public Boolean getProfile() {
//            return profile;
//        }
//
//        public void setProfile(Boolean profile) {
//            this.profile = profile;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public FileItem getItem() {
//            return item;
//        }
//
//        public void setItem(FileItem item) {
//            this.item = item;
//        }
//
//        public String getUri() {
//            return uri;
//        }
//
//        public void setUri(String uri) {
//            this.uri = uri;
//        }
//    }
//}
