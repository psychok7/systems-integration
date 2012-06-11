package webservices;

import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.jboss.soa.esb.message.Message;
import org.jboss.soa.esb.message.format.MessageFactory;
import org.jboss.soa.esb.message.format.MessageType;
import org.jboss.soa.esb.client.ServiceInvoker;



@WebService
public class UserWS {

	@WebMethod
	public String loginWS(String username, String password) throws Exception {
	
		  // Setting the ConnectionFactory such that it will use scout
		  System.setProperty("javax.xml.registry.ConnectionFactoryClass","org.apache.ws.scout.registry.ConnectionFactoryImpl");
		  ArrayList<String> user=new ArrayList <String>();
		  user.add(username);
		  user.add(password);
		  
		  Message esbMessage = MessageFactory.getInstance().getMessage(MessageType.JAVA_SERIALIZED);
		  esbMessage.getBody().add(user);

		  ServiceInvoker si = new ServiceInvoker("PhasebookESB_Service_Login", "login");
		  
		  
		  Message retMessage = si.deliverSync(esbMessage, 20000L);
		  
		  ArrayList<String> temp= (ArrayList<String>) retMessage.getBody().get();

		return temp.get(0);
		
	}
	@WebMethod
	public String registerWS(String username, String password, String name) throws Exception {
	
		  // Setting the ConnectionFactory such that it will use scout
		  System.setProperty("javax.xml.registry.ConnectionFactoryClass","org.apache.ws.scout.registry.ConnectionFactoryImpl");
		  
		  ArrayList<String> user=new ArrayList <String>();
		  user.add(username);
		  user.add(password);
		  user.add(name);
		  
		  Message esbMessage = MessageFactory.getInstance().getMessage(MessageType.JAVA_SERIALIZED);
		  esbMessage.getBody().add(user);

		  ServiceInvoker si = new ServiceInvoker("PhasebookESB_Service_Register", "register");
		  
		  Message retMessage = si.deliverSync(esbMessage, 20000L);
		  
		  ArrayList<String> temp= (ArrayList<String>) retMessage.getBody().get();

		return temp.get(0);
		
	}
	@WebMethod
	public String postWS(String post,String sender,String receiver) throws Exception {
	
		  
		
		return "OK";
		
	}
	
	@WebMethod
	public String listPostsByUserId(String userId) throws Exception {
		
		System.out.println("Entrou no metodo list");
		
		Message esbMessage = MessageFactory.getInstance().getMessage(MessageType.JAVA_SERIALIZED);
		esbMessage.getBody().add("id", userId);

		ServiceInvoker si = new ServiceInvoker("PhasebookESB_Service_ListPost", "listpost");
		  
		  
		Message retMessage = si.deliverSync(esbMessage, 30000L);

		
		return (String)retMessage.getBody().get("resultado");
	}
	
	@WebMethod
	public String searchPeopleWS(String value) throws Exception {
	
		  
		
		return "OK";
		
	}
	@WebMethod
	public String addFriendsWS(String userLoggedIn , String Iduser) throws Exception {
		  // Setting the ConnectionFactory such that it will use scout
		  System.setProperty("javax.xml.registry.ConnectionFactoryClass","org.apache.ws.scout.registry.ConnectionFactoryImpl");
		  
		  ArrayList<String> user=new ArrayList <String>();
		  user.add(userLoggedIn);
		  user.add(Iduser);
		  
		  Message esbMessage = MessageFactory.getInstance().getMessage(MessageType.JAVA_SERIALIZED);
		  esbMessage.getBody().add(user);

		  ServiceInvoker si = new ServiceInvoker("PhasebookESB_Service_Register", "register");
		  
		  Message retMessage = si.deliverSync(esbMessage, 20000L);
		  
		  ArrayList<String> temp= (ArrayList<String>) retMessage.getBody().get();

		return temp.get(0);
		
	}
	
}
