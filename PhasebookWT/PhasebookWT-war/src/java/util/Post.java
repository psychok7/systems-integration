/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
    

@XmlRootElement(name = "posts")
public class Post {
    
    private Integer idposts;
    private String content;
    private Boolean privacy;
    private Date creationDate;
    
    
    public Post(){
        
    }

    /**
     * @return the idposts
     */
    public Integer getIdposts() {
        return idposts;
    }

    /**
     * @param idposts the idposts to set
     */
    public void setIdposts(Integer idposts) {
        this.idposts = idposts;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the privacy
     */
    public Boolean getPrivacy() {
        return privacy;
    }

    /**
     * @param privacy the privacy to set
     */
    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
}
