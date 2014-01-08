package oopDesgin.backjack;

public enum Suit {
	CLUB(0),SPADES(1),HEART(2),DIAMOND(3);
	private int value;
	public int getValue(){
		return value;
	}
	private Suit(int value){
		this.value = value;
	}
	
	public static Suit getSuitFromValue(int value){
		return null;
	}
	

}
