package userinterface.userinterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CheckPassword extends Application {

    public PasswordField passw;
    int mylogin = 3;
    int mypassword = 1;

    @FXML
    TextField login;

    Stage stage=new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CheckPasswordController.fxml"));
        primaryStage.setTitle("Вход в систему");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public void getPerson(ActionEvent event) throws Exception {
            int pass = Integer.parseInt(passw.getText());
            int  log = Integer.parseInt(login.getText());
        if(pass == mypassword && log == mylogin) {
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            MainAppController app = new MainAppController();
            app.mainAppController();
        }

    }

    public void  showWindowCheck() throws Exception {
        start(stage);


    }
}
