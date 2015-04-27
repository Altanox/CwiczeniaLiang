import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Łukasz Rutkowski on 2015-04-24.
 */
public class EnterAndDisplayAString extends Application
{
    private Pane pane;
    private Text text;
    private StringBuilder sb;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        pane = new Pane();
        pane.setStyle("-fx-background-color: blue");
        pane.setMinSize(150, 150);
        sb = new StringBuilder();
        text = new Text();
        text.setY(50);
        text.setX(10);

        pane.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.ENTER)
            {
                text.setText(sb.toString());
                pane.getChildren().add(text);
            }
            else sb.append(e.getText());
        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        pane.requestFocus();
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
