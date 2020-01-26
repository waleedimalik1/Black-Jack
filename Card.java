package coe318.lab5;
/**
 *
 * @author Waleed_Malik
 */

public class Card implements Comparable {
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;
  boolean faceUp;
  int r;
  int suit;

  

  public Card(int r, int suit, boolean faceUp) {
	  this.suit = suit;
		 this.faceUp = faceUp;
	 this.r = r;
	
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    return faceUp;
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
	  this.faceUp = faceUp;
  }

  /**
   * @return the r
   */
  public int getr() {
    return this.r; 
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return this.suit;
  }

  @Override
  public boolean equals(Object ob) {
	  if (!(ob instanceof Card)) {
          return false;
      }
      Card ca = (Card) ob;
      if(ca.r == this.r && ca.suit == this.suit){
          return true;
      }else{
          return false;
      }
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getr();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  public int compareTo(Card ca) {
	  if(this.r < ca.r){
		  
          return(-1);
          
      }
	  if(this.r > ca.r){
          return(1);
      }

      if(this.suit > ca.suit){
          return 1;
      }
      if(this.suit < ca.suit){
          return -1;
      }
      else
      {
          return 0;
      }
  }

  
  public String getrString() {
	  
	  switch(this.r){ //Switch with a series of cases for each card
      case 11:
          return("Jack");
          
      case 12:
          return("Queen");
          
      case 13:
          return("King");
          
      case 14:
          return("Ace");

      default:
          return(Integer.toString(this.r));
  }
  }


  public String getSuitString() {
    String stringSuit = "blank";
	  
	if(suit == CLUB) {
		stringSuit = "Club"; 
	}
    
    if(suit == DIAMOND) {
    	stringSuit = "Diamond";
    }
    
    if(suit == HEART) {
    	stringSuit = "Heart";
    }
    
    if(suit == SPADE) {
    stringSuit = "Spade";
    }
      
    return stringSuit;
  }


  @Override
  public String toString() {
	  if(faceUp == false)
		  
	  {
		  return "?";
	  }
	  
	  else
	  {
		  
		  return (" "+ r + " " + suit);
	  }
  }

  public int value(){
      if(this.r == 14){
    	  
          return(1);
          
      }
      if(this.r  > 10){
    	  
          return(10);
          
      }
      
      else{
    	  
          return(this.r);
          
      }
  }
  
  
  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}