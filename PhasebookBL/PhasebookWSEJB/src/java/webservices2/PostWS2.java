/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices2;

import entities.Posts;
import interfaces.PostBeanRemote;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import util.XmlManager;

/**
 *
 * @author Nickerson
 */
@WebService
public class PostWS2 {
    
    @WebMethod
    public String listPostsByUserId(String userId) throws Exception {	
        System.out.println("Entrou no WS2 do post");
        InitialContext ctx = new InitialContext();
        PostBeanRemote servico = (PostBeanRemote)ctx.lookup("java:global/PhasebookBL/Posts-ejb/PostBean");
        
        return montarXML(servico.listPost(Integer.parseInt(userId)));
    }
    
    private String montarXML(List<Posts> lista){
        
        StringBuilder str = new StringBuilder("<listaPosts>");
        
        for (Posts p: lista){
            
            str.append("<post>");
            
            str.append("<postID>");
            str.append(p.getIdposts());
            str.append("</postID>");
            str.append("<creationDate>");
            str.append(p.getCreationDate());
            str.append("</creationDate>");
            str.append("<privacy>");
            str.append(p.getPrivacy());
            str.append("</privacy>");
            str.append("<userReceiver>");
            str.append(p.getUserReceiver());
            str.append("</userReceiver>");
            str.append("<userSender>");
            str.append(p.getUserSender());
            str.append("</userSender>");
            str.append("<content>");
            str.append(p.getContent());
            str.append("</content>");
            
            
            str.append("</post>");
          
        }
        
        str.append("</listaPosts>");
        
        return str.toString();
    }
    
}
