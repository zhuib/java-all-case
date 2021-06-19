package xml.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class ParseDom4j {
    public static void main(String[] args) throws Exception {
        String path = ParseDom4j.class.getClassLoader().getResource("user.xml").getPath();
        SAXReader reader = new SAXReader();
//        获取 dom树
        Document document = reader.read(new File(path));
        System.out.println("======================");


        List<?> list = document.selectNodes("//user");
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("======================");
        System.out.println(document);
//        获取根元素
        Element root = document.getRootElement();
        Node node = root.selectSingleNode("//user");
        System.out.println(node.getName());
        System.out.println("+++++++++++"+ node);
        Iterator<?> iterator = root.elementIterator();
        while (iterator.hasNext()){
//            取出元素
            Element next = (Element) iterator.next();
            String name = next.getName();
            System.out.println(name);

//            获取id 属性
            Attribute id = next.attribute("id");
            System.out.println(id.getName() + "==" + id.getValue());

//            获取users子元素
            Element name1 = next.element("name");
            Element age = next.element("age");
            Element gender = next.element("gender");

//            输出
            System.out.println(name1.getName() + "=" + name1.getStringValue());
            System.out.println(age.getName() + '=' + age.getText());
            System.out.println(gender.getName() + "=" + gender.getText());
        }
    }
}
