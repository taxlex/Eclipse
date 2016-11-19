package lab07;

public class StatusBar extends Buffer {
	private Buffer attachedTo;
	public StatusBar(Buffer aattachedTo){
		attachedTo = aattachedTo;
	}
	@Override
	String getText(){
		StringBuilder sb = new StringBuilder();
		sb.append("----- lines: ");
		sb.append(attachedTo.getNumlines());
		sb.append("-----");
		String str = sb.toString();
		return str;
	}

}
