package lab07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileBuffer extends Buffer {
	private String filename;
	public FileBuffer(String afilename){
		filename = afilename;
		try{
			super.lines = (Files.readAllLines(Paths.get(filename)));
		}
		catch(IOException e){
			super.lines = new ArrayList<>();
		}
	}
	@Override
	void save(){
		try{
			java.nio.file.Files.write(Paths.get(filename), super.lines);
		}
		catch(IOException e){
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}
}
