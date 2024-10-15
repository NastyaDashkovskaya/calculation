package userinterface.userinterface;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ListOfEmployees {
    public static ArrayList<Employee> employees = new ArrayList<>();

    public static void listofemplyees() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        GetEmployee handler = new GetEmployee();
        parser.parse(new File("employees.xml"), handler);

    }
}
