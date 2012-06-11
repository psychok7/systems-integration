/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices2;

import entities.User;
import interfaces.FriendBeanRemote;
import interfaces.UserBeanRemote;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.naming.InitialContext;
import util.XmlManager;

/**
 *
 * @author psychok7
 */
@WebService
public class FriendWS2 {
    
    @WebMethod    
    public String addFriend(String userLoggedIn,String Iduser)  throws Exception  {
        
        InitialContext ctx = new InitialContext();
        UserBeanRemote user= (UserBeanRemote)ctx.lookup("java:global/PhasebookBL/User-ejb/UserBean");
        
        XmlManager manager=new XmlManager();
        User new_user=manager.ReadUserXmlFile(manager.loadXMLFromString(userLoggedIn));
        
        user.setUser(new_user);
        
        if(user.addFriend(Integer.parseInt(Iduser)))
            return "isFriend";
        else if(user.isPending(Integer.parseInt(Iduser)))    
            return "isPending";
        else
            return "noFriend";
        
    }
    
}
