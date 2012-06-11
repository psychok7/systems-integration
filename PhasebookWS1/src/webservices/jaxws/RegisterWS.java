
package webservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://webservices/", name = "registerWS")
@XmlType(namespace = "http://webservices/", name = "registerWS")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegisterWS {

    @XmlElement(namespace = "", name = "arg0")
    private String arg0;
    @XmlElement(namespace = "", name = "arg1")
    private String arg1;
    @XmlElement(namespace = "", name = "arg2")
    private String arg2;

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

    public String getArg2() {
        return this.arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

}
