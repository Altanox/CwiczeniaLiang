import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by Łukasz Rutkowski on 2015-04-24.
 */
public class AddRemovePoints extends Application
{
    private Pane pane;


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        pane = new Pane();
        pane.setOnMousePressed(e ->
        {
            if (e.getButton() == MouseButton.PRIMARY)
            {
                Circle circle = createCircle();
                pane.getChildren().add(circle);
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
            }
            else if(e.getButton() == MouseButton.SECONDARY)
            {
             pane.getChildren().remove(e.getTarget());
            }

        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle createCircle()
    {
        Color color = new Color(Math.random(),Math.random(),Math.random(), 0.6);
        return new Circle(10, color);
    }

    public static void main(String[] args) {launch(args);}
}
