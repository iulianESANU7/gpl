package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This panel contains information for understanding better that printed line and trains.
 * 
 * @see Dashboard
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class InfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	
	private JLabel blockLabel = new JLabel("B : Block     ");
	private JLabel trainLabel = new JLabel("T : Train     ");
	private JLabel stationLabel = new JLabel("S : station");

	public InfoPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		setBackground(Color.WHITE);
		
		blockLabel.setFont(font);
		trainLabel.setFont(font);
		stationLabel.setFont(font);
		
		add(blockLabel);
		add(trainLabel);
		add(stationLabel);
	}
}
