
package webservices2.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://webservices2/", name = "Exception")
@XmlType(namespace = "http://webservices2/", name = "Exception", propOrder = {
    "message"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class ExceptionBean {

    
    @XmlElement(namespace = "", name = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
