package lab07;

import java.util.List;

public class Buffer {
	protected List<String> lines;
	public int getNumlines(){
		return lines.size();
	}
	String getText(){
		return String.join("\n",  this.lines);
	}
	void draw(){
		System.out.println(this.getText());
	}
	void save(){
		throw new UnsupportedOperationException("Not supported");
	}
	void type(String toType){
		if(lines.isEmpty() == true) lines.add("");
		for(int i =0; i< toType.length(); i++){
			if(toType.charAt(i)=='\n') lines.add("");
			else lines.set(lines.size()-1, lines.get(lines.size()-1)+toType.charAt(i));
		}
	}
}
