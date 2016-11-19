package lab07;

public class Editor {
	private Buffer BU;
	private StatusBar SB;
	public Editor(Buffer aBU){
		BU = aBU;
		SB = new StatusBar(aBU);
	}
	void draw(){
		BU.draw();
		SB.draw();
		
	}
	void save(){
			BU.save();
	}
	void type(String str){
		BU.type(str);
	}
	
}
