
package controllers;


import javax.naming.InitialContext;


public class AbstractController {
    
    public Object getEjbInstance(String EjbName) throws Exception{
        
        InitialContext ctx = new InitialContext();  
        return ctx.lookup("java:global/Phasebook/Phasebook-ejb/" + EjbName);
        
    }
    
    public Object getEjbInstance(String EjbName, String project, String module) throws Exception{
        
        InitialContext ctx = new InitialContext();  
        return ctx.lookup("java:global/"+ project + "/" + module + "/" + EjbName);
        
    }        
            
}
