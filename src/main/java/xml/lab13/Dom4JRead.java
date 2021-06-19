package xml.lab13;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * Date: 2020/12/15 9:38
 */
public class Dom4JRead {
    public static void main(String[] args) throws Exception {
        // 使用SAXReader来解析XML文档
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("src/main/resources/student1_dom4j.xml"));
        Element root = doc.getRootElement();
        parse(root);
    }

    public static void parse(Element ele) {
        // 处理当前元素包含的所有属性
        parseAttribute(ele);
        // 获取当前元素包含的所有子元素
        List el = ele.elements();
        // 遍历每个子元素
        for (Object e : el) {
            Element element = (Element) e;
            // 如果该元素的内容不是只包含字符串
            if (!element.isTextOnly()) {
                parse(element); // 递归
            }else{
                // 处理当前元素的全部属性
                parseAttribute(element);
                // 获取当前元素的内容
                System.out.println(element.getQName().getName() + "-->" + element.getText());
            }
        }
    }

    // 定义一个方法处理指定元素的所有属性
    public static void parseAttribute(Element ele) {
        // 获取Element元素的所有属性
        List attList = ele.attributes();
        // 遍历Element元素的每个属性
        for (Object e : attList) {
            Attribute attr = (Attribute) e;
            // 访问当前元素的每个属性的属性值
            System.out.println(ele.getQName().getName() + "元素的" + attr.getQName().getName()+ "属性值为：" + attr.getValue());
        }
    }
}
