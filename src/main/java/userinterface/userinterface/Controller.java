package userinterface.userinterface;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class Controller extends Application {

    private ObservableList<Employee> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<Employee> tableUsers;
    @FXML
    private TableColumn<Employee, Integer> idColumn;

    @FXML
    private TableColumn<Employee, String> nameColumn;

    @FXML
    private TableColumn<Employee, String> jobColumn;

    @FXML
    private TableColumn<Employee, String> premiaColumn;

    @FXML
    private void initialize() throws ParserConfigurationException, IOException, SAXException {
        initData();
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        jobColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("job"));
        premiaColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("premia"));


    }

    private void initData() throws ParserConfigurationException, IOException, SAXException {
        usersData.removeAll(ListOfEmployees.employees);
        ListOfEmployees.employees.clear();
        ListOfEmployees.listofemplyees();
         for(int i = 0; i < ListOfEmployees.employees.size(); i++){
         usersData.add(i, ListOfEmployees.employees.get(i));
      }

    }

    public void showMessage() {
        tableUsers.setItems(null);
        tableUsers.setItems(usersData);
    }
    public void count() {
        for(int i = 0; i < ListOfEmployees.employees.size(); i++){
            ListOfEmployees.employees.get(i).countPremia();
        }
        usersData.setAll(ListOfEmployees.employees);
        showMessage();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Controller.fxml"));
        primaryStage.setTitle("Рассчет премии");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
    Stage stage=new Stage();
    public void  showWindowCount() throws Exception {
        start(stage);
    }

}