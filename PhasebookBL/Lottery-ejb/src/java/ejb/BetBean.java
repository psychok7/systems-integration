/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.BetDAO;
import entities.Bet;
import entities.BetPK;
import interfaces.BetBeanRemote;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;


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
    
    //@Resource private SessionContext context;
    
    public boolean doBet(Integer number, Integer userId, Integer betId) throws Exception{
        
        BetDAO dao = new BetDAO();
        
        Bet b = new Bet();
        
        b.setBetPK(new BetPK(betId, userId));
        
        b.setNumber(number);
        
        b.setPublished(Boolean.FALSE);
        
        boolean res = dao.insertBet(b);        
        return res;
        
    }
    
    public List<Bet> listBetsUnpublished(Integer betId){
        
        return new BetDAO().listBetsUnpublished(betId);
        
    }   
}