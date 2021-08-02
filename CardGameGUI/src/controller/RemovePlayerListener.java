package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.gui.BottomPanel;
import view.gui.MainFrame;
import view.gui.SummaryPanel;

public class RemovePlayerListener implements ActionListener {
	GameEngine gEngine;
	JComboBox<Player> pComboBox;
	SummaryPanel sumPanel;
	BottomPanel sPanel;

	public RemovePlayerListener(MainFrame mFrame) {
		gEngine = mFrame.getGEngine();
		
		pComboBox = mFrame.getTPanel().getPComboBox();
		sumPanel = mFrame.getMPanel().getSPanel();
		sPanel = mFrame.getBPanel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Player p = (Player) pComboBox.getSelectedItem();
		
		if (p != null && !p.getPlayerId().equals("house")) {
			gEngine.removePlayer(p);
			pComboBox.removeItem(p);
			sumPanel.removePlayer(p);
			sPanel.setStatus(String.format("%s removed", p.getPlayerName()));
		} else if (p.getPlayerId().equals("house")) {
			sPanel.setStatus("Cannot remove House");
		} else {
			sPanel.setStatus("Invalid player");
		}
	}
}
