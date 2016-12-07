package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Assembler {
	
	public static String assemble(File input, File output){
		//Error checking
		String returnValue = "";
		try{
			Scanner ec = new Scanner(input);
			ArrayList<String> inText = new ArrayList<String>();
			while(ec.hasNextLine()){
				inText.add(ec.nextLine());
			}
			int lineNum = 0;
			for(int i = 0; i < inText.size(); i++){
				if(inText.get(i).trim().length() == 0 && returnValue.length() == 0 && i+1 != inText.size()){
					if(inText.get(i+1).trim().length() > 0){
						returnValue = "Error: line " + (lineNum+1) + " is a blank line";
					}
				}
				if(inText.get(i).trim().length() > 0 && returnValue.length() == 0){
					if((inText.get(i).charAt(0) == ' ' && returnValue.length() == 0) || (inText.get(i).charAt(0) == '\t' && returnValue.length() == 0)){
						returnValue = "Error: line " + (lineNum+1) + " starts with white space";
					}
				}
				if(inText.get(i).trim().toUpperCase().equals("DATA") && returnValue.length() == 0){
					if(inText.get(i).trim().equals("DATA")){
					}
					else{
						returnValue = "Error: line " + (lineNum+1) + " does not have DATA in upper case";
					}
				}
				if(returnValue.length() == 0){
					lineNum++;
				}
			}
			//cd = code, dt = data
			ArrayList<String> cd = new ArrayList<>();
			ArrayList<String> dt = new ArrayList<>();
			boolean chg = false;
			for(String a: inText) {
	        	int i = 0;
	        	if(a.trim().equals("DATA")){
	        		chg = true;
	        		i = 1;
	        	}
	        	if(chg == false) cd.add(a);
	        	if(chg == true && i == 0) dt.add(a);
	        	
	        	
	        }
			//fin is used to decide up to where the for loop should go up to
			int fin = 0;
			if((returnValue.length() == 0)|| lineNum > cd.size()){
				System.out.println(lineNum);
				fin = cd.size();
			}
			else if(lineNum < cd.size()){
				fin = lineNum;
			}
			
			for(int i = 0; i < fin; i++){
				String[] parts = cd.get(i).trim().split("\\s+");
				if(parts.length == 2){
					//checks if mnemonic exists
					if(InstructionMap.sourceCodes.contains(parts[0].toUpperCase())){
						//checks if mnemonic is in upper case
						if(InstructionMap.sourceCodes.contains(parts[0]) == false){
							returnValue = "Error: line " + (i+1) + " does not have the instruction mnemonic in upper case";
							lineNum = i+1;
							break;
						}
					}
					//if mnemonic doesn't exist
					else if(InstructionMap.sourceCodes.contains(parts[0]) == false){
						returnValue = "Error: line " + (i+1) + " the instruction mnemonic does not exist";
						lineNum = i+1;
						break;
					}
					//if mnemonic exists but should be length 1
					if(InstructionMap.noArgument.contains(parts[0].toUpperCase())){
						//in upper case
						if(InstructionMap.noArgument.contains(parts[0])){
							returnValue = "Error: line " + (i+1) + " has an illegal argument";
							lineNum = i+1;
							break;
						}
						//not in upper case
						else if(InstructionMap.noArgument.contains(parts[0]) == false){
							returnValue = "Error: line " + (i+1) + " has an illegal argument and is not in upper case";
							lineNum = i+1;
							break;
						}
					}
					if(parts[1].startsWith("#")){
						if(InstructionMap.immediateOK.contains(parts[0]) == false){
							returnValue = "Error: line " + (i+1) + " has an illegal argument";
							lineNum = i+1;
							break;
						}
						else{
							parts[1] = parts[1].substring(1);
							int arg = 0; 
							try {
								arg = Integer.parseInt(parts[1],16);
							} catch (NumberFormatException e) {
								returnValue = "Error: line " + (i+1) + " does not have a numberic argument";
								lineNum = i+1;
								break;
							}
						}
					}
					if(parts[1].startsWith("&")){
						if(InstructionMap.indirectOK.contains(parts[0]) == false){
							returnValue = "Error: line " + (i+1) + " has an illegal argument";
							lineNum = i+1;
							break;
						}
						else{
							parts[1] = parts[1].substring(1);
							int arg = 0; 
							try {
								arg = Integer.parseInt(parts[1],16);
							} catch (NumberFormatException e) {
								returnValue = "Error: line " + (i+1) + " does not have a numberic argument";
								lineNum = i+1;
								break;
							}
						}
					}
				}
				else if(parts.length == 1){
					//checks if mnemonic exist in noArgument
					if(InstructionMap.noArgument.contains(parts[0].toUpperCase())){
						//checks if mnemonic is in upper case
						if(InstructionMap.noArgument.contains(parts[0]) == false){
							returnValue = "Error: line " + (i+1) + " does not have the instruction mnemonic in upper case";
							lineNum = i+1;
							break;
						}
					}
					//checks if mnemonic exists at all
					else if(InstructionMap.sourceCodes.contains(parts[0].toUpperCase())){
						//if the mnemonic does exist but shouldn't be length 1
						if(InstructionMap.sourceCodes.contains(parts[0])){
							returnValue = "Error: line " + (i+1) + " is missing an argument";
							lineNum = i+1;
							break;
						}
						//if the mnemonic does exist but shouldn't be length 1 and isn't upper case
						else if(InstructionMap.sourceCodes.contains(parts[0]) == false){
							returnValue = "Error: line " + (i+1) + " does not have the instruction mnemonic in upper case nad is missing an argument";
							lineNum = i+1;
							break;
						}
					}
					//if mnemonic doesn't exist at all
					else if(InstructionMap.sourceCodes.contains(parts[0]) == false){
						returnValue = "Error: line " + (i+1) + " the instruction mnemonic does not exist";
						lineNum = i+1;
						break;
					}
				}
				else if(parts.length > 2){
					returnValue = "Error: line " + (i+1) + " has more than one argument";
					lineNum = i+1;
					break;
				}
				
			}
			if(fin == cd.size() && lineNum > cd.size()){
				fin = lineNum - fin -1;
				for(int i = 0; i < fin; i++){
					System.out.println(i);
					String[] parts = dt.get(i).trim().split("\\s+");
					if(parts[0].equals("")) break;
					if(parts.length != 2){
						returnValue = "Error: line " + (i+2+cd.size()) + " does not have two arguments";
						break;
					}
					int arg = 0; 
					try {
						arg = Integer.parseInt(parts[1],16);
					} catch (NumberFormatException e) {
						returnValue = "Error: line " + (i+2+cd.size()) + " does not have a numberic argument";
						break;
					}
					try {
						arg = Integer.parseInt(parts[0],16);
					} catch (NumberFormatException e) {
						returnValue = "Error: line " + (i+2+cd.size()) + " does not have a numberic argument";
						break;
					}
				}
			}
			
			
			
			
			
			
			ec.close();
			
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		
		if(returnValue.length() == 0){
			ArrayList<String> code = new ArrayList<>();
			ArrayList<String> data = new ArrayList<>();
			ArrayList<String> outText = new ArrayList<>();
			try {
	
		        Scanner sc = new Scanner(input);
		      
		        boolean change = false;
		        while (sc.hasNextLine()) {
		        	int i = 0;
		        	String temp = sc.nextLine();
		        	if(temp.trim().isEmpty()) break;
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
						if(parts[0].equals("JUMP")){
							parts[1] = parts[1].substring(1);
							parts[0] = "JMPN";
						}
						else{
							parts[1] = parts[1].substring(1);
							parts[0] += "N";
						}
						
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
	else{
		return returnValue;
	}
	}
	
	
	
	
	public static void main(String[] args){
		File in = new File("in.txt");
		File out = new File("factorial.pexe");
		System.out.println(assemble(in, out));
	}

}
