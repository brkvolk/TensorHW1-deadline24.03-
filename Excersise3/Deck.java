package Excersise3;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    
    private ArrayList<Card> deck;


    private Deck(int mode){
       
        for(String suit: Card.Suits)
                    for(int rank=2; rank<=14; rank++)
                                deck.add(new Card(rank, suit));
  
       if(mode== 1)
           {deck.add(new Card(15, "hearts"));
            deck.add(new Card(15, "spades"));                  
           }
    }

    public static Deck CreateDeck()
    {
        return new Deck(0);
    }
    public static Deck CreateDeckWithJockers()
    {
        return new Deck(1);
    }

    public static Card GetRandomCard(){
        Random rnd = new Random();
        return new Card(2 + rnd.nextInt()%13, Card.Suits[rnd.nextInt()%4]);
    }
    
    public void MixDeck(){
        Random rnd = new Random();
        for(int i=0;i<deck.size()/2;i++)
        {
            Card c = deck.get(rnd.nextInt()%deck.size());
            deck.remove(c);
            PushCard(c);
        }
    }

    public void SortDeck(){
        
        //deck.sort(c);;
    }
    public Card PopCard()
    {
        try{
        if(!this.IsEmpty())
            return deck.remove(deck.size());
        else throw new Exception("Deck is empty!"); 
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void PushCard(Card card){
        if(!IsCardInDeck(card))
            deck.add(card);
    }

    public boolean IsCardInDeck(Card card){
        for(Card c: deck)
            if (c.equals(card))
                return true;
        return false;
    }
    public boolean IsEmpty(){
        return deck.size()>0;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
