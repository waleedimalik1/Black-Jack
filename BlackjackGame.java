
package coe318.lab5;

public class BlackjackGame {
	//Instance Variables
	  private boolean houseD;
	  
	  private boolean player;
	  
	  private UserInterface user;
	  
	  private CardPile deck;
	  
	  private CardPile house;
	  
	  private CardPile your;

  public BlackjackGame(UserInterface user) {
	  
    this.user = user;
    
    user.setGame(this);
    
    deck = new CardPile();
    
    for (int q = 2; q < 15; q++) {
    	
      for (int l = 0; l < 4; l++) {
    	  
        deck.add(new Card(q, l, true));
        
      }
    }
    
    house = new CardPile();
    
    your = new CardPile();
    
    houseD = false;
    
    player = false;
    
  }

  public void start() {
    Card a;
    a = deck.removeRandom();
    a.setFaceUp(false);
    getHouseCards().add(a);
    getHouseCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    user.display();
  }

  public void play() {
    while (!houseD || !player) {
    	
      if (!houseD) {
    	  
        if (score(getHouseCards()) <= 17) {
        	
          getHouseCards().add(deck.removeRandom());
          
          user.display();
          
        } 
        
        else {
        	
          houseD = true;
          
        }
      }
      
      if (!player) {
        if (user.hitMe()) {
        	
          getYourCards().add(deck.removeRandom());
          
          user.display();
          
        } 
        else {
        	
          player = true;
          
        }
      }
    }
  }

  public void end() {
	  
    getHouseCards().getCards().get(0).setFaceUp(true);
    
    user.gameOver();
    
  }

  /**
   * Determine the score of a pile of cards.
   *
   * @return the score
   */
  public int score(CardPile l) {
	  
	  int scoreSum = 0;
	  
      for(Card card : l.getCards()){
    	  
    	  //Adds up the score from the cards
          scoreSum += card.value();
      }
      
      return scoreSum;
  }

  /**
   * @return the house
   */
  public CardPile getHouseCards() {
	  
    return this.house; //return the houses house cards
    
  }
  

  /**
   * @return the your
   */
  public CardPile getYourCards() {
    return this.your; //returns your cars
  }

  public static void main(String[] args) {
	  
    BlackjackGame game = new BlackjackGame(new SimpleUI());
    
    game.start();

    game.play();

    
    game.end();
  }
}