package ejb;

import dao.PostDAO;
import entities.Posts;
import entities.User;
import interfaces.PostBeanRemote;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PostBean implements PostBeanRemote {

    @Override
    public boolean insertPost(Posts post, User sender, User receiver) {
        post.setUserSender(sender);
        post.setUserReceiver(receiver);
        return new PostDAO().insertPost(post);
        
    }

    @Override
    public List<Posts> listPost(int idUser) {
        return new PostDAO().listPost(idUser);
    }
}
