import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Łukasz Rutkowski on 2015-04-24.
 */
public class AlternateTwoMessages extends Application
{
    private Text text1 = new Text("Java is fun");
    private Text text2 = new Text("Java is powerful");

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        text1.setLayoutY(100);
        text2.setLayoutY(100);

        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color: yellow");

        pane1.setMinSize(200,200);

        pane1.setOnMousePressed(e ->
        {
            if (e.getButton() == MouseButton.PRIMARY) pane1.getChildren().add(text1);
            else if (e.getButton() == MouseButton.SECONDARY) pane1.getChildren().add(text2);
        });
        pane1.setOnMouseReleased(e1 ->
        {
            if (e1.getButton() == MouseButton.PRIMARY) pane1.getChildren().clear();
            else if(e1.getButton() == MouseButton.SECONDARY) pane1.getChildren().clear();
        });

        Scene scene = new Scene(pane1,200,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
