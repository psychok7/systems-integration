package data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jboss.internal.soa.esb.addressing.helpers.EPRHelper;
import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.addressing.EPR;
import org.jboss.soa.esb.addressing.eprs.LogicalEPR;
import org.jboss.soa.esb.client.ServiceInvoker;
import org.jboss.soa.esb.couriers.Courier;
import org.jboss.soa.esb.couriers.CourierFactory;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.listeners.message.MessageDeliverException;
import org.jboss.soa.esb.message.Message;
import org.jboss.soa.esb.message.format.MessageFactory;
import org.jboss.soa.esb.message.format.MessageType;

import client.artefact.friends.FriendsWS2Service;
import client.artefact.posts.PostWS2Service;
import client.artefact.user.Exception_Exception;
import client.artefact.user.UserWS2Service;


public class MyListenerAction extends AbstractActionLifecycle {

	protected ConfigTree _config;

	public MyListenerAction(ConfigTree config) {
		_config = config;
	}

	public Message redirect_login(Message message) throws MessageDeliverException {
		System.out.println("---------------------------------- redirect login ----------------------------------");
		@SuppressWarnings("unchecked")
		ArrayList<String> user = (ArrayList<String>) message.getBody().get();
		ArrayList<String> temp=new ArrayList <String>();

		try {
			//System.out.println(new UserWS2Service().getUserWS2Port().loginWS2(user.get(0), user.get(1)));			
			temp.add(new UserWS2Service().getUserWS2Port().loginWS2(user.get(0), user.get(1)));
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		message.getBody().add(temp);
		System.out.println("-------------------------------- end transform --------------------------------");
		return message;
	}

	public Message redirect_register(Message message) throws MessageDeliverException {
		System.out.println("---------------------------------- redirect register ----------------------------------");
		@SuppressWarnings("unchecked")
		ArrayList<String> user = (ArrayList<String>) message.getBody().get();
		ArrayList<String> temp=new ArrayList <String>();

		try {
			//System.out.println(new UserWS2Service().getUserWS2Port().loginWS2(user.get(0), user.get(1)));			
			temp.add(new UserWS2Service().getUserWS2Port().registerWS2(user.get(0), user.get(1),user.get(2)));
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		message.getBody().add(temp);
		System.out.println("-------------------------------- end transform --------------------------------");
		return message;
	}

	public Message redirect_post(Message message)
			throws MessageDeliverException {

		return message;
	}

	public Message list_post(Message message)
			throws MessageDeliverException {
		
		System.out.println("Entrou no ESB da lista");
		
		String user = (String)message.getBody().get("userId");
		
		String resultado = "";
		
		try {
			System.out.println("vai chamar o WS dos Posts: " + user);
			resultado = (new PostWS2Service().getPostWS2Port().listPostsByUserId(user));
			
		} catch (client.artefact.posts.Exception_Exception e) {
			e.printStackTrace();
		}
		
		//Message esbMessage = MessageFactory.getInstance().getMessage(MessageType.JAVA_SERIALIZED);
		message.getBody().add("posts", resultado);
		
		LogicalEPR lepr = new LogicalEPR(message.getHeader().getCall().getReplyTo());
		ServiceInvoker si = lepr.getServiceInvoker();
		si.deliverAsync(message);
		
		System.out.println("retornou do ws da lista: " + message.toString());
		
		return message;
	}

	public Message redirect_searchPeople(Message message)
			throws MessageDeliverException {

		return message;
	}

	public Message redirect_addFriends(Message message) throws MessageDeliverException {

		return message;
	}

	public Message getUser(Message message) throws Exception{
		
		String userId = (String)message.getBody().get("userId");		
		String resultado = "";
		
		System.out.println("Entrou no esb do User");
		
		try {
			
			resultado = new UserWS2Service().getUserWS2Port().getUserById(userId);
			
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		message.getBody().add("user", resultado);
		
		 /*String xmlEPR = EPRHelper.toXMLString(message.getHeader().getCall().getReplyTo());
		 message.getBody().add("replyToAddress", xmlEPR);*/
		
		LogicalEPR lepr = new LogicalEPR(message.getHeader().getCall().getReplyTo());
		ServiceInvoker si = lepr.getServiceInvoker();
		si.deliverAsync(message);
		
		System.out.println("Saiu no esb do User: " + resultado);
		
		return message;
	}
	
	public Message getFriendsByUserId(Message message) throws Exception{
		
		String userId = (String)message.getBody().get("userId");		
		String resultado = "";
		
		System.out.println("entrou no esb dos friends");
		
		try {
			
			resultado = new FriendsWS2Service().getFriendsWS2Port().getFriendsByUserId(userId);
			
		} catch (client.artefact.friends.Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		message.getBody().add("friends", resultado);
		
		System.out.println(message);
		
		System.out.println("saiu no esb dos friends");
		
		/*EPR jmsepr = message.getHeader().getCall().getReplyTo();
		message.getHeader().getCall().setTo(jmsepr);

		Courier courier = CourierFactory.getCourier(jmsepr);
		courier.deliver(message);
		courier.cleanup();*/
		
		return message;
	}
	
	//jBPM metodo
	 public Message hello(Message message) {
		  System.out.println("---------------------------------- hello ----------------------------------");
		  String who = (String) message.getBody().get("whoami");
		  String textinbody = (String) message.getBody().get();
		  message.getBody().add("Hello " + who + ". You said: " + textinbody);
		  System.out.println("Hello " + who + ". You said: " + textinbody);
		  System.out.println("-------------------------------- end hello --------------------------------");
		  return message;
	 }	
	
}