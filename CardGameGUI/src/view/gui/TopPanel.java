package view.gui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import controller.AddPlayerListener;
import controller.DealListener;
import controller.PBetListener;
import controller.PComboBoxListener;
import controller.RemovePlayerListener;
import controller.ResetBetListener;
import model.SimplePlayer;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class TopPanel extends JPanel {
	MainFrame mFrame;
	JToolBar gToolbar;
	
	ButtonGroup group;
	AbstractButton dealingButton;
	AbstractButton placeBetButton;
	AbstractButton resetBetButton;
	AbstractButton aPButton;
	AbstractButton rPButton;
	JComboBox<Player> pComboBox;
	
	public TopPanel(MainFrame mFrame) {
		this.mFrame = mFrame;
		
		group = new ButtonGroup();
		
		setLayout(new BorderLayout());
	}
	
	public void createLayout() {
		gToolbar = new JToolBar();
		add(gToolbar, BorderLayout.CENTER);
		
		dealingButton = new JButton("DEAL");
		gToolbar.add(dealingButton);
		
		placeBetButton = new JButton("PLACE BET");
		gToolbar.add(placeBetButton);
		placeBetButton.setEnabled(false);
		
		resetBetButton = new JButton("RESET BET");
		gToolbar.add(resetBetButton);
		resetBetButton.setEnabled(false);
		
		pComboBox = new JComboBox<Player>();
		pComboBox.addItem(new SimplePlayer("house", "House", -1));
		pComboBox.setRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList<?> list,
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus) {
				if (value != null)
					setText(((Player) value).getPlayerName());
				
				return this;
			}
		});
		gToolbar.add(pComboBox);
		
		aPButton = new JButton("ADD PLAYER");
		gToolbar.add(aPButton);

		rPButton = new JButton("REMOVE PLAYER");
		gToolbar.add(rPButton);
		
		
		aPButton.addActionListener(new AddPlayerListener(mFrame));
		rPButton.addActionListener(new RemovePlayerListener(mFrame));
		placeBetButton.addActionListener(new PBetListener(mFrame));
		resetBetButton.addActionListener(new ResetBetListener(mFrame));
		dealingButton.addActionListener(new DealListener(mFrame));
		pComboBox.addItemListener(new PComboBoxListener(mFrame));
	}
	
	public JToolBar getGToolbar() {
		return gToolbar;
	}
	
	public AbstractButton getDButton() {
		return dealingButton;
	}
	
	public AbstractButton getPBButton() {
		return placeBetButton;
	}
	
	public AbstractButton getRBButton() {
		return resetBetButton;
	}
	
	public AbstractButton getAPButton() {
		return aPButton;
	}
	
	public AbstractButton getRPButton() {
		return rPButton;
	}
	
	public JComboBox<Player> getPComboBox() {
		return pComboBox;
	}
}
