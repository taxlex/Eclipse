package project;

public class Code {
	public static final int CODE_MAX = 2048;
	public int[] code = new int[CODE_MAX];
	public int getOp(int i){
		return code[i*2];
	}
	public int getArg(int i){
		return code[i*2 + 1];
	}
	public void clear(int start, int end){
		for(int i = start; i<end; i++){
			code[2*i] = 0;
			code[2*i + 1] = 0;
		}
	}
	public String getText(int i){
		String s1 = Integer.toHexString(code[2*i]).toUpperCase();
		String s2 = Integer.toHexString(code[2*i + 1]).toUpperCase();
		if((code[2*i + 1]) < 0){
			s2 = "-" + Integer.toHexString(-code[2*i +1]).toUpperCase();
		}
		return s1 + " " + s2;
	}
	public void setCode(int i, int op, int arg){
		code[2*i] = op;
		code[2*i + 1] = arg;
	}
	public String getHex(int i){
		String temp = Integer.toHexString(code[2*i]).toUpperCase() + " " +Integer.toHexString(code[2*i+1]).toUpperCase();
		return temp;
	}
	public String getDecimal(int i){
		String temp = InstructionMap.mnemonics.get(code[2*i]) + " " + code[2*i+1];
		return temp;
	}
}
