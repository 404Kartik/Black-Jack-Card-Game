package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.interfaces.Player;
import view.gui.BottomPanel;
import view.gui.MainFrame;
import view.gui.SummaryPanel;
import view.gui.TopPanel;

public class PBetListener implements ActionListener {
	JComboBox<Player> pComboBox;
	SummaryPanel sumPanel;
	BottomPanel sPanel;
	TopPanel tPanel;	

	public PBetListener(MainFrame mFrame) {
		pComboBox = mFrame.getTPanel().getPComboBox();
		sumPanel = mFrame.getMPanel().getSPanel();
		sPanel = mFrame.getBPanel();
		tPanel=mFrame.getTPanel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
		Player p = (Player) pComboBox.getSelectedItem();

		if (p != null) {
			if (!p.getPlayerId().equals("house")) {
				
				
				int bet = Integer.parseInt(JOptionPane.showInputDialog("Insert Bet Amount:"));

				if (p.setBet(bet)) {
					tPanel.getDButton().setEnabled(true);
					sumPanel.updatePBet(p);
					sPanel.setStatus(String.format("%s set bet of %d", p.getPlayerName(), bet));
				} else {
					sPanel.setStatus(String.format("%s has insufficient funds", p.getPlayerName()));
				} 
			} else {
				sPanel.setStatus("House cannot bet");
			}
		} else {
			sPanel.setStatus("Invalid player");
		}
	}

}
