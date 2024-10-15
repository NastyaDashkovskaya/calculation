package userinterface.userinterface;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class AddEmployee {
    public static void add(int id, String name, String job, double kofisient) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse("employees.xml");

            Node staff = doc.getElementsByTagName("employees").item(0);

            Element root = doc.getDocumentElement();

            Element newEmployee = doc.createElement("employee");
            newEmployee.setAttribute("id", String.valueOf(id));
            newEmployee.setAttribute("name", name);
            newEmployee.setAttribute("job", job);

            newEmployee.setAttribute("kofisient", String.valueOf(kofisient));
            root.appendChild(newEmployee);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("employees.xml"));
            transformer.transform(source, result);

            System.out.println("Выполнено добавление работника.");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }

    }
}