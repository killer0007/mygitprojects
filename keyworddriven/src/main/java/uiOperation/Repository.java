package uiOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Repository {
	Properties p = new Properties();
public Properties getrepo() throws IOException {
	
	File file = new File("C:\\Users\\gopin\\git\\keyworddriven\\src\\main\\java\\objects\\object.properties");
	FileInputStream fis = new FileInputStream(file);
	p.load(fis);
	return p;
}
}
