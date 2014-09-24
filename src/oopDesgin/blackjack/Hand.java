package oopDesgin.blackjack;

import java.util.ArrayList;

public class Hand<T extends Card> {
	private ArrayList<T>cards = new ArrayList<T>();
	public int score(){
		int score = 0;
		for(Card card :cards){
			score += card.value();
		}
		return score;
	}
	public void addCard(T card){
		cards.add(card);
	}

}
