import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by Łukasz Rutkowski on 2015-04-24.
 */
public class InsideACircle extends Application
{
    private Pane pane;
    private Circle circle;
    private Label lblText = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        pane = new Pane();
        pane.setStyle("-fx-background-color: yellow");
        pane.setMinSize(200, 150);
        circle = new Circle(100, 60, 50, Color.BLUEVIOLET);
        pane.getChildren().add(circle);
        String ta1 = "inside a circle";
        String ta2 = "outside of a circle";
        lblText.setText(ta1);

        pane.getChildren().add(lblText);

        pane.setOnMouseMoved(e->
        {
            lblText.setLayoutX(e.getX() + 20);
            lblText.setLayoutY(e.getY() + 20);

            if (circle.getBoundsInParent().contains(e.getX(),e.getY()))
            {
                lblText.setText(ta1);
            }
            else lblText.setText(ta2);
        });



//        circle.setOnMouseEntered(e->
//        {
//
//        });


        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
