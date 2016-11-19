package assignment07;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static java.awt.Color.*;

public class PlayAreaView extends JPanel {
	private static final long serialVersionUID = -3431414751840044608L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 400;
	private JFrame frame = new JFrame("NIM");
	private static final BasicStroke wideStroke = new BasicStroke(8);
	private static final Font font = new Font("Dialog",Font.BOLD, 18); 
	private Stick[] sticks;
	private int numSticks; 
	private Color[] colors = {YELLOW, RED, WHITE, CYAN, GREEN, MAGENTA, 
			ORANGE, PINK, BLUE};
	// Omit ALL GRAY and BLACK
	// NOTE THAT import static java.awt.Color.*;
	// allows use to write BLUE instead of Color.BLUE, etc.

	public PlayAreaView(int numSticks) {
		this.numSticks = numSticks; 
		if(numSticks > 0) {
			sticks = new Stick[numSticks];
			int colorIndex = 0;
			for(int i = 0; i < sticks.length; i++) {
				sticks[i] = new Stick(colors[colorIndex++%colors.length]);
			}
		}
		frame.setSize(400,400);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void remove(int num) {
		numSticks -= num;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		Graphics2D graphics = (Graphics2D)g;
		graphics.setStroke(wideStroke);
		if (sticks != null) {
			for(int i = 0; i < numSticks; i++)	{
				sticks[i].draw(graphics);
			}
		}
		graphics.setColor(WHITE);
		graphics.setFont(font);
		graphics.drawString("#Sticks = " + numSticks, 10, 30);
	}	

}