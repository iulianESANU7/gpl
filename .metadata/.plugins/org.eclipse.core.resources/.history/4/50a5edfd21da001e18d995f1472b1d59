package chrono;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * This class manages the dashboard (hour, minute, second) of chronometer GUI.
 * 
 * This class is only responsible of graphical result printing.
 * 
 * There is no algorithmic processing in this class.
 * 
 * @author tliu@u-cergy.fr
 * 
 */
public class Dashboard extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Hour, minute and second have their initial positions.
	 */
	private int hourPositionX = 400;
	private int hourPositionY = 50;
	private int minutePositionX = 400;
	private int minutePositionY = 50;
	private int secondPositionX = 400;
	private int secondPositionY = 50;

	/**
	 * Defines what to do when the repaint() method is called.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLUE);

//		g.drawOval(50, 50, 200, 200);
		g.drawOval(300, 50, 200, 200);
//		g.drawOval(550, 50, 200, 200);

		g.drawLine(400, 150, hourPositionX+250, hourPositionY);
		g.setColor(Color.RED);
		g.drawLine(400, 150, minutePositionX, minutePositionY);
		g.setColor(Color.BLACK);
		g.drawLine(400, 150, secondPositionX-250, secondPositionY);
	}

	public void setHourPositionX(int hourPositionX) {
		this.hourPositionX = hourPositionX;
	}

	public void setHourPositionY(int hourPositionY) {
		this.hourPositionY = hourPositionY;
	}

	public void setMinutePositionX(int minutePositionX) {
		this.minutePositionX = minutePositionX;
	}

	public void setMinutePositionY(int minutePositionY) {
		this.minutePositionY = minutePositionY;
	}

	public void setSecondPositionX(int secondPositionX) {
		this.secondPositionX = secondPositionX;
	}

	public void setSecondPositionY(int secondPositionY) {
		this.secondPositionY = secondPositionY;
	}
}
