import java.io.File;
import javax.swing.filechooser.FileFilter;

class MyTextFileFilter extends FileFilter {
	MyTextFileFilter() {
	}

	@Override
	public boolean accept(File file) {
		return file.isDirectory() || file.getAbsolutePath().endsWith(".txt");
	}

	@Override
	public String getDescription() {
		return "Text Documents (*.txt)";
	}
}