package userinterface.userinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainAppController extends Application {
    Stage stage = new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainAppController.fxml"));
        primaryStage.setTitle("Главная страница");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public void changeWindowCount() throws Exception{
        Controller second = new Controller();
        second.showWindowCount();
    }

    public void changeWindowList() throws Exception{
        ListEmployeeController second = new ListEmployeeController();
        second.showWindowListEmployee();
    }
    public void mainAppController() throws Exception {
        start(stage);
    }
}
