package xml.lab14;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Date: 2020/12/18 14:26
 * XmlReader
 */
public class SaxTest extends DefaultHandler implements DeclHandler {
    public static void main(String[] args) {
        try {
            XMLReader parser = XMLReaderFactory.createXMLReader();
            ContentHandler cth = new SaxTest();
            parser.setContentHandler(cth);
//            parser.setProperty("http://xml.org/sax/properties/declaration-handler",cth);
//            实验三
//            parser.parse(args[0]);
            parser.parse( "src/main/resources/sax.xml");
            System.out.println("当前XML的版本：" + parser.getProperty("http://xml.org/sax/properties/document-xml-version"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

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
    @Override
    public void elementDecl(String name, String model) throws SAXException {
        System.out.println("在DTD中元素声明" + name + "   "+ model);
    }

    @Override
    public void attributeDecl(String eName, String aName, String type, String mode, String value) throws SAXException {
        System.out.println("在DTD中元素" + eName + "属性名 "+ aName);
    }

    @Override
    public void internalEntityDecl(String name, String value) throws SAXException {

    }

    @Override
    public void externalEntityDecl(String name, String publicId, String systemId) throws SAXException {

    }
}
