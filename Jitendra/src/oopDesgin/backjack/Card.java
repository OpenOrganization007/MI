package oopDesgin.backjack;


public abstract class Card {
	protected int value;
	protected int faceValue;
	protected Suit suit;
	private boolean available = true;

	public Card(int f, Suit s){
		this.faceValue = f;
		this.suit = s;
	}
	public abstract int value();
	public Suit suit(){
		return suit;
	}
	
	public boolean isAvailable(){
		return available;
	}
	public void marAvailable(){
		this.available = true;
	}
	public void markUnAvailable(){
		this.available = false;
	}
}
