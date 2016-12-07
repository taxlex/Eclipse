package project;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
public class ControlPanel implements Observer{
	private ViewsOrganizer view;
	private JButton stepButton = new JButton("Step");
	private JButton clearButton = new JButton("Clear");
	private JButton runButton = new JButton("Run/Pause");
	private JButton reloadButton = new JButton("Reload");
	
	public ControlPanel(ViewsOrganizer gui) {
		view = gui;
		gui.addObserver(this);
	}
	public JComponent createControlDisplay(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,0));
		stepButton.addActionListener(e -> view.step());
		panel.add(stepButton, JLabel.CENTER);
		panel.setLayout(new GridLayout(1,0));
		clearButton.addActionListener(e -> view.clearJob());
		panel.add(clearButton, JLabel.CENTER);
		panel.setLayout(new GridLayout(1,0));
		runButton.addActionListener(e -> view.toggleAutoStep());
		panel.add(runButton, JLabel.CENTER);
		panel.setLayout(new GridLayout(1,0));
		reloadButton.addActionListener(e -> view.reload());
		panel.add(reloadButton, JLabel.CENTER);
		JSlider slider = new JSlider(5,1000);
		slider.addChangeListener(e -> view.setPeriod(slider.getValue()));
		panel.add(slider);
		return panel;
		
	}
	@Override
	public void update(Observable arg0, Object arg1){
		runButton.setEnabled(view.getCurrentState().getRunPauseActive());
		reloadButton.setEnabled(view.getCurrentState().getReloadActive());
		clearButton.setEnabled(view.getCurrentState().getClearActive());
		stepButton.setEnabled(view.getCurrentState().getStepActive());
	}
}
