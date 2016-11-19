package assignment08.driver;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import assignment08.model.BurgerModel;
import assignment08.model.ConcreteBurgerModel;
import assignment08.view.DynamicScreenManager;
import assignment08.view.ScreenBuilder;
import assignment08.view.ScreenDirector;

public class Client {
	private static BurgerModel burger = ConcreteBurgerModel.getHandle();
	private static ScreenBuilder screenBuilder = new ScreenBuilder();
	private static DynamicScreenManager screen;

	public static void main(String[] args) {
		try {
	        UIManager.setLookAndFeel(
	            UIManager.getCrossPlatformLookAndFeelClassName());
	    } catch (Exception e) { 
	    	e.printStackTrace();
	    }

		//Schedule a job for the event-dispatching thread:
	    //creating and showing this application's GUI.
		// see http://download.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	int i = JOptionPane.showConfirmDialog(null, "THIS APPLICATION FILLS YOUR SCREEN\n" +
	        			"Do not run it until you know how to close\n" +
	        			"an application from the keyboard.\n" +
	        			"On Linux and Windows use ALT-F4.\n" +
	        			"On Mac, it may be Command+W\n" +
	        			"--test it using another window first!");
	        	if(i == JOptionPane.OK_OPTION) {
	        		screen = DynamicScreenManager.getHandle();
	        		screen.setFrame(ScreenDirector.buildScreen(screenBuilder, burger));
	        		screen.update();
	        	}
	        }
	    });
	}
}
