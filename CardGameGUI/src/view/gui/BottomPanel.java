package view.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BottomPanel extends JPanel {
	JLabel sLabel;
	
	public BottomPanel(MainFrame mFrame) {
		setLayout(new BorderLayout());
	}
	
	public void construct() {
		sLabel = new JLabel("Start game by Adding Players...");
		add(sLabel, BorderLayout.WEST);
	}
	
	public void setStatus(String currentStatus) {
		sLabel.setText(currentStatus);
	}
}
