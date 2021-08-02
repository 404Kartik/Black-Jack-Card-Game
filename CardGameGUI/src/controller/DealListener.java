package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.gui.BottomPanel;
import view.gui.CardPanel;
import view.gui.MainFrame;
import view.gui.SummaryPanel;
import view.model.PlayerState;

public class DealListener implements ActionListener {
	GameEngine gEngine;
	PlayerState pState;
	CardPanel cPanel;
	JComboBox<Player> pComboBox;
	SummaryPanel sumPanel;
	BottomPanel sPanel;
	
	public DealListener(MainFrame mFrame) {
		
		pComboBox = mFrame.getTPanel().getPComboBox();
		sumPanel = mFrame.getMPanel().getSPanel();
		sPanel = mFrame.getBPanel();
		gEngine = mFrame.getGEngine();
		pState = mFrame.getPState();
		cPanel = mFrame.getMPanel().getCPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cPanel.removeAll();
		// TODO Auto-generated method stub
		Player currentPlayer = (Player) pComboBox.getSelectedItem();
		//cPanel.gethasDelt().add(currentPlayer.getPlayerId());
		if (currentPlayer != null) {
			if (currentPlayer.getPlayerId().equals("house") && pState.hasAllPDealt()) {
				
				new Thread() {
					@Override
					public void run() {
					// call long running GameEngine methods on separate thread
						sPanel.setStatus("Dealing House");
						gEngine.dealHouse(400);
						pState.setLastDealt(null);
						pState.clearDealtPlayers();
					}
				}.start();
			} else if (currentPlayer.getPlayerId().equals("house") && !pState.hasAllPDealt()) {
				sPanel.setStatus("Not all players have been dealt yet");
			} else if (currentPlayer.getBet() > 0 && !pState.isPDealing(currentPlayer) && !pState.hasBeenDealt(currentPlayer)) {
				new Thread() {
					@Override
					public void run() {
					// call long running GameEngine methods on separate thread
						sPanel.setStatus(String.format("Dealing %s", currentPlayer.getPlayerName()));
						pState.setPDealing(currentPlayer);
						gEngine.dealPlayer(currentPlayer, 400);
						pState.addP(currentPlayer);
						pState.setPDealing(null);
						pState.setLastDealt(currentPlayer);
					}
				}.start();
			} else if (pState.isPDealing(currentPlayer)) {
				sPanel.setStatus(String.format("%s is currently dealing", currentPlayer.getPlayerName()));
			} else if (pState.hasBeenDealt(currentPlayer)) {
				sPanel.setStatus(String.format("%s has already been dealt", currentPlayer.getPlayerName()));
			} else {
				
				sPanel.setStatus(String.format("%s hasn't placed a bet", currentPlayer.getPlayerName()));
			}
		} else {
			sPanel.setStatus("Invalid player");
		}
	}

}
