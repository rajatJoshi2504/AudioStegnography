import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Audio {
    public String fileName;
    public InputStream inputStream;
    public AudioStream audioStream;

    public Audio(String fileN) throws FileNotFoundException, IOException {
        this.fileName = fileN;
        this.inputStream = new FileInputStream(this.fileName);
        this.audioStream = new AudioStream(this.inputStream);
    }

    public void play() {
        AudioPlayer.player.start(this.audioStream);
    }

    public void stop() {
        AudioPlayer.player.stop(this.audioStream);
    }
}