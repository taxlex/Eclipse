package Assignment6;

import java.util.Random;
import java.util.Set;

public class UndergradStudent extends Student {
	public UndergradStudent(String amajor){
		super(amajor);
	}
	@Override
	public boolean isUndergrad(){
		return true;
	}
	public int countUndergrad(Set<Course> sch){
		int inc = 0;
		for(Course i : sch){
			if(i.isGrad() == true) inc++;
		}
		return inc;
	}
	@Override
	public void adjustSchedule(){
		Random rand = new Random();
		int x = 0;
		while(countUndergrad(getSchedule()) > 2){
			for(Course i : getSchedule()){
				if(i.isGrad() == true){
					getSchedule().remove(i);
					while(getSchedule().add(new Course(Question1.name(x))) == false){
						x = rand.nextInt(308915776);
					}
					getSchedule().add(new Course(Question1.name(x)));
				}
			}
		}
		
	}
}
