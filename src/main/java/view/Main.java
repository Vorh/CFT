package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        String fx = "/Calculator.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fx));
        primaryStage.setTitle("Калькулятор");
        primaryStage.setWidth(226);
        primaryStage.setHeight(330);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.getScene().getStylesheets().add("/style.css");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
