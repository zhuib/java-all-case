package xml.lab12;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Date: 2020/12/4 16:12
 */
public class PrintNodeUtil {

    public static void printNode(Element element) {
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
            System.out.println("</"+element.getNodeName()+">");
        }
    }

}
