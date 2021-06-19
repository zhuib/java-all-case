package xml.lab11;

/**
 * Date: 2020/12/4 16:41
 */
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Traversal {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Document doc = builder.parse(args[0]);
//            src/main/resources/Traversal.xml
            Document doc = builder.parse(new File("src/main/resources/Traversal.xml"));
            doc.normalize();
            Element root = doc.getDocumentElement();
            if(doc!=null)
                printNode(root);
        }catch (Exception e) {
            e.printStackTrace();
        }}
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
                if(children.item(k).getNodeType()==Node.ELEMENT_NODE)
                    printNode((Element)children.item(k));
                else if(children.item(k).getNodeType()==Node.TEXT_NODE) {
                    System.out.println(children.item(k).getNodeValue());
                }
            }
            System.out.println("<"+element.getNodeName()+">");
        }
    }
}
