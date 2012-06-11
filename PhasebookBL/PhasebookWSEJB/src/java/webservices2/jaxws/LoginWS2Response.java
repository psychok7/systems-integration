
package webservices2.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://webservices2/", name = "loginWS2Response")
@XmlType(namespace = "http://webservices2/", name = "loginWS2Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginWS2Response {

    
    @XmlElement(namespace = "", name = "return")
    private String returno;

    public String getReturn() {
        return this.returno;
    }

    public void setReturn(String returno) {
        this.returno = returno;
    }

}
