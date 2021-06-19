package xml.lab14;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Date: 2020/12/18 14:04
 */
public class SaxParserXml {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser sParser = factory.newSAXParser();
        sParser.parse(new File("src/main/resources/sax.xml"),new MyHandler());
    }
}

class MyHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("解析文档开始...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析文档结束...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("<" + qName +">元素开始...");
        if (attributes.getLength() > 0) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.getQName(i) + "=" + attributes.getValue(i));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("</"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        StringBuffer sBuffer = new StringBuffer("");
        sBuffer.append(ch,start,length);
            System.out.println("元素内容为："+ sBuffer.toString());
    }
}