package project;

import java.util.Map;
import java.util.TreeMap;

public class MachineModel {
	 public final Map<Integer,Instruction> INSTRUCTIONS = new TreeMap<>();
	 private CPU cpu = new CPU();
	 private Memory memory = new Memory();
	 private HaltCallback callback;
	 
	 public MachineModel() {
			this(() -> System.exit(0));
	 }
	 public MachineModel(HaltCallback acallback){
		 callback = acallback;
		 
		 //INSTRUCTION_MAP entry for "NOP"
		 INSTRUCTIONS.put(0x0, arg ->{
			cpu.incrementIP();
		 });
		//INSTRUCTION_MAP entry for "LODI"
		 INSTRUCTIONS.put(0x1, arg ->{
			 cpu.setAccumulator(arg);
	         cpu.incrementIP();
		 });
		 
		//INSTRUCTION_MAP entry for "LOD"
		 INSTRUCTIONS.put(0x2, arg ->{
			 int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			 cpu.setAccumulator(arg1);
	         cpu.incrementIP();
		 });
		 
		//INSTRUCTION_MAP entry for "LODN"
		 INSTRUCTIONS.put(0x3, arg ->{
			 int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			 int arg2 = memory.getData(cpu.getMemoryBase() + arg1);
			 cpu.setAccumulator(arg2);
	         cpu.incrementIP();
		 });
		 
		//INSTRUCTION_MAP entry for "STO"
		 INSTRUCTIONS.put(0x4, arg ->{
			 memory.setData( cpu.getMemoryBase() + arg , cpu.getAccumulator());
	         cpu.incrementIP();
		 });
		 
		//INSTRUCTION_MAP entry for "STON"
		 INSTRUCTIONS.put(0x5, arg ->{
			 int arg1 = memory.getData(arg);
			 memory.setData( cpu.getMemoryBase() + arg1 , cpu.getAccumulator());
	         cpu.incrementIP();
		 });
		 
		//INSTRUCTION_MAP entry for "JMPI"
		 INSTRUCTIONS.put(0x6, arg ->{
			 cpu.setInstructionPointer(cpu.getInstructionPointer() + arg);
		 });
		 
		//INSTRUCTION_MAP entry for "JUMP"
		 INSTRUCTIONS.put(0x7, arg ->{
			 int arg1 = memory.getData(cpu.getMemoryBase() + arg);
			 cpu.setInstructionPointer(cpu.getInstructionPointer() + arg1);
		 });
		 
		 
		//INSTRUCTION_MAP entry for "JMZI"
		 INSTRUCTIONS.put(0x8, arg ->{
			 if(cpu.getAccumulator() == 0){
				 cpu.setInstructionPointer(cpu.getInstructionPointer() + arg);
			 }
			 else{
				 cpu.incrementIP();
			 }
		 });
		 
		//INSTRUCTION_MAP entry for "JMPZ"
		 INSTRUCTIONS.put(0x9, arg ->{
			 if(cpu.getAccumulator() == 0){
				 int arg1 = memory.getData(cpu.getMemoryBase() + arg);
				 cpu.setInstructionPointer(cpu.getInstructionPointer() + arg1);
			 }
			 else{
				 cpu.incrementIP();
			 }
		 });
		 
		 
		 
		 
		 
		 //INSTRUCTION_MAP entry for "ADDI"
		 INSTRUCTIONS.put(0xA, arg -> {
			 cpu.setAccumulator(cpu.getAccumulator() + arg);
	            cpu.incrementIP();
	     });

		 //INSTRUCTION_MAP entry for "ADD"
		 INSTRUCTIONS.put(0xB, arg -> {
			 int arg1 = memory.getData(cpu.getMemoryBase()+arg);
			 cpu.setAccumulator(cpu.getAccumulator() + arg1);
			 cpu.incrementIP();
		 });
		 //INSTRUCTION_MAP entry for "ADDN"
	     INSTRUCTIONS.put(0xC, arg -> {
	    	 int arg1 = memory.getData(cpu.getMemoryBase()+arg);
	    	 int arg2 = memory.getData(cpu.getMemoryBase()+arg1);
	    	 cpu.setAccumulator(cpu.getAccumulator() + arg2);
	    	 cpu.incrementIP();
	     });
	     
	     
	     
	     
	     //INSTRUCTION_MAP entry for "SUBI"
		 INSTRUCTIONS.put(0xD, arg -> {
			 cpu.setAccumulator(cpu.getAccumulator() - arg);
	         cpu.incrementIP();
	     });

		 //INSTRUCTION_MAP entry for "SUB"
		 INSTRUCTIONS.put(0xE, arg -> {
			 int arg1 = memory.getData(cpu.getMemoryBase()+arg);
			 cpu.setAccumulator(cpu.getAccumulator() - arg1);
			 cpu.incrementIP();
		 });
		 //INSTRUCTION_MAP entry for "SUBN"
	     INSTRUCTIONS.put(0xF, arg -> {
	    	 int arg1 = memory.getData(cpu.getMemoryBase()+arg);
	    	 int arg2 = memory.getData(cpu.getMemoryBase()+arg1);
	    	 cpu.setAccumulator(cpu.getAccumulator() - arg2);
	    	 cpu.incrementIP();
	     });
	     
	     
	     
	     
	     //INSTRUCTION_MAP entry for "MULI"
		 INSTRUCTIONS.put(0x10, arg -> {
			 cpu.setAccumulator(cpu.getAccumulator() * arg);
	         cpu.incrementIP();
	     });

		 //INSTRUCTION_MAP entry for "MUL"
		 INSTRUCTIONS.put(0x11, arg -> {
			 int arg1 = memory.getData(cpu.getMemoryBase()+arg);
			 cpu.setAccumulator(cpu.getAccumulator() * arg1);
			 cpu.incrementIP();
		 });
		 //INSTRUCTION_MAP entry for "MULN"
	     INSTRUCTIONS.put(0x12, arg -> {
	    	 int arg1 = memory.getData(cpu.getMemoryBase()+arg);
	    	 int arg2 = memory.getData(cpu.getMemoryBase()+arg1);
	    	 cpu.setAccumulator(cpu.getAccumulator() * arg2);
	    	 cpu.incrementIP();
	     });
	     
	     
	     
	   //INSTRUCTION_MAP entry for "DIVI"
		 INSTRUCTIONS.put(0x13, arg -> {
			 if(arg == 0) throw new DivideByZeroException();
			 else{
				 cpu.setAccumulator(cpu.getAccumulator() / arg);
				 cpu.incrementIP();
			 }
	     });

		 //INSTRUCTION_MAP entry for "DIV"
		 INSTRUCTIONS.put(0x14, arg -> {
			 int arg1 = memory.getData(cpu.getMemoryBase()+arg);
			 if(arg1 == 0) throw new DivideByZeroException();
			 else{
				 cpu.setAccumulator(cpu.getAccumulator() / arg1);
				 cpu.incrementIP();
			 }
		 });
		 //INSTRUCTION_MAP entry for "DIVN"
	     INSTRUCTIONS.put(0x15, arg -> {
	    	 int arg1 = memory.getData(cpu.getMemoryBase()+arg);
	    	 int arg2 = memory.getData(cpu.getMemoryBase()+arg1);
	    	 if(arg2 == 0 ) throw new DivideByZeroException();
	    	 else{
	    	 	cpu.setAccumulator(cpu.getAccumulator() / arg2);
	    	 	cpu.incrementIP();
	    	 }
	     });
	     
	     //INSTRUCTION_MAP entry for "ANDI"
		 INSTRUCTIONS.put(0x16, arg ->{
			 if(cpu.getAccumulator() != 0 && arg != 0){
				 cpu.setAccumulator(1);
			 }
			 else{
				 cpu.setAccumulator(0);
			 }
			 cpu.incrementIP();
		 });
		 
		//INSTRUCTION_MAP entry for "AND"
		 INSTRUCTIONS.put(0x17, arg ->{
			 if(cpu.getAccumulator() != 0 && memory.getData(cpu.getMemoryBase() + arg) != 0){
				 cpu.setAccumulator(1);
			 }
			 else{
				 cpu.setAccumulator(0);
			 }
			 cpu.incrementIP();
		 });
		 
		//INSTRUCTION_MAP entry for "NOT"
		 INSTRUCTIONS.put(0x18, arg ->{
			 if(cpu.getAccumulator() != 0){
				 cpu.setAccumulator(0);
			 }
			 else if(cpu.getAccumulator() == 0){
				 cpu.setAccumulator(1);
			 }
			 cpu.incrementIP();
		 });
		//INSTRUCTION_MAP entry for "CMPL"
		 INSTRUCTIONS.put(0x19, arg ->{
			 if(memory.getData(cpu.getMemoryBase() + arg) < 0){
				 cpu.setAccumulator(1);
			 }
			 else{
				 cpu.setAccumulator(0);
			 }
			 cpu.incrementIP();
		 });
		//INSTRUCTION_MAP entry for "CMPZ"
		 INSTRUCTIONS.put(0x1A, arg ->{
			 if(memory.getData(cpu.getMemoryBase() + arg) == 0){
				 cpu.setAccumulator(1);
			 }
			 else{
				 cpu.setAccumulator(0);
			 }
			 cpu.incrementIP();
		 });
		 //INSTRUCTION_MAP entry for "HALT"
		 INSTRUCTIONS.put(0x1F, arg -> {
				callback.halt();			
		 });
	     
	 }
	public int getAccumulator() {
		return cpu.getAccumulator();
	}
	public void setAccumulator(int accumulator) {
		cpu.setAccumulator(accumulator);
	}
	public int getInstructionPointer() {
		return cpu.getInstructionPointer();
	}
	public void setInstructionPointer(int instructionPointer) {
		cpu.setInstructionPointer(instructionPointer);
	}
	public int getMemoryBase() {
		return cpu.getMemoryBase();
	}
	public void setMemoryBase(int memoryBase) {
		cpu.setMemoryBase(memoryBase);
	}
	
	int[] getData(){
		return memory.getData();
	}
	public int getData(int index){
		return memory.getData(index);
	}
	public void setData(int index, int value){
		memory.setData(index, value);
	}
	public Instruction get(int i){
		return INSTRUCTIONS.get(i);
	}
}
