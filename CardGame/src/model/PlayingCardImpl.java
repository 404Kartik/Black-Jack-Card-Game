package model;

import model.interfaces.PlayingCard;

public class PlayingCardImpl implements PlayingCard {
	private Suit suit;
	private Value value;
	
	public PlayingCardImpl(Suit suit, Value value)
	{
		this.suit = suit;
		this.value = value;
	}


	@Override
	public Suit getSuit() {
		return this.suit;
	}

	@Override
	public Value getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		int points = 0;
		if (this.value == Value.ACE) {
			points = 11;
		}
		else if (this.value == Value.KING) {
			points = 10;
		}
		else if (this.value == Value.QUEEN) {
			points = 10;
		}
		else if (this.value == Value.JACK) {
			points = 10;
		}
		else if (this.value == Value.TEN) {
			points = 10;
		}
		else if (this.value == Value.NINE) {
			points = 9;
		}
		else if (this.value == Value.EIGHT) {
			points = 8;
		}
		else {
			points = 0;
		}	
		return points;
	}

	@Override
	public boolean equals(PlayingCard card) {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (card.getValue().equals(this.value) && card.getSuit().equals(this.suit)) {
			flag = true;
		}
		return flag;
	}

	public String toString() {
		
		String suits = String.format("%s", this.suit);
		String values = String.format("%s", this.value);
		return String.format("Suite: %s, Value: %s, Score: %d", this.capitalize(suits.toLowerCase()), this.capitalize(values.toLowerCase()), this.getScore());
	}
	
	public boolean equals(Object card) {
		if (card instanceof PlayingCard) {
			PlayingCard card1 = (PlayingCard) card;
			return this.suit.equals(card1.getSuit()) && this.value.equals(card1.getValue());
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	
	private String capitalize(final String line) {
		   return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}

}
