package xml.dom4j;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParseXML {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {

        String path = ParseXML.class.getClassLoader().getResource("user.xml").getPath();
        System.out.println(path);
//        URL url = new URL("http://www.baidu.com");
//        System.out.println(url);
//        Document document = Jsoup.parse(url, 6000);
//        String html = document.html();
//        System.out.println(html);
        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println("=========================");
//        获取 xpath 对象， 参数是 document
        JXDocument xpath = new JXDocument(document);

        List<JXNode> jxNodes = xpath.selN("//users/user[@id='1']/name");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("=========================");
        List<Object> sel = xpath.sel("//user[@id='1']");
        for (Object o : sel) {
            System.out.println(o);
        }
 /*       Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(path);
        Elements elements = document.getElementsByTag("name");
        int sise = elements.size();
        System.out.println(sise);
        System.out.println(elements.get(0).text());*/
    }

}
