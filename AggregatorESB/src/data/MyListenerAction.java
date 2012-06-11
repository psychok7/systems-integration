
package data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.listeners.message.MessageDeliverException;
import org.jboss.soa.esb.message.Message;

public class MyListenerAction extends AbstractActionLifecycle
{

 protected ConfigTree _config;

 public MyListenerAction(ConfigTree config) {
  _config = config; 
 } 

 public Message transform(Message message) throws MessageDeliverException {
  System.out.println("---------------------------------- transform ----------------------------------");
  @SuppressWarnings("unchecked")
  List<String> names = (List<String>) message.getBody().get();
  Set<String> nameset = new HashSet<String>(names);
  message.getBody().add(nameset);
  System.out.println("-------------------------------- end transform --------------------------------");
  return message;
 }

}