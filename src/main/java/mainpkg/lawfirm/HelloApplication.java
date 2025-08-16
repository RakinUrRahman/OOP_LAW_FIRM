package mainpkg.lawfirm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("/mainpkg/lawfirm/rakin/lawyer_close_case.fxml")
            );

            Scene scene = new Scene(fxmlLoader.load(), 900, 800);
            stage.setTitle("Law Firm - Create Case");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot load FXML file.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
