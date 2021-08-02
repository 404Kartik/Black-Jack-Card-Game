package view.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.Player;
import model.interfaces.PlayingCard;

@SuppressWarnings("serial")
public class CardPanel extends JPanel {
	
	private HashMap<String, ArrayList<String>> gCards = new HashMap<>();
	private static final int CARDWHIDTH = 160;
	private static final int CARDHEIGHT = (int) (CARDWHIDTH * 1.5);
	public ArrayList<String> deltPlayers = new ArrayList<String>();
	
	public CardPanel(MainFrame mFrame) {
		//gCards.put("house", new ArrayList<PlayingCard>());
		
		setPreferredSize(new Dimension(mFrame.getWidth(), mFrame.getMPanel().getHeight() * 2 / 3));
		setBackground(Color.BLACK);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}
	
//	public void clearGCards() {
//		for(ArrayList<PlayingCard> pCards : gCards.values()) {
//			pCards.clear();
//		}
//	}
	
	public void addCard(String card) {
		//System.out.println(this.getName()+"dfs"+card);
		
		//gCards.get(p.getPlayerId()).add(c);
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(10, 11, CARDWHIDTH, CARDHEIGHT);
		add(lblNewLabel);
		ImageIcon myIcon2 = new ImageIcon(card);
		ImageIcon image = this.scaleImageIcon(lblNewLabel, myIcon2);
		
		lblNewLabel.setIcon(image);
	}
	public void putHashMap(String player, ArrayList<String> cardDir)
	{
		ArrayList<String> cards=new ArrayList<String>(cardDir);
		deltPlayers.add(player);
		
		

		gCards.put(player, cards);
		
		
		
	}
public ImageIcon scaleImageIcon(JLabel label, ImageIcon imgIcn) {
		
		Image img = imgIcn.getImage();
		Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImage);
		return image;
	}
public void removeCards() {
	removeAll();
	revalidate();
	repaint();
}
public void drawCards(String playerID)
{
	
	for (Map.Entry mapElement : gCards.entrySet())
	{
		String playerid = (String)mapElement.getKey();
		if(playerid.equals(playerID))
		{
			
			@SuppressWarnings("unchecked")
			ArrayList<String> drawingCards=(ArrayList<String>) mapElement.getValue();
			
			for(String drawcard : drawingCards)
			{
				
				addCard(drawcard);
			}
		}
	}
	
}
//	public void addPlayer(Player p) {
//		gCards.put(p.getPlayerId(), new ArrayList<String>());
//	}
	
	public void removePlayer(Player p) {
		gCards.remove(p.getPlayerId());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public ArrayList<String> gethasDelt() {
		// TODO Auto-generated method stub
	
		return deltPlayers;
	}
	public HashMap<String, ArrayList<String>> gethashMap()
	{
		return gCards;
	}
}
