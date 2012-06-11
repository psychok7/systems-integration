/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.BetDAO;
import dao.PostDAO;
import dao.UserDAO;
import entities.Bet;
import entities.BetPK;
import entities.Posts;
import entities.User;
import interfaces.BetBeanRemote;
import interfaces.LoteryBeanRemote;
import interfaces.UserBeanRemote;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.naming.InitialContext;

/**
 *
 * @author Nickerson
 */
@Stateless
public class BetBean implements BetBeanRemote{

    private final int USER_ID_LOTERY = 1;
    
    //@Resource javax.ejb.TimerService timerService;
    
    /*@PostConstruct
    public void init(){
       
       System.out.println("TESTE!!!");
       long inicial = (1000 * 3); // 2 seg
       long interval = (1000 * 60 * 4); // 3 min
       timerService.createTimer( inicial, interval,null);
       
    } */   
    
    @Resource private SessionContext context;
    
    public void shareResults(Bet bet) throws Exception{
        
        BetDAO dao = new BetDAO();
        
        UserDAO uDao = new UserDAO();
        
        PostDAO pDao = new PostDAO();
        
        List<Bet> lista = dao.listBetsUnpublished(bet.getBetPK().getIdbet());
        
        User loteryUser = uDao.getUserById(USER_ID_LOTERY);
        
        for (Bet b: lista){
            
            Posts p = new Posts();
            
            p.setCreationDate(new Date());
            
            p.setUserReceiver(bet.getUser());
            
            p.setUserSender(loteryUser);
            
            if (b.getNumber().equals(bet.getNumber())){
                
                p.setContent("Parabéns!! Você acertou na Loteria!");
                
                UserBeanRemote service = (UserBeanRemote) lookupPhasebook("UserBean");
                
                service.atualizarCredito(bet.getUser(), (bet.getUser().getCredit()+50));
                
            } else {
                
                p.setContent("Você não acertou na Loteria! Tente novamente.");
            }
            
            pDao.insertPost(p);
            
        } // for
        
    }
 
    public boolean doBet(Integer number, User user) throws Exception{
        
        BetDAO dao = new BetDAO();
        
        Bet b = new Bet();
        
        b.setBetPK(new BetPK(getIdBet(), user.getIduser()));
        
        b.setNumber(number);
        
        b.setUser(user);
        
        b.setPublished(Boolean.FALSE);
        
        boolean res = dao.insertBet(b);
        
        if (res){
            
            LoteryBeanRemote service = (LoteryBeanRemote) lookupLotery("LoteryBean");
            service.init();
            
        }
        
        return res;
        
    }
    
    private Integer getIdBet() throws Exception {
        
        LoteryBeanRemote service = (LoteryBeanRemote) lookupLotery("LoteryBean");

        return (service.getMaxIdLotery()+1);
        
    }
    
    private Object lookupLotery(String EjbName) throws Exception{
        
        InitialContext ctx = new InitialContext();  
        return ctx.lookup("java:global/Phasebook/Lotery-ejb/" + EjbName);
        
    }

    private Object lookupPhasebook(String EjbName) throws Exception{
        
        InitialContext ctx = new InitialContext();  
        return ctx.lookup("java:global/Phasebook/Phasebook-ejb/" + EjbName);
        
    }
}