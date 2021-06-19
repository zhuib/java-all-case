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
 * Date: 2020/12/4 15:51
 */
public class InsertElement {
    public static void main(String[] args) {
        try {
//            String path = AddElement.class.getClassLoader().getResource().getPath();
//            System.out.println(path);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document doc = builder.parse(args[0]);
            Document doc = builder.parse(new File("D:\\java\\java_all_test\\src\\main\\resources\\Traversal.xml"));
            doc.normalize();

            Element root = doc.getDocumentElement();
//            System.out.println(root);
            Element team = doc.createElement("Team");
            Element country = doc.createElement("Country");
            Text country_text = doc.createTextNode("Germany");
            country.appendChild(country_text);

            Element teamname = doc.createElement("Teamname");
            Text team_text = doc.createTextNode("Frankfurt");
            teamname.appendChild(team_text);
            Element member = doc.createElement("Member");
            Attr age = doc.createAttribute("Age");
            Attr sex = doc.createAttribute("Sex");

            Text member_text = doc.createTextNode("Roman");
            member.setAttribute(age.getNodeName(),"32");
            member.setAttribute(sex.getNodeName(),"Male");

            member.appendChild(member_text);
            team.appendChild(country);
            team.appendChild(teamname);
            team.appendChild(member);
//            root.appendChild(team);
            root.insertBefore(team,doc.getElementsByTagName("Team").item(0));

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
