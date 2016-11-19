package assignment07;

public class Driver {
	public static void main(String[] args){
		//A, B, C, F1, G, H, J, L, M, N, O, P, S, Y
		UndergradStudent ugstu = new UndergradStudent("Me");
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.B}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.J}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.F1, CSGenedCourse.CSGened.P, CSGenedCourse.CSGened.N}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.G, CSGenedCourse.CSGened.C}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.C}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.A}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.H}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.L}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.M}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.P}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.N}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.S}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.Y}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.O}));
		System.out.println(ugstu.satisfiesCSGened());
		UndergradStudent ugst = new UndergradStudent("Me");
		ugst.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.B}));
		ugst.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.J}));
		ugst.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.F1, CSGenedCourse.CSGened.P, CSGenedCourse.CSGened.N}));
		ugst.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.G, CSGenedCourse.CSGened.C}));
		ugst.getAllCourses().add(new CSGenedCourse(new CSGenedCourse.CSGened[] {CSGenedCourse.CSGened.C}));
		System.out.println(ugst.satisfiesCSGened());
	}
}
