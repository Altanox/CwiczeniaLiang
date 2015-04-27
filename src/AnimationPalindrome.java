import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;

/**
 * Created by Łukasz Rutkowski on 2015-04-24.
 */
public class AnimationPalindrome extends Application
{
    private Pane pane;
    private Arc line;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        pane = new Pane();
        pane.setMinSize(150, 150);
        line = new Arc(75,75,50,20,0,50);
        pane.getChildren().add(line);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
