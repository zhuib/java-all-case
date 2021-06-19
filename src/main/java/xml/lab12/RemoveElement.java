package xml.lab12;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Date: 2020/12/4 15:55
 */
public class RemoveElement {
    public static void main(String[] args) {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document doc = builder.parse(args[0]);
            Document doc = builder.parse(new File("D:\\java\\java_all_test\\src\\main\\resources\\Traversal.xml"));
            doc.normalize();

            Element root = doc.getDocumentElement();
//            System.out.println(root);
            Element member = (Element) root.getElementsByTagName("Member").item(0);
            Node text = member.getFirstChild();
            member.removeChild(text);

            if (doc != null) {
                PrintNodeUtil.printNode(root);
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("D:\\java\\java_all_test\\src\\main\\resources\\Traversal.xml"));
                transformer.transform(source,result);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
