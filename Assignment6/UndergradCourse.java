package Assignment6;

public class UndergradCourse extends Course {
	public UndergradCourse(String atitle){
		super(atitle);
	}
	@Override
	public boolean isUndergrad(){
		return true;
	}
	@Override
	public boolean isGrad(){
		return false;
	}
}
