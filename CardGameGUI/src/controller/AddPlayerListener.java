package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.gui.BottomPanel;
import view.gui.MainFrame;
import view.gui.SummaryPanel;

public class AddPlayerListener implements ActionListener {
	JComboBox<Player> pComboBox;
	SummaryPanel sumPanel;
	BottomPanel sPanel;
	
	GameEngine gEngine;
	
	public AddPlayerListener(MainFrame mFrame) {
		gEngine = mFrame.getGEngine();
		
		pComboBox = mFrame.getTPanel().getPComboBox();
		sumPanel = mFrame.getMPanel().getSPanel();
		sPanel = mFrame.getBPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String pId = (String) JOptionPane.showInputDialog("Player Id:");
		String pName = (String) JOptionPane.showInputDialog("Player Name:");
		int pPoints = Integer.parseInt(JOptionPane.showInputDialog("Player Points:"));
		
		if (!pId.equals("house")) {
			Player p = new SimplePlayer(pId, pName, pPoints);
			
			if (gEngine.getPlayer(pId) != null) {
				pComboBox.removeItem(gEngine.getPlayer(pId));
				sumPanel.removePlayer(p);
			}
			
			gEngine.addPlayer(p);
			
			pComboBox.addItem(p);
			sumPanel.newPlayer(p);
			sPanel.setStatus(String.format("%s added", p.getPlayerName()));
		} else {
			sPanel.setStatus("Invalid Player ID");
		}
	}

}
