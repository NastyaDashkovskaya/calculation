package userinterface.userinterface;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static java.lang.Integer.parseInt;

public class AddController extends Application {

    @FXML
    TextField name;
    @FXML
    TextField surname;
    @FXML
    TextField patronymic;
    @FXML
    TextField id;
    @FXML
    TextField job;
    @FXML
    TextField koficient;
    Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("AddController.fxml"));
        primaryStage.setTitle("Добавление работника");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();

    }
    public void getEmployee(){
        String employee_name = name.getText();
        String employee_surname = surname.getText();
        String employee_patronymic = patronymic.getText();
        String employee_job = job.getText();
        int employee_id = parseInt(id.getText());
        String employee_koficient = koficient.getText();
        String a = employee_name + employee_surname + employee_patronymic;
        AddEmployee.add(employee_id, a, employee_job, Double.parseDouble(employee_koficient));
    }


    public void  showWindowAdd() throws Exception {
        start(stage);
    }
}
