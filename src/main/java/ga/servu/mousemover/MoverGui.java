package ga.servu.mousemover;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Pisek on 08.03.2017.
 */
public class MoverGui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Mouse Mover");
        Button btn = new Button();
        initButton(btn);

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.show();

    }

    private void startMover(Button btn) {
        MouseMover mouseMover = new MouseMover();
        new Thread(mouseMover).start();
        btn.setText("Stop Mover");
        btn.setOnAction(event -> stopMover(btn, mouseMover));
    }

    private void stopMover(Button btn, MouseMover mouseMover) {
        mouseMover.close();
        btn.setText("Start Mover");
        btn.setOnAction(event -> startMover(btn));
    }

    private void initButton(Button btn) {
        btn.setText("Start Mover");
        btn.setOnAction(event -> startMover(btn));
    }
}
