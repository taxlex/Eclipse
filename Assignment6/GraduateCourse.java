package Assignment6;

public class GraduateCourse extends Course {
	GraduateCourse(String atitle){
		super(atitle);
	}
	@Override
	public boolean isUndergrad(){
		return false;
	}
	@Override
	public boolean isGrad(){
		return true;
	}
}
