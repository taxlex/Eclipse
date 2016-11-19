package Assignment6;

import java.util.Random;
import java.util.Set;

public class GraduateStudent extends Student {
	private String undergradMajor;
	
	public GraduateStudent(String amajor, String aundergradMajor){
		super(amajor);
		undergradMajor = aundergradMajor;
	}
	@Override
	public boolean isGrad(){
		return true;
	}
	public int countUndergrad(Set<Course> sch){
		int inc = 0;
		for(Course i : sch){
			if(i.isUndergrad() == true) inc++;
		}
		return inc;
	}
	@Override
	public void adjustSchedule(){
		Random rand = new Random();
		int x = 0;
		while(countUndergrad(getSchedule()) > 1){
			for(Course i : getSchedule()){
				if(i.isUndergrad() == true){
					getSchedule().remove(i);
					while(getSchedule().add(new Course(Question1.name(x))) == false){
						x = rand.nextInt(308915776);
					}
					getSchedule().add(new Course(Question1.name(x)));
				}
			}
		}
		
	}
	@Override
	public boolean hasUndergradClass(){
		boolean x = false;
		for(Course a : getSchedule()){
			if(a.isUndergrad() == true) x = true;
		}
		return x;
	}
}
