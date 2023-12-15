import javax.sound.midi.Sequence;

import org.jfugue.player.Player;
public class Audio {
    private float volume;
    private Player player;

    public Audio() {
        this.volume = 0.5f;
        createPlayer();
    }

    protected void createPlayer() {
        this.player = new Player();
    }
    
    public void playFile(String file) {
        if (this.player != null) {
            this.player.play(file);
        }
    }

    public void stop() {
        if (this.player != null && this.player.getManagedPlayer() != null) {
            this.player.getManagedPlayer().finish();
        }
    }

    public void pause() {
        if (this.player != null && this.player.getManagedPlayer() != null) {
            this.player.getManagedPlayer().pause();
        }
    }

    public void resume() {
        if (this.player != null && this.player.getManagedPlayer() != null) {
            this.player.getManagedPlayer().resume();
        }
    }

    public void setVolume(float volume) {
        if (volume < 0.0f || volume > 1.0f) {
            throw new IllegalArgumentException("Volume must be between 0.0 and 1.0");
        }
        this.volume = volume;
    }

    public float getVolume() {
        return this.volume;
    }

    public void playSequence(Sequence sequence) {
        if (this.player != null) {
            this.player.play(sequence);
        }
    }

    
}