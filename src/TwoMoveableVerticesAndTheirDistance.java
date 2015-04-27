import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Created by Łukasz Rutkowski on 2015-04-24.
 */
public class TwoMoveableVerticesAndTheirDistance extends Application
{
    private Pane pane;
    private Circle circle1;
    private Circle circle2;
    private Line line;
    private Label label;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        circle1 = new Circle(100, 100, 20, getRandomColor());
        circle2 = new Circle(200, 100, 20, getRandomColor());
        line = new Line();
        label = new Label();
        label.setLayoutX(150);
        label.setLayoutY(100);

        line.startXProperty().bind(circle1.centerXProperty());
        line.startYProperty().bind(circle1.centerYProperty());
        line.endXProperty().bind(circle2.centerXProperty());
        line.endYProperty().bind(circle2.centerYProperty());

        pane = new Pane(label, line, circle1, circle2);
        pane.setMinSize(400, 200);

        circle1.setOnMouseDragged(e ->
        {
            circle1.setCenterX(e.getX());
            circle1.setCenterY(e.getY());
            label.setText(String.valueOf(calculateLineLength()));
            label.setLayoutX(setLabelCoords()[0]);
            label.setLayoutY(setLabelCoords()[1] * -1);
        });


        circle2.setOnMouseDragged(e ->
        {
            circle2.setCenterX(e.getX());
            circle2.setCenterY(e.getY());
            label.setText(String.valueOf(calculateLineLength()));
            label.setLayoutX(setLabelCoords()[0] /2);
            label.setLayoutY(setLabelCoords()[1] /2);
        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private int calculateLineLength()
    {
        return (int) Math.sqrt(Math.pow(line.getEndY() - line.getStartY(), 2) + Math.pow(line.getEndX() - line.getStartX(),
                2));
    }

    private int[] setLabelCoords()
    {
        int[] coords = new int[2];
        coords[0] = Math.abs((int) (line.getEndX() - line.getStartX()));
        coords[1] = Math.abs((int) (line.getEndY() - line.getStartY()));
        return coords;
    }

    public static void main(String[] args) {launch(args);}

    private Color getRandomColor() {return new Color(Math.random(), Math.random(), Math.random(), 0.7);}

}
