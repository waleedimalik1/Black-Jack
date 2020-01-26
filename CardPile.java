package coe318.lab5;
/**
 *
 * @author Waleed_Malik
 */

import java.util.ArrayList;
import java.util.Random;


public class CardPile {

    private ArrayList<Card> deckCards;

    public CardPile() {//Instance Variable 
    	
    	deckCards = new ArrayList<Card>();
    	
    }

    public void add(Card card) {
    	deckCards.add(card);
    }

    /**
     * Remove a card chosen at random from pile.
     * @return
     * 
     */
    public Card removeRandom() {

    	Random cardDeal = new Random();
    	
    	if(deckCards.size() != 0) {
    		return deckCards.remove(cardDeal.nextInt(deckCards.size()));
    	}
    	
    	else {
    		
    		return deckCards.remove(deckCards.size());
    	}
    }

    /**
     * 
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
    	String total = "";
    	
    		for(int i = 0; i < deckCards.size(); i++)
    	{
    			total = total + (deckCards.get(i) + "");
    	}
    	return total;
    }
    

    public ArrayList<Card> getCards() {
        return deckCards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int a = 0; a < 52; a++) {
        	
            System.out.println((a+1) + ": " + deck.removeRandom());
            

        }
    }


}