//package controllers;
//
//
//
//import client.artefact.UserWSService;
//import java.util.List;
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class PostController extends AbstractController {
//
//    public void sharePost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, Exception {
//
//        
//    }
//
////    private FileItem uploadPhoto(HttpServletRequest request) {
////         System.out.println("IS MULTIPART DATA!!!!!");
////        try {
////            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
////            if (!isMultipart) {
////                System.out.println("type " + request.getContentType());
////                return null;
////            }
////            System.out.println("IS MULTIPART DATA!!!!!");
////            FileItemFactory factory = new DiskFileItemFactory();
////            ServletFileUpload sfu = new ServletFileUpload(factory);
////
////            Boolean valid = false;
////            Boolean checked = false;
////            List items = (List) sfu.parseRequest(request);
////            FileItem pic = null;
////            Iterator iterator = items.iterator();
////
////            while (iterator.hasNext()) {
////                FileItem item = (FileItem) iterator.next();
////                if (!item.isFormField()) {
////                    pic = item;
////                } else {
////                    if (item.getFieldName().equalsIgnoreCase("attach-image")) {
////                        if (item.getString().equalsIgnoreCase("on")) {
////                            System.out.println("Image!!!! checked!!!!!!!!!!!!!!!!!!");
////                            checked = true;
////                        }
////                        else{
////                            System.out.println("Image!!!! NOOOOOOOOOOO checked!!!!!!!!!!!!!!!!!!");
////                        }
////                    }
////                    System.out.println("HERE!!!");
////                }
////                 
////                if (pic != null) {
////                    if (pic.getFieldName().equalsIgnoreCase("file")) {
////                        String source = item.getName();
////                        String pattern = "(.*?).(jpg|png|gif|bmp)";
////                        Pattern p;
////                        Matcher m;
////
////                        p = Pattern.compile(pattern);
////                        m = p.matcher(source);
////
////                        if (m.find()) {
////                            System.out.println("file type:" + item.getName());
////                            valid = true;
////
////                        } else {
////                            System.out.println("Invalid file type");
////                            valid = false;
////                        }
////                    }
////                }
////
////                if (pic != null && valid && checked) {
////                    return pic;
////                }
////                return null;
////            }
////
////        } catch (FileUploadException ex) {
////            Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
////
////        }
////        return null;
////    }
//
//    public List listPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, Exception {
//
//        //Integer user = ((User) request.getSession().getAttribute("login")).getIduser();
//        
//        //System.out.println(new UserWSService().getUserWSPort().listPostsByUserId(user.getIduser().toString()));
//        
//        System.out.println(new UserWSService().getUserWSPort().listPostsByUserId("1"));
//        
//        return null;//(List) postBean.listPost(user.getIduser());
//
//    }
//}
