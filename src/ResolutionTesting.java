import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Łukasz Rutkowski on 2015-04-02.
 */
public class ResolutionTesting extends Application
{
    private final double height = 200;
    private final double width = 320;
    private final double scale = 1;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FlowPane pane = new FlowPane();
        pane.setPrefSize(width,height);
        Collection<Rectangle> pixelColelction= new ArrayList<Rectangle>((int)height * (int)width);

        for (int i =0; i < ((int)width * (int) height); i++)
        {
            pixelColelction.add(pixelGenerator());
        }
        pane.getChildren().addAll(pixelColelction);

        Scene scene = new Scene(pane,320,200);
        primaryStage.setTitle("Test pixel range");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setFullScreen(true);

    }
    private static Color randomColorGenerator()
    {
        return new Color(Math.random(), Math.random(), Math.random(), 1.0);
    }

    private static Rectangle pixelGenerator()
    {
        return new Rectangle(1,1, randomColorGenerator());
    }
}
