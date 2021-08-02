package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.interfaces.Player;
import view.gui.BottomPanel;
import view.gui.MainFrame;
import view.gui.SummaryPanel;

public class ResetBetListener implements ActionListener {
	JComboBox<Player> pComboBox;
	SummaryPanel sumPanel;
	BottomPanel sPanel;
	
	public ResetBetListener(MainFrame mFrame) {
		pComboBox = mFrame.getTPanel().getPComboBox();
		sumPanel = mFrame.getMPanel().getSPanel();
		sPanel = mFrame.getBPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Player p = (Player) pComboBox.getSelectedItem();
		
		if (p != null) {
			if (!p.getPlayerId().equals("house")) {
				p.resetBet();
				sumPanel.updatePBet(p);
				sPanel.setStatus(String.format("%s Reset Bet by", p.getPlayerName()));
			} else {
				sPanel.setStatus("House cannot bet");
			}
		} else {
			sPanel.setStatus("Invalid player");
		}
	}
}
