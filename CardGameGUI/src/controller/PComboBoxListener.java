package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import model.interfaces.Player;
import view.gui.BottomPanel;
import view.gui.CardPanel;
import view.gui.MainFrame;
import view.gui.TopPanel;

public class PComboBoxListener implements ItemListener {
	JComboBox<Player> pComboBox;
	BottomPanel sPanel;
	CardPanel cPanel;
	TopPanel tPanel;	
	private static final String houseName ="house";
	private static final boolean TRUE = true;
	private static final boolean FALSE = false;
	
	public PComboBoxListener(MainFrame mFrame) {
		cPanel = mFrame.getMPanel().getCPanel();
		pComboBox = mFrame.getTPanel().getPComboBox();
		sPanel = mFrame.getBPanel();
		tPanel = mFrame.getTPanel();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Player p = (Player) pComboBox.getSelectedItem();
		if(p.getPlayerId().equals(houseName))
		{
			System.out.println("disabled");
			tPanel.getPBButton().setEnabled(FALSE);
			tPanel.getRBButton().setEnabled(FALSE);
		}
		else if (p != null) {
//			if(!cPanel.hasDelt(p.getPlayerId()))
//			{
//				tPanel.getDButton().setEnabled(b);
//				tPanel.getRBButton().setEnabled(TRUE);
//					
//			}
			tPanel.getPBButton().setEnabled(TRUE);
			tPanel.getRBButton().setEnabled(TRUE);
			
			cPanel.removeCards();
			
			cPanel.drawCards(p.getPlayerId());
			sPanel.setStatus(String.format("%s selected", p.getPlayerName()));
		}
		else {
			
			sPanel.setStatus("Selected No-one");
		}
	}
	public void disableDeal(boolean disable)
	{
		if(disable)
		{
			
		}
		else
		{
			
		}
		
	}
	
}
