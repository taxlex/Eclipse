package lab07;

public class Driver {

	public static void main(String[] args) throws Exception{
		FileBuffer r = new FileBuffer("test.txt");
		Editor ed = new Editor(r);
		ed.type("Hello World");
		ed.type("\nWorld");
		ed.save();
		ScratchBuffer sb = new ScratchBuffer();
		Editor sed = new Editor(sb);
		sed.type("Hello World");
		sed.draw();
		ShellBuffer shb = new ShellBuffer();
		Editor shed = new Editor(shb);
		shed.type("pwd");
		shed.type("ls");
		shed.type("gedit test.txt");
		shed.type("rm test.txt");
		shed.type("ls");
		shed.draw();
		
	}

}
