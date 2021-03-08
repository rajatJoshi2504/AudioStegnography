import java.io.File;
import javax.swing.filechooser.FileFilter;

class MyAudioFileFilter extends FileFilter {
	MyAudioFileFilter() {
	}

	@Override
	public boolean accept(File file) {
		return file.isDirectory() || file.getAbsolutePath().endsWith(".au"); 
	}
	
	@Override
	public String getDescription() {
		return ".au File (*.au)";
	}
}