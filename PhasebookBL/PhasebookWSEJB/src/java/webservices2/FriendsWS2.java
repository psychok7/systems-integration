/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices2;

import entities.Friends;
import interfaces.FriendBeanRemote;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;

/**
 *
 * @author Nickerson
 */
@WebService
public class FriendsWS2 {
    
    @WebMethod
    public String getFriendsByUserId(String userId) throws Exception{
        
        InitialContext ctx = new InitialContext();
        FriendBeanRemote servico = (FriendBeanRemote)ctx.lookup("java:global/PhasebookBL/Friends-ejb/FriendBean");
        
        return montarXML(servico.getFriends(Integer.parseInt(userId)));
        
    }
    
    private String montarXML(List<Friends> lista){
        
        StringBuilder str = new StringBuilder("<listaFriends>");
        
        for (Friends f: lista){
            
            str.append("<friend>");
            
            str.append("<userId>");
            str.append(f.getFriendsPK().getUserIduser());
            str.append("<userId>");
            
            str.append("<userId1>");
            str.append(f.getFriendsPK().getUserIduser1());
            str.append("<userId1>");
            
            str.append("<status>");
            str.append(f.getStatus());
            str.append("<status>");
            
            str.append("</friend>");
        }
        
        
        str.append("</listaFriends>");
        
        return str.toString();
    }
    
}
