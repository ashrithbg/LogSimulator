package com.logsimulator.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperations {
	private String path;
	
	public FileOperations(String path){
		this.path = path;
	}
	
	
	public FileInputStream readFile() throws FileNotFoundException, IOException{
			File file = new File(path);
			FileInputStream fileInput = new FileInputStream(file);
			return fileInput;
	}

	
	public void writeFile(StringBuilder sb){
		File file = new File(path);
		String content = sb.toString();
		try (FileOutputStream fop = new FileOutputStream(file)) {

			if (!file.exists()) {
				file.createNewFile();
			}

			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
