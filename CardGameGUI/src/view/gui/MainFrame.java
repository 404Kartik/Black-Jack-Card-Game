package view.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import model.interfaces.GameEngine;
import view.model.PlayerState;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	GameEngine gEngine;
	PlayerState pState;
	
	TopPanel tPanel;
	MiddlePanel mPanel;
	BottomPanel bPanel;
	
	public MainFrame(GameEngine gEngine) {
		super("CardGameGUITemplate");
		
		this.gEngine = gEngine;
		
		pState = new PlayerState(this);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		setMinimumSize(new Dimension((int) d.getWidth() / 2, (int) d.getHeight() / 2));
		setBounds((int) (d.getWidth() / 2 - d.getWidth() / 4), (int) (d.getHeight() / 2 - d.getHeight() / 4),
				(int) (d.getWidth() / 2), (int) (d.getHeight() / 2));
		setLayout(new BorderLayout());
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public GameEngine getGEngine() {
		return gEngine;
	}
	
	public PlayerState getPState() {
		return pState;
	}

	public void construct() {
		bPanel = new BottomPanel(this);
		bPanel.construct();
		add(bPanel, BorderLayout.SOUTH);
		
		mPanel = new MiddlePanel(this);
		mPanel.panelMaker();
		add(mPanel, BorderLayout.CENTER);
		
		tPanel = new TopPanel(this);
		tPanel.createLayout();
		add(tPanel, BorderLayout.NORTH);
		
		repaint();
		revalidate();
	}
	
	public TopPanel getTPanel() {
		return tPanel;
	}
	
	public MiddlePanel getMPanel() {
		return mPanel;
	}
	
	public BottomPanel getBPanel() {
		return bPanel;
	}
}
