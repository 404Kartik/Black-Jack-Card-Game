package view.gui;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;
import view.model.PlayerState;

public class GameEngineCallbackGUI implements GameEngineCallback {

	SummaryPanel sumPanel;
	BottomPanel sPanel;
	MiddlePanel middlePanel;
	ArrayList<String> playerCard;
	MainFrame mFrame;
	PlayerState pState;
	private static final int delay = 400;
	private static final String houseName = "house";
	int playersDelt=0;
	public GameEngineCallbackGUI(MainFrame mFrame) {
		// initializinf the objects corelated to the main frame
		sumPanel = mFrame.getMPanel().getSPanel();
		sPanel = mFrame.getBPanel();
		middlePanel = mFrame.getMPanel();
		playerCard = new ArrayList<String>();
		pState = mFrame.getPState();
		this.mFrame = mFrame;

	}

	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) {

		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				String cardDirectory = String.format("cards/%s_%s.PNG", card.getSuit(), card.getValue());
				// Storing cards for Card Directory
				middlePanel.getCPanel().addCard(cardDirectory);

				playerCard.add(cardDirectory);

			}
		});

	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				String cardDirectory = String.format("cards/%s_%s.PNG", card.getSuit(), card.getValue());

				middlePanel.getCPanel().addCard(cardDirectory);
				playerCard.add(cardDirectory); // adding cards to the Panel

			}
		});
	}

	@Override
	public void result(Player p, int result, GameEngine engine) {
		// TODO Auto-generated method stub
		playersDelt++;
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// do GUI update on UI thread
				mFrame.getMPanel().getCPanel().gethasDelt().add(p.getPlayerId()); // adding the player who has Dealt
				middlePanel.getCPanel().putHashMap(p.getPlayerId(), playerCard);
				playerCard.clear();
				sumPanel.updatePResult(p);
				sPanel.setStatus(String.format("%s scored %d", p.getPlayerName(), result));

			}
		});
		System.out.println(mFrame.getMPanel().getSPanel().getSumTable().getRowCount());
		System.out.println(mFrame.getMPanel().getCPanel().gethasDelt()
				.size());
		System.out.println(playersDelt);
		if (mFrame.getMPanel().getSPanel().getSumTable().getRowCount() == playersDelt) { // checking if all the Players have been dealt, if yes then dealing house
							// automatically
			mFrame.getTPanel().getPComboBox().setSelectedIndex(0); // going to the House

			new Thread() {
				@Override
				public void run() {
					mFrame.getMPanel().getCPanel().removeCards(); // clearing the frame
					// call long running GameEngine methods on separate thread
					sPanel.setStatus("Dealing House Now");
					engine.dealHouse(400); // dealing the house automatically
					pState.setLastDealt(null);
					pState.clearDealtPlayers();
				}
			}.start();
		}
	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				String cardDirectory = String.format("cards/%s_%s.PNG", card.getSuit(), card.getValue());
				// dealing the house card
				middlePanel.getCPanel().addCard(cardDirectory);
				playerCard.add(cardDirectory);

			}
		});
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				String cardDirectory = String.format("cards/%s_%s.PNG", card.getSuit(), card.getValue());

				middlePanel.getCPanel().addCard(cardDirectory);
				playerCard.add(cardDirectory);
				// do GUI update on UI thread
			}
		});
	}

	@Override
	public void houseResult(int result, GameEngine gEngine) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// do GUI update on UI thread
				middlePanel.getCPanel().putHashMap("house", playerCard);
				playerCard.clear();
				ArrayList<Player> removedPlayers = new ArrayList<Player>();

				sPanel.setStatus(String.format("House scored %d", result));
				for (Player p : gEngine.getAllPlayers()) {
					sumPanel.updatePPoints(p);
					sumPanel.updatePBet(p);

					if (p.getResult() > result) {
						sumPanel.updatePOverall(p, "win");
					} else if (p.getResult() < result) {
						sumPanel.updatePOverall(p, "loss");
					} else {
						sumPanel.updatePOverall(p, "draw");
					}
					if (p.getPoints() <= 0) {
						removedPlayers.add(p);  //creating an ArrayList so that we can delete all the players which need to be deleted at once
//					
					}
				}
				removePlayerCompletely(removedPlayers, gEngine);
				playersDelt=0;
			}
		});

	}

	public void removePlayerCompletely(ArrayList<Player> remplayer, GameEngine gEngine) {
		for (Player p : remplayer) {
			
			gEngine.removePlayer(p);
			mFrame.getTPanel().getPComboBox().removeItem(p);
			sumPanel.removePlayer(p);
			sPanel.setStatus(String.format("%s removed", p.getPlayerName()));
		}
	}

}
