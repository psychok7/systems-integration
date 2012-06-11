package webservices2;

import entities.User;
import interfaces.AuthenticationBeanRemote;

import interfaces.UserBeanRemote;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import util.XmlManager;




@WebService
public class UserWS2 {

	private static String WEBUSER_XML = "./user-jaxb.xml";
	
	@WebMethod
	public String loginWS2(String email,String password) throws Exception {			

        InitialContext ctx = new InitialContext();
        AuthenticationBeanRemote user= (AuthenticationBeanRemote)ctx.lookup("java:global/PhasebookBL/Authentication-ejb/AuthenticationBean");
        
        if(user.authenticate(email, password)){           
            XmlManager manager= new XmlManager();
            manager.marshall(user.getUser());
		return manager.convertXMLFileToString(WEBUSER_XML);
        } 

	else	
            return "ERROR in authentication";
		
	}
	@WebMethod
	public String registerWS2(String email,String password,String name) throws Exception {	
		
            InitialContext ctx = new InitialContext();
            UserBeanRemote user= (UserBeanRemote)ctx.lookup("java:global/PhasebookBL/User-ejb/UserBean");

            if(user.register(name,email, password))
               return "OK";
           
		
            return "ERROR CREATING NEW USER";
		
	}
	
        public String getUserById(String userId) throws Exception {
            
            InitialContext ctx = new InitialContext();
            UserBeanRemote user= (UserBeanRemote)ctx.lookup("java:global/PhasebookBL/User-ejb/UserBean");
            
            User u = user.getUserById(Integer.parseInt(userId));
            
            StringBuilder str = new StringBuilder("<user>");
            str.append("<userId>");
            str.append(u.getIduser());
            str.append("</userId>");
            
            str.append("<userName>");
            str.append(u.getName());
            str.append("</userName>");
            
            str.append("<userEmail>");
            str.append(u.getEmail());
            str.append("</userEmail>");
            
            str.append("<userCredit>");
            str.append(u.getCredit());
            str.append("</userCredit>");
            
            str.append("</user>");
            
            return str.toString();
            
        }
        
//	  private Context getInitialContext() throws Exception {
//	         Properties properties = null;
//	        try {
//	          properties = new Properties();
//	          properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
//	          properties.put("java.naming.provider.url","localhost:1099");
//	          properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
//	        }
//	        catch (Exception ex) {
//	           System.out.println(ex.getMessage());
//	        }
//	    return new InitialContext(properties);
//	   }
	
}
