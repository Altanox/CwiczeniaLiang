import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by Łukasz Rutkowski on 2015-04-24.
 */
public class EyeHandCoordination extends Application
{
    private Pane pane;
    private double startTime;
    private double endTime;
    private String score;
    private Label displayScore;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        pane = new Pane();
        pane.setMinSize(800, 600);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 5; i++)
        {
            pane.setOnMousePressed(e ->
            {

                pane.getChildren().clear();
                pane.getChildren().add(makeNewCircle());

            });
        }
        endTime = System.currentTimeMillis();
        score = String.valueOf(endTime - startTime);
        displayScore = new Label(score);
        pane.getChildren().clear();
        pane.getChildren().add(displayScore);
        displayScore.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    public Circle makeNewCircle()
    {
        Color color = new Color(Math.random(), Math.random(), Math.random(), 1);
        int xPosition = (int) (Math.random() * pane.getWidth());
        int yPosition = (int) (Math.random() * pane.getHeight());
        final double radius = 20;
        return new Circle(xPosition, yPosition, radius, color);
    }
}
