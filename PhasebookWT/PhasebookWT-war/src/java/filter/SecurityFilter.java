//
//package filter;
//
//import entities.User;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//public class SecurityFilter implements Filter{
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {}
//
//    private final String[] publicos = new String[]{"login.jsp", "register.jsp", "index.jsp"};
//    
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        
//        HttpServletRequest req = (HttpServletRequest) request;  
//        HttpServletResponse res = (HttpServletResponse) response;  
//        
//        String func = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
//        
//        List<String> lista = Arrays.asList(publicos);
//        
//        HttpSession session = req.getSession();  
//        User user = (User) session.getAttribute("login");  
//        if(user==null && !lista.contains(func)){  
//            //res.sendRedirect("/Phasebook-war/jsp/login.jsp"); 
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Phasebook-war/jsp/login.jsp");
//            requestDispatcher.forward(request,response);
//        }  
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        //throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//       
//    
//}
