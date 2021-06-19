package xml.dom4j;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;

public class ParseDom4jWrite {
    public static void main(String[] args) throws Exception {

        Document doc = DocumentHelper.createDocument();
//            获取根元素
        Element root = doc.addElement("users");
//        为root 添加 user 子元素
        Element user = root.addElement("user");
//        为 user 添加 属性
        Element element = user.addAttribute("id", "b01");
//        为 user 添加 name age gender 子元素
        Element name = user.addElement("name");
        Element age = user.addElement("age");
        Element gender = user.addElement("gender");

//        为 子元素 添加文本
        name.addText("zhangsan");
        age.addText("12");
        gender.addText("male");

//        doc 写入到文件中
//        ParseDom4jWrite.class.getClassLoader().getResource()
       /* Writer writer = new FileWriter(new File("src/user1.xml"));
        doc.write(writer);
        writer.close();*/

//       格式化输出
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileWriter(new File("src/user1.xml")), format);
        xmlWriter.write(doc);

        xmlWriter.close();
    }
}
