package userinterface.userinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class Statistics extends Application {


    public Label lable;
    public Label lablewors;
    Stage stage = new Stage();

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Statistics.fxml"));
        primaryStage.setTitle("Статистика");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public void best_employee(){
        double best = 0.0;
        for(int i = 0; i < ListOfEmployees.employees.size(); i++){
            if(ListOfEmployees.employees.get(i).getPremia() > best){
                best = ListOfEmployees.employees.get(i).countPremia();
            }
        }
        for(int i = 0; i < ListOfEmployees.employees.size(); i++){
            if(ListOfEmployees.employees.get(i).countPremia() == best){
                lable.setText(ListOfEmployees.employees.get(i).getName());
            }
        }
}
    public void wors_employee(){
        double wors = 10000.0;
        for(int i = 0; i < ListOfEmployees.employees.size(); i++){
            if(ListOfEmployees.employees.get(i).getPremia() < wors){
                wors = ListOfEmployees.employees.get(i).countPremia();
            }
        }
        for(int i = 0; i < ListOfEmployees.employees.size(); i++){
            if(ListOfEmployees.employees.get(i).countPremia() == wors){
                lablewors.setText(ListOfEmployees.employees.get(i).getName());
            }
        }
    }
    public void  showWindowStatistic() throws Exception {
        start(stage);
    }
}
