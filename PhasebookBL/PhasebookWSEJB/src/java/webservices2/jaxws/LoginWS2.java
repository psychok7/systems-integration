
package webservices2.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://webservices2/", name = "loginWS2")
@XmlType(namespace = "http://webservices2/", name = "loginWS2")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginWS2 {

    
    @XmlElement(namespace = "", name = "arg0")
    private String arg0;
    @XmlElement(namespace = "", name = "arg1")
    private String arg1;

    public String getArg0() {
        return this.arg0;
    }

    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    public String getArg1() {
        return this.arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

}
