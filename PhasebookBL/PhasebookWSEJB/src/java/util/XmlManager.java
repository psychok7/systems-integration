package util;

import entities.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.w3c.dom.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlManager {
    private static String WEBUSER_XML = "./user-jaxb.xml";
        
       
      public Marshaller marshall(User webuser) throws JAXBException, IOException{
        
              JAXBContext context = JAXBContext.newInstance(User.class);
              Marshaller m = context.createMarshaller();
              m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
              m.marshal(webuser, System.out);

              Writer w = null;
              try {
                      w = new FileWriter(WEBUSER_XML);
                      m.marshal(webuser, w);
              } finally {
                      try {
                              w.close();
                      } catch (Exception e) {
                      }
              }
                
                return m;
        
        
    }

   public String convertXMLFileToString(String fileName) 
        { 
          try{ 
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); 
            InputStream inputStream = new FileInputStream(new File(fileName)); 
            org.w3c.dom.Document doc = documentBuilderFactory.newDocumentBuilder().parse(inputStream); 
            StringWriter stw = new StringWriter(); 
            Transformer serializer = TransformerFactory.newInstance().newTransformer(); 
            serializer.transform(new DOMSource(doc), new StreamResult(stw)); 
            return stw.toString(); 
          } 
          catch (Exception e) { 
            e.printStackTrace(); 
          } 
            return null; 
        }
        
    public Document loadXMLFromString(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return (Document) builder.parse(is);
    }
    
    public User ReadUserXmlFile(Document doc){
        doc.getDocumentElement().normalize();
        
        User user=new User();
        
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("user");
        System.out.println("-----------------------");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
 
		   Node nNode = nList.item(temp);
		   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
                        Element eElement = (Element) nNode;
 
                        //-------
                        NodeList name_local = eElement.getElementsByTagName("name");
                        Element nameElement = (Element)name_local.item(0);
                        user.setName(((Node)nameElement.getChildNodes().item(0)).getNodeValue().trim()) ;
                         System.out.println("name : " + user.getName());
                        
                        //-------
                        NodeList email_local = eElement.getElementsByTagName("email");
                        Element emailElement = (Element)email_local.item(0);
                        user.setEmail(((Node)emailElement.getChildNodes().item(0)).getNodeValue().trim()) ;
                         System.out.println("email : " + user.getEmail());
 
                         //-------
                         
                        NodeList pass = eElement.getElementsByTagName("password");
                        Element passElement = (Element)pass.item(0);
                        user.setPassword(((Node)passElement.getChildNodes().item(0)).getNodeValue().trim());
                         System.out.println("password : " + user.getPassword());
                         
                         //-------
                        NodeList iduser_local = eElement.getElementsByTagName("iduser");
                        Element iduserElement = (Element)iduser_local.item(0);
                         user.setIduser(Integer.parseInt(((Node)iduserElement.getChildNodes().item(0)).getNodeValue().trim()));
                         System.out.println("iduser : " + user.getIduser());
                         
                         //-------
                        NodeList credit_local = eElement.getElementsByTagName("credit");
                        Element creditElement = (Element)credit_local.item(0);
                        user.setCredit(Integer.parseInt(((Node)creditElement.getChildNodes().item(0)).getNodeValue().trim()));
                         System.out.println("credit : " + user.getCredit());
		   }
		}
        
        return user;
    }
    
}