package view.model;

import java.util.ArrayList;
import java.util.Collection;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.gui.MainFrame;

public class PlayerState {
	GameEngine gEngine;
	
	Player dealing = null;
	Player lastDealt = null;
	Collection<Player> dealtPlayers = new ArrayList<>();
	
	public PlayerState(MainFrame mFrame) {
		gEngine = mFrame.getGEngine();
	}
	
	public void addP(Player p) {
		dealtPlayers.add(p);
	}
	
	public boolean isPDealing(Player p) {
		return dealing != null && p.equals(dealing);
	}
	
	public void setPDealing(Player p) {
		dealing = p;
	}
	
	public boolean hasBeenDealt(Player p) {
		return dealtPlayers.contains(p);
	}
	
	public boolean lastDealtP(Player p) {
		return p.equals(lastDealt);
	}
	
	public void setLastDealt(Player p) {
		lastDealt = p;
	}
	
	public boolean hasAllPDealt() {
		return dealtPlayers.containsAll(gEngine.getAllPlayers()) && !dealtPlayers.isEmpty();
	}
	
	public void clearDealtPlayers() {
		dealtPlayers.clear();
	}
}
