package model;

import model.interfaces.Player;

public class SimplePlayer implements Player {
	private String ID;
	private String playername;
	private int points;
	private int bet;
	private int result;

	public SimplePlayer(String id, String Name, int Points) {
		this.ID = id;
		this.playername = Name;
		this.points = Points;
		this.bet = 0;
		this.result = 0;

	}

	public String getPlayerName() {
		return this.playername;
	}

	public void setPlayerName(String playerName) {
		this.playername = playerName;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getPlayerId() {
		return this.ID;
	}

	public boolean setBet(int bet) {
		boolean hasFunds = false;
		if (bet == 0) {
			this.resetBet();
		} else if (bet <= this.getPoints()) {
			this.bet = bet;
			hasFunds = true;
		}
		return hasFunds;
	}

	public int getBet() {
		return this.bet;
	}

	public void resetBet() {
		this.bet = 0;
	}

	public int getResult() {
		return this.result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public boolean equals(Player player) {
		if (player.getPlayerId() != null && this.ID != null) {
			return player.getPlayerId().equals(this.ID) ? true : false;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimplePlayer other = (SimplePlayer) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	public int compareTo(Player player) {
		int thatPlayerID = Integer.parseInt(player.getPlayerId());
		int thisPlayerID = Integer.parseInt(this.ID);
		if (thisPlayerID > thatPlayerID) {
			return 1;
		} else if (thisPlayerID < thatPlayerID) {
			return -1;
		} else {
			return 0;
		}
	}

	public String toString() {
		return String.format("Player: id=%s, name=%s, bet=%d, points=%d, RESULT .. %d\n", this.ID, this.playername,
				this.bet, this.points, this.result);
	}

}
