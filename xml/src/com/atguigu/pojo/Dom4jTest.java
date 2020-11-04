package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        // 创建一个SaxReader输入流，去读取 xml配置文件，生成Document对象
//        SAXReader saxReader = new SAXReader();
//        Document document = saxReader.read("src/books.xml");
//        System.out.println(document);
        SAXReader reader = new SAXReader();
        //junit测试中，相对路径是从模块名开始算
        Document document = reader.read("src/books.xml");
        Element rootElement = document.getRootElement();
        //System.out.println(rootElement);//<books>
        List<Element> books = rootElement.elements("book");
        for (Element book :
                books) {
           // System.out.println(book.asXML());
            //System.out.println(book.element("name").asXML());
           // System.out.println(book.element("name").getText());
           // System.out.println(book.elementText("price"));
            Element nameElement = book.element("name");
            String nameText = nameElement.getText();
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");
            String snValue = book.attributeValue("sn");
            System.out.println(new Book(snValue,nameText,
                    Double.parseDouble(priceText),authorText));
        }


    }

}
