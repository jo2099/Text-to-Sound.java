import javafx.scene.control.Button;
//import jfugue
import java.io.File;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class controller {
    private Button botao;
    public void clique() {
        System.out.println("Clicou no botão");
        
        //toca um arquivo midi com o nome de "teste.mid"
        try{
            Player player = new Player();
            Pattern pattern= MidiFileManager.loadPatternFromMidi(new File("teste.mid"));
            player.play(pattern);

        } catch (final Exception e)
        {
            System.out.println("Erro ao tocar o arquivo midi");
        }
    }
    
}
