package xml.lab13;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Date: 2020/12/11 14:47
 */
public class Dom4JWrite {
    public static void main(String[] args) throws IOException {

        Element root = DocumentHelper.createElement("学生名册");
        Document document = DocumentHelper.createDocument(root);
        root.addAttribute("学校","广州大学华软软件学院");

        Element stuElement = root.addElement("学生");

        stuElement.addAttribute("年级","16级").addAttribute("学号","16098765");

        Element nameElement = stuElement.addElement("姓名");
        nameElement.setText("小王");
        Element sexElement = stuElement.addElement("性别");
        sexElement.setText("男");
        Element ageElement = stuElement.addElement("年龄");
        ageElement.setText("18");
        Element birthElement = stuElement.addElement("生日");
        birthElement.setText("2018-08-08");

        OutputFormat format = new OutputFormat("   ", true);
        XMLWriter xmlWriter = new XMLWriter(format);
        xmlWriter.write(document);
        XMLWriter xmlWriter2 = new XMLWriter(new FileOutputStream("src/main/resources/student2_dom4j.xml"),format);
        xmlWriter2.write(document);

        XMLWriter xmlWriter3 = new XMLWriter(new FileWriter("src/main/resources/student2_dom4j.xml"),format);
        xmlWriter3.write(document);

        xmlWriter3.flush();
    }
}
