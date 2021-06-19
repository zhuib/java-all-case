package xml.lab11;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Date: 2020/12/4 16:39
 */
public class DomWrite {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("src/main/resources/writeSample.xml"));
        //Document doc = db.parse(args[1]);
        Element root = doc.getDocumentElement();
        Element team_member = doc.createElement("team_member");
        root.appendChild(team_member);
        creatChildElement(doc,"empno","value","30772");
        creatChildElement(doc,"name","value","Manjeet singh");
        creatChildElement(doc,"designation","value","Team_leader");
        creatChildElement(doc,"email","value","Manjeet@abc.com");
        doc.normalize();
        if (doc!=null) {
            printNode(root);
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer transformer = tff.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult sResult = new StreamResult(new File("writeSample.xml"));
            transformer.transform(domSource, sResult);
        }
    }
    private static void printNode(Element element) {
        NodeList children = element.getChildNodes();
        NamedNodeMap attr = element.getAttributes();
        int r = children.getLength();
        if(attr!=null) {
            System.out.print("<"+element.getNodeName());
            for(int j = 0;j<attr.getLength();j++) {
                System.out.print(""+attr.item(j).getNodeName()+"="+attr.item(j).getNodeValue()+"");
            }
            System.out.println(">");
        }
        else if(attr==null) {
            System.out.println("<"+element.getNodeName()+">");
        }
        if(element.hasChildNodes()) {
            for (int k = 0; k < r; k++) {
                if(children.item(k).getNodeType()== Node.ELEMENT_NODE)
                    printNode((Element)children.item(k));
                else if(children.item(k).getNodeType()==Node.TEXT_NODE) {
                    System.out.println(children.item(k).getNodeValue());
                }
            }
            System.out.println("<"+element.getNodeName()+">");
        }
    }
    private static void creatChildElement(Document doc,String s1,String s2,String s3) {
        Element element = doc.createElement(s1);
        org.w3c.dom.Attr attr = doc.createAttribute(s2);
        element.setAttribute(attr.getNodeName(), s3);
        doc.getElementsByTagName("team_member").item(0).appendChild(element);
    }
}
