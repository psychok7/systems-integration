
package test.artefact.user;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the test.artefact.user package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Exception_QNAME = new QName("http://webservices2/", "Exception");
    private final static QName _GetUserByIdResponse_QNAME = new QName("http://webservices2/", "getUserByIdResponse");
    private final static QName _RegisterWS2Response_QNAME = new QName("http://webservices2/", "registerWS2Response");
    private final static QName _GetUserById_QNAME = new QName("http://webservices2/", "getUserById");
    private final static QName _LoginWS2Response_QNAME = new QName("http://webservices2/", "loginWS2Response");
    private final static QName _RegisterWS2_QNAME = new QName("http://webservices2/", "registerWS2");
    private final static QName _LoginWS2_QNAME = new QName("http://webservices2/", "loginWS2");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: test.artefact.user
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegisterWS2 }
     * 
     */
    public RegisterWS2 createRegisterWS2() {
        return new RegisterWS2();
    }

    /**
     * Create an instance of {@link GetUserByIdResponse }
     * 
     */
    public GetUserByIdResponse createGetUserByIdResponse() {
        return new GetUserByIdResponse();
    }

    /**
     * Create an instance of {@link LoginWS2 }
     * 
     */
    public LoginWS2 createLoginWS2() {
        return new LoginWS2();
    }

    /**
     * Create an instance of {@link GetUserById }
     * 
     */
    public GetUserById createGetUserById() {
        return new GetUserById();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link LoginWS2Response }
     * 
     */
    public LoginWS2Response createLoginWS2Response() {
        return new LoginWS2Response();
    }

    /**
     * Create an instance of {@link RegisterWS2Response }
     * 
     */
    public RegisterWS2Response createRegisterWS2Response() {
        return new RegisterWS2Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "getUserByIdResponse")
    public JAXBElement<GetUserByIdResponse> createGetUserByIdResponse(GetUserByIdResponse value) {
        return new JAXBElement<GetUserByIdResponse>(_GetUserByIdResponse_QNAME, GetUserByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterWS2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "registerWS2Response")
    public JAXBElement<RegisterWS2Response> createRegisterWS2Response(RegisterWS2Response value) {
        return new JAXBElement<RegisterWS2Response>(_RegisterWS2Response_QNAME, RegisterWS2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "getUserById")
    public JAXBElement<GetUserById> createGetUserById(GetUserById value) {
        return new JAXBElement<GetUserById>(_GetUserById_QNAME, GetUserById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginWS2Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "loginWS2Response")
    public JAXBElement<LoginWS2Response> createLoginWS2Response(LoginWS2Response value) {
        return new JAXBElement<LoginWS2Response>(_LoginWS2Response_QNAME, LoginWS2Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterWS2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "registerWS2")
    public JAXBElement<RegisterWS2> createRegisterWS2(RegisterWS2 value) {
        return new JAXBElement<RegisterWS2>(_RegisterWS2_QNAME, RegisterWS2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginWS2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices2/", name = "loginWS2")
    public JAXBElement<LoginWS2> createLoginWS2(LoginWS2 value) {
        return new JAXBElement<LoginWS2>(_LoginWS2_QNAME, LoginWS2 .class, null, value);
    }

}
