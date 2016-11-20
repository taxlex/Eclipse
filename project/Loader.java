package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Loader {
	public static String load(MachineModel model, File file, int codeOffset, int memoryOffset){
		int codeSize = 0;
		if(model == null || file == null) return null;
		try {

	        Scanner input = new Scanner(file);
	        boolean incode = true;
	        while(input.hasNextLine()){
	        	String temp = input.nextLine();
	        	//System.out.println(temp);
	        	Scanner parser = new Scanner(temp);
	        	int next = parser.nextInt(16);
	        	if(incode == true && next == -1) incode = false;
	        	else if(incode == true && next != -1){
	        		int after = parser.nextInt(16);
	        		model.setCode(codeOffset + codeSize, next, after);
	        		codeSize++;
	        	}
	        	else if(incode == false){
	        		int val = parser.nextInt(16);
	        		model.setData(memoryOffset + next, val);
	        	}
	        	parser.close();
	        	
	        }
	        
	        
	        input.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	        return "File " + file.getName() + " Not Found";
	    }
		catch(ArrayIndexOutOfBoundsException e){
			return "Array Index" + e.getMessage();
		}
		catch(NoSuchElementException e){
			return "From Scanner: NoSuchElementException";
		}
		return "" + codeSize; 
	}
	
	public static void main(String[] args) {
		MachineModel model = new MachineModel();
		String s = Loader.load(model, new File("factorial.pexe"),100,200);
		for(int i = 100; i < 100+Integer.parseInt(s); i++) {
			System.out.println(model.getCode().getText(i));			
		}
		System.out.println(200 + " " + model.getData(200));
	}
}
