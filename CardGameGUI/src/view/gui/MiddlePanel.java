package view.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MiddlePanel extends JPanel {
	MainFrame mFrame;
	
	SummaryPanel sPanel;
	CardPanel cPanel;
	
	public MiddlePanel(MainFrame mFrame) {
		this.mFrame = mFrame;
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
	}
	
	public void panelMaker() {
		sPanel = new SummaryPanel(mFrame);
		sPanel.construct();
		add(sPanel, BorderLayout.NORTH);
		
		cPanel = new CardPanel(mFrame);
		add(cPanel, BorderLayout.SOUTH);
	}

	public CardPanel getCPanel() {
		return cPanel;
	}
	
	public SummaryPanel getSPanel() {
		return sPanel;
	}
}
