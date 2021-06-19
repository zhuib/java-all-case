package xml.lab13;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * Date: 2020/12/15 9:38
 */
public class VisitorRead {
    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("src/main/resources/student1_dom4j.xml"));
        // 使用访问者模式来访问XML文档
        doc.accept(new YeekuVistor());
    }
}
