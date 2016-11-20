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
	      
	        boolean change = false;
	        while (sc.hasNextLine()) {
	        	int i = 0;
	        	String temp = sc.nextLine();
	        	if(temp.equals("DATA")){
	        		change = true;
	        		i = 1;
	        	}
	        	if(change == false) code.add(temp);
	        	if(change == true && i == 0) data.add(temp);
	        	
	        	
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
					if(parts[0].equals("JUMP")){
						parts[1] = parts[1].substring(1);
						parts[0] = "JMPI";
					}
					else if(parts[0].equals("JMPZ")){
						parts[1] = parts[1].substring(1);
						parts[0] = "JMZI";
					}
					else{
						parts[1] = parts[1].substring(1);
						parts[0] += "I";
					}
					
				}
				else if(parts[1].startsWith("&")){
					parts[1] = parts[1].substring(1);
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
		File out = new File("factorial.pexe");
		assemble(in, out);
	}

}
