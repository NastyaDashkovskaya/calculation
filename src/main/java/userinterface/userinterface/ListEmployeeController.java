package userinterface.userinterface;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.*;
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
import java.util.ArrayList;

public class ListEmployeeController extends Application {


    private   ObservableList<Employee> users = FXCollections.observableArrayList();

    @FXML
    private TableView<Employee> tableUsers;
    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, String> name;

    @FXML
    private TableColumn<Employee, String> job;


    @FXML
    private void initialize() throws ParserConfigurationException, IOException, SAXException {
        initData();
        // устанавливаем тип и значение которое должно хранится в колонке
        id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        job.setCellValueFactory(new PropertyValueFactory<Employee, String>("job"));

        // заполняем таблицу данными
        tableUsers.setItems(users);
    }
    @FXML
    private void initData() throws ParserConfigurationException, IOException, SAXException {
        users.removeAll(ListOfEmployees.employees);
        ListOfEmployees.employees.clear();
        ListOfEmployees.listofemplyees();
        for(int i = 0; i < ListOfEmployees.employees.size(); i++){
            users.add(i, ListOfEmployees.employees.get(i));
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ListEmployeeController.fxml"));
        primaryStage.setTitle("Список работников");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
    Stage stage=new Stage();
    public void  showWindowListEmployee() throws Exception {
        start(stage);
    }
    public void changeWindowAdd() throws Exception{
        // int a = tableUsers.getSelectionModel().getSelectedIndex();
        //System.out.println(a);//получение индекса
      AddController second = new AddController();
      second.showWindowAdd();
    }

    public void deliteEmployee(ActionEvent actionEvent) throws ParserConfigurationException, IOException, SAXException {
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse("employees.xml");
            Element root = doc.getDocumentElement();
            NodeList listEmployees = root.getElementsByTagName("employee");
            Node item = listEmployees.item(tableUsers.getSelectionModel().getSelectedIndex());
            root.removeChild(item);


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("employees.xml"));
            transformer.transform(source, result);
            System.out.println("Выполнено удаление работника");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
        initData();
    }

public void changeWindowStatistic() throws Exception {
        Statistics second = new Statistics();
        second.showWindowStatistic();
}
}

