package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewsOrganizer extends Observable{
	private MachineModel model;
	private CodeViewPanel codeViewPanel;
	private MemoryViewPanel memoryViewPanel1;
	private MemoryViewPanel memoryViewPanel2;
	private MemoryViewPanel memoryViewPanel3;
	//private ControlPanel controlPanel;
	private ProcessorViewPanel processorPanel;
	private MenuBarBuilder menuBuilder;
	private JFrame frame;
	private FilesManager filesManager;
	private Animator animator;
	
	
	public MachineModel getModel() {
		return model;
	}
	public void setModel(MachineModel model) {
		this.model = model;
	}
	public void step(){
		if(model.getCurrentState() != States.PROGRAM_HALTED && model.getCurrentState() != States.NOTHING_LOADED){
			try{
				model.step();
			}
			catch (CodeAccessException e) {
				JOptionPane.showMessageDialog(frame,"Illegal access to code from line " + model.getInstructionPointer() + "\n"+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
			}
			catch (ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(frame,"Illegal access to data from line " + model.getInstructionPointer() + "\n"+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
			}
			catch (NullPointerException e) {
				JOptionPane.showMessageDialog(frame,"Illegal access to data from line " + model.getInstructionPointer() + "\n"+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(frame,"Illegal access to data from line " + model.getInstructionPointer() + "\n"+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
			}
			catch (DivideByZeroException e) {
				JOptionPane.showMessageDialog(frame,"Illegal access to data from line " + model.getInstructionPointer() + "\n"+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
			}
			setChanged();
			notifyObservers();
		}
	}
	public void execute(){
		while(model.getCurrentState() != States.PROGRAM_HALTED && model.getCurrentState() != States.NOTHING_LOADED){
			try{
				model.step();
			}
			catch (CodeAccessException e) {
				JOptionPane.showMessageDialog(frame,"Illegal access to code from line " + model.getInstructionPointer() + "\n"+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
			}
			catch (ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(frame,"Illegal access to data from line " + model.getInstructionPointer() + "\n"+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
			}
			catch (NullPointerException e) {
				JOptionPane.showMessageDialog(frame,"Illegal access to data from line " + model.getInstructionPointer() + "\n"+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(frame,"Illegal access to data from line " + model.getInstructionPointer() + "\n"+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
			}
			catch (DivideByZeroException e) {
				JOptionPane.showMessageDialog(frame,"Illegal access to data from line " + model.getInstructionPointer() + "\n"+ "Exception message: " + e.getMessage(), "Run time error", JOptionPane.OK_OPTION);
			}
		}
		setChanged();
		notifyObservers();
	}
	public void cleatJob(){
		
	}
	public void makeReady(String string){
		animator.setAutoStepOn(false);
		model.setCurrentState(States.PROGRAM_LOADED_NOT_AUTOSTEPPING);
		model.getCurrentState().enter();
		setChanged();
		notifyObservers(string);
	}
	private void createAndShowGUI(){
		animator = new Animator(this);
		filesManager = new FilesManager(this);
		codeViewPanel = new CodeViewPanel(this,model);
		memoryViewPanel1 = new MemoryViewPanel(this, model, 0, 240);
		memoryViewPanel2 = new MemoryViewPanel(this, model, 240, Memory.DATA_SIZE/2);
		memoryViewPanel3 = new MemoryViewPanel(this, model, Memory.DATA_SIZE/2, Memory.DATA_SIZE);
		processorPanel = new ProcessorViewPanel(this,model);
		frame = new JFrame("Simulator");
		frame.add(processorPanel.createProcessorDisplay(),BorderLayout.PAGE_START);
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		menuBuilder = new MenuBarBuilder(this);
		bar.add(menuBuilder.createFileMenu());
		bar.add(menuBuilder.createExecuteMenu());
		bar.add(menuBuilder.createJobsMenu());
		//controlPanel = new ControlPanel(this);
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout(2,1));
		content.setBackground(Color.BLACK);
		frame.setSize(1200, 600);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,3));
		frame.add(codeViewPanel.createCodeDisplay(),BorderLayout.LINE_START);
		center.add(memoryViewPanel1.createMemoryDisplay());
		center.add(memoryViewPanel2.createMemoryDisplay());
		center.add(memoryViewPanel3.createMemoryDisplay());
		frame.add(center, BorderLayout.CENTER);
		//**Return here for other GUI component
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// return HERE for other setup details
		frame.setVisible(true);
	}
	public States getCurrentState(){
		return model.getCurrentState();
	}
	public void setCurrentStates(States s){
		if(s == States.PROGRAM_HALTED) animator.setAutoStepOn(false);
		model.setCurrentState(s);
		model.getCurrentState().enter();
		setChanged();
		notifyObservers();
	}
	public void exit() { // method executed when user exits the program
		int decision = JOptionPane.showConfirmDialog(
				frame, "Do you really wish to exit?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		if (decision == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public void clearJob(){
		model.clearJob();
		model.setCurrentState(States.NOTHING_LOADED);
		model.getCurrentState().enter();
		setChanged();
		notifyObservers("Clear");
	}
	public void toggleAutoStep(){
		if(animator.isAutoStepOn()){
			animator.toggleAutoStep();
			model.setCurrentState(States.AUTO_STEPPING);
		}
		else{
			model.setCurrentState(States.PROGRAM_LOADED_NOT_AUTOSTEPPING);
		}
		model.getCurrentState().enter();
		setChanged();
		notifyObservers();
		
	}
	public void reload(){
		animator.setAutoStepOn(false);
		clearJob();
		filesManager.finalLoad_ReloadStep(model.getCurrentJob());
	}
	public void assembleFile(){
		filesManager.assembleFile();
	}
	public void loadFile(){
		filesManager.loadFile(model.getCurrentJob());
	}
	public void setPeriod(int value){
		animator.setPeriod(value);
	}
	public void setJob(int i){
		model.setJob(i);
		if(model.getCurrentState() != null){
			model.getCurrentState().enter();
			setChanged();
			notifyObservers();
		}
	}
	
	
	
	public JFrame getFrame() {
		return frame;
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewsOrganizer organizer = new ViewsOrganizer();
				MachineModel model = new MachineModel(
						() -> organizer.setCurrentStates(States.PROGRAM_HALTED)
				);
				organizer.setModel(model);
				organizer.createAndShowGUI();
			}
		});
	}
}
