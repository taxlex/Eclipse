package assignment07;
import Assignment6.UndergradCourse;
public class CSGenedCourse extends UndergradCourse {
	public enum CSGened {
	    A, B, C, F1, G, H, J, L, M, N, O, P, S, Y
	}
	public CSGened[] geneds;
	public CSGenedCourse(CSGened[] arry){
		super("className");
		geneds = new CSGened[arry.length];
		for(int i = 0; i < arry.length ; i++){
			geneds[i] = arry[i];
		}
	}
	public CSGened[] getGeneds(){
		return geneds;
	}
}
