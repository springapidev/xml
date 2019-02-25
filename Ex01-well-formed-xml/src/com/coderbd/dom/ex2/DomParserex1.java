package com.coderbd.dom.ex2;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParserex1 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("D:\\git\\xml\\Ex01-well-formed-xml\\src\\com\\coderbd\\dom\\ex3\\create\\ex2.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Staff");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Student roll no : "
                            + eElement.getAttribute("id"));
                    System.out.println("First Name : "
                            + eElement
                                    .getElementsByTagName("firstname")
                                    .item(0)
                                    .getTextContent());
                    System.out.println("Last Name : "
                            + eElement
                                    .getElementsByTagName("lastname")
                                    .item(0)
                                    .getTextContent());
                    System.out.println("Nick Name : "
                            + eElement
                                    .getElementsByTagName("nickname")
                                    .item(0)
                                    .getTextContent());
                    System.out.println("salary : "
                            + eElement
                                    .getElementsByTagName("salary")
                                    .item(0)
                                    .getTextContent());
                    System.out.println("Country : "
                            + eElement
                                    .getElementsByTagName("country")
                                    .item(0)
                                    .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
