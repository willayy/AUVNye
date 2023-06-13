import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AUVNyeApp extends Application {

    //Made by William Norland 2023-06-12

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserInterface.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent, 450, 450);
        
        stage.setMaxWidth(450);
        stage.setMaxHeight(450);
        stage.setMinWidth(450);
        stage.setMinHeight(450);
        stage.setScene(scene);
        stage.getIcons().add(new Image("AUVNyeIcon.png"));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

