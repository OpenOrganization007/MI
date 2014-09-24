package oopDesgin.blackjack;

import java.util.ArrayList;

public class Deck<T extends Card> {
	private ArrayList<T>card ;
	private int dealtIndex;
	public void setDeckOfCard(ArrayList<T> cards){
		this.card = cards;
	}
	public void suffle(){
		
	}
	public int remainingCard(){
		return card.size() - dealtIndex;
	}
	
	public T[] dealtHand(){return null;
	}
	public T dealCard(){return null;}

}
