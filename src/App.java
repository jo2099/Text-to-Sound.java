import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        Thread.sleep(1000);
        
        Text texto=new Text(new Character[]{'C','D','E','F','G','A','B'});
        MidiHandler midiHandler=new MidiHandler();
        Audio audio=new Audio();
        audio.playSequence(midiHandler.convertTextToSequence(texto.getContent()));


    }
}
