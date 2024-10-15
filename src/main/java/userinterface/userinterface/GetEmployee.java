package userinterface.userinterface;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetEmployee extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("employee")) {
            int id = Integer.parseInt(attributes.getValue("id"));
            String name = attributes.getValue("name");
            String job = attributes.getValue("job");
            double kofisient = Double.parseDouble(attributes.getValue("kofisient"));
            if(!ListOfEmployees.employees.contains(id)){
            ListOfEmployees.employees.add(new Employee(id, name, job, kofisient));
        }}
    }
}
