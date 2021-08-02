package view.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.interfaces.Player;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {
	DefaultTableModel dTbModel;
	private JTable sumTable;
	Object[] cNames = {"id", "name", "bet", "points", "result", "overall"};
	
	public SummaryPanel(MainFrame mFrame) {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(mFrame.getWidth(), mFrame.getMPanel().getHeight() / 3));
	}
	
	public void construct() {
		dTbModel = new DefaultTableModel(cNames, 0);
		sumTable = new JTable(dTbModel);
		sumTable.setFillsViewportHeight(true);
		JScrollPane sPane = new JScrollPane(sumTable);
		add(sPane, BorderLayout.CENTER);
	}
	
	public void newPlayer(Player p) {
		Object[] pValues = {
				p.getPlayerId(), p.getPlayerName(), p.getBet(), p.getPoints(), p.getResult(), "-"
		};
		dTbModel.addRow(pValues);
	}
	
	public void removePlayer(Player p) {
		for (int i = 0; i < dTbModel.getRowCount(); i++) {
			if (p.getPlayerId().equals(dTbModel.getValueAt(i, 0)))
				dTbModel.removeRow(i);
		}
	}
	
	public void updatePBet(Player p) {
		for (int i = 0; i < dTbModel.getRowCount(); i++) {
			if (p.getPlayerId().equals(dTbModel.getValueAt(i, 0))) {
				dTbModel.setValueAt(p.getBet(), i, 2);
			}
		}
	}
	
	public void updatePPoints(Player p) {
		for (int i = 0; i < dTbModel.getRowCount(); i++) {
			if (p.getPlayerId().equals(dTbModel.getValueAt(i, 0))) {
				dTbModel.setValueAt(p.getPoints(), i, 3);
			}
		}
	}
	
	public void updatePResult(Player p) {
		for (int i = 0; i < dTbModel.getRowCount(); i++) {
			if (p.getPlayerId().equals(dTbModel.getValueAt(i, 0))) {
				dTbModel.setValueAt(p.getResult(), i, 4);
			}
		}
	}
	
	public void updatePOverall(Player p, String s) {
		for (int i = 0; i < dTbModel.getRowCount(); i++) {
			if (p.getPlayerId().equals(dTbModel.getValueAt(i, 0))) {
				dTbModel.setValueAt(s, i, 5);
			}
		}
	}
	public JTable getSumTable()
	{
		return sumTable;
	}
}
