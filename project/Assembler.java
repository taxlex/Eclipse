package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Assembler {
	
	public static String assemble(File input, File output){
		ArrayList<String> code = new ArrayList<>();
		ArrayList<String> data = new ArrayList<>();
		ArrayList<String> outText = new ArrayList<>();
		try {

	        Scanner sc = new Scanner(input);
	        boolean datayesno = false;

	        while (sc.hasNextLine()) {
	        	if(sc.nextLine().trim().equals("DATA")){
	        		datayesno = true;
	        	}
	        	if(datayesno == false){
	        		code.add(sc.nextLine());
	        	}
	        	else if (datayesno == true){
	        		data.add(sc.nextLine());
	        	}
	            
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		for(String ln: code){
			String[] parts = ln.trim().split("\\s+");
			if(parts.length == 2){
				if(parts[1].startsWith("#")){
					if(parts[0] == "JUMP"){
						parts[0] = "JMPI";
					}
					else if(parts[0] == "JMPZ"){
						parts[0] = "JMZI";
					}
					else{
						parts[1].substring(1);
						parts[0] += "I";
					}
					
				}
				else if(parts[1].startsWith("&")){
					parts[1].substring(1);
					parts[0] += "N";
				}
			}
			int opcode = InstructionMap.opcode.get(parts[0]);
			if(parts.length == 1){
				String add = Integer.toHexString(opcode).toUpperCase() + " 0";
				outText.add(add);
			}
			if(parts.length == 2){
				 String add =Integer.toHexString(opcode).toUpperCase() + " " + parts[1];
				 outText.add(add);
			}
		}
		outText.add("-1");
		outText.addAll(data);
		try {
			PrintWriter out = new PrintWriter(output);
			for(String ln: outText){
				out.println(ln);
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	
	
	public static void main(String[] args){
		File in = new File("in.txt");
		File out = new File("out.txt");
		assemble(in, out);
	}

}
