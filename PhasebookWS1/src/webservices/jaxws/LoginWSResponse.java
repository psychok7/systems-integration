
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://webservices/", name = "loginWSResponse")
@XmlType(namespace = "http://webservices/", name = "loginWSResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginWSResponse {

    @XmlElement(namespace = "", name = "return")
    private String returno;

    public String getReturn() {
        return this.returno;
    }

    public void setReturn(String returno) {
        this.returno = returno;
    }

}
