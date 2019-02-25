package com.coderbd.dom.ex3.create;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMCreateXMLDemo2 {

    public static void main(String argv[]) {
        List<Staff> list = new ArrayList();
        list.add(new Staff(100, "Minhaz", "Rahman", "Minhaz", 200000.0, "BD"));
        list.add(new Staff(101, "Megedee", "Hasan", "Shuvo", 500000.0, "INDIA"));
        list.add(new Staff(102, "Shariar", "Hasan", "Shetu", 300000.0, "China"));
         list.add(new Staff(103, "Yasin", "Rahman", "arif", 10000.0, "BD"));
        list.add(new Staff(104, "Tahmina", "Begum", "Tahmina", 500000.0, "Australia"));
        list.add(new Staff(105, "Sumaya", "Akter", "Sumaya", 300000.0, "USA"));

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);
            // staff elements
            for (Staff s : list) {
                Element staff = doc.createElement("Staff");
                rootElement.appendChild(staff);
                // set attribute to staff element
                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(s.getId()));
                staff.setAttributeNode(attr);

                // shorten way
                // staff.setAttribute("id", "1");
                // firstname elements
                Element firstname = doc.createElement("firstname");
                firstname.appendChild(doc.createTextNode(s.getFirstname()));
                staff.appendChild(firstname);

                // lastname elements
                Element lastname = doc.createElement("lastname");
                lastname.appendChild(doc.createTextNode(s.getLastname()));
                staff.appendChild(lastname);

                // nickname elements
                Element nickname = doc.createElement("nickname");
                nickname.appendChild(doc.createTextNode(s.getNickname()));
                staff.appendChild(nickname);

                // salary elements
                Element salary = doc.createElement("salary");
                salary.appendChild(doc.createTextNode(String.valueOf(s.getSalary())));
                staff.appendChild(salary);

                // salary elements
                Element country = doc.createElement("country");
                country.appendChild(doc.createTextNode(s.getCountry()));
                staff.appendChild(country);
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("D:\\git\\xml\\Ex01-well-formed-xml\\src\\com\\coderbd\\dom\\ex3\\create\\ex2.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
