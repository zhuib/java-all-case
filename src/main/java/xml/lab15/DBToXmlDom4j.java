package xml.lab15;

/**
 * Date: 2020/12/26 12:45
 */
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.*;


public class DBToXmlDom4j {
    public static void main(String[] args) throws Exception {
        //step1:创建文档并设置根元素userinfo
        Element root = DocumentHelper.createElement("userinfo");
        Document document = DocumentHelper.createDocument(root);
        //step2:访问数据库并将数据库信息封装进创建的xml文档中
        accessDB(document, root);
        //step3:指定文档输出格式
        OutputFormat format = new OutputFormat("   ", true);
        //step4:定义输出流，输出文档，限于内存中,表现为在控制台输出
        XMLWriter xmlWriter = new XMLWriter(format);
        xmlWriter.write(document);
        //step5:把文档输出到存储设备，硬盘：第一种方式
        XMLWriter xmlWriter2 = new XMLWriter(new FileOutputStream("src/dbToXmlDom4j1.xml"), format);
        xmlWriter2.write(document);
        //step6:把文档输出到存储设备，硬盘：第二种方式
        XMLWriter xmlWriter3 = new XMLWriter(new FileWriter("src/dbToXmlDom4j2.xml"), format);
        xmlWriter3.write(document);
        //step7:必须进行刷新和关闭，否则写入内容为空
        xmlWriter3.flush();
        //xmlWriter3.close();
    }

    //定义静态函数访问数据库
    public static void accessDB(Document doc, Element root) {
        try {
            //step1:数据库连接字符串
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3307/goods";
            String user = "root";
            String password = "root";
            //step2:连接数据库执行查询m
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            //step3:获得数据库结果集
            ResultSet rs = statement.executeQuery("select * from users");
            //step4:生成xml文档
            createXml(doc, root, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //定义静态函数创建xml文档
    public static void createXml(Document doc, Element root, ResultSet rs) throws SQLException {
        while (rs.next()) {
            //step1:生成与表名对应的元素节点并添加到根元素节点下
            Element user = root.addElement("users");
            //step2:添加子元素userid
            Element userid = user.addElement("userid");
            userid.setText(rs.getString("userid"));
            //step3:添加子元素username
            Element username = user.addElement("username");
            username.setText(rs.getString("username"));
            //step4:添加子元素password
            Element password = user.addElement("password");
            password.setText(rs.getString("password"));
        }
    }
}
