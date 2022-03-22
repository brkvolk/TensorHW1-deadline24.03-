package Excersise2;
import java.io.IOException;

public class Card_B
{
    private int rank; 
    private String suit;
    private static String[] Suiats = {"diamonds", "clubs", "hearts", "spades"};
    private static String[] Ranks = {"Jack", "Queen", "King", "Ace", "Jocker"};

    public Card_B(int rank, String suit) throws ExceptionInInitializerError
    {
        this.rank = rank;
        try
        {
            if(IsSuitValid(suit))
                this.suit = suit;
            else
                throw new ExceptionInInitializerError("Not valid suit!");
        }
        catch(ExceptionInInitializerError e)
        {
            System.out.println(e.getMessage());
        }
    }
    private static boolean IsSuitValid(String suit) 
    {
       for(String r:Suiats)
       {
           if(suit.equals(r))
            return true;
       } return false;
    }
    @Override
    public String toString() {
        return "Rank:\t" + GetRankString()+ "\nSuit:\t" + this.suit;
       }
       
    @Override
    public boolean equals(Object obj) {
        try{
            Card_B card = (Card_B)obj;
            return this.rank==card.rank && this.suit.equals(card.suit);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
       
    }
    @Override
    public int hashCode() {
        return rank + suit.hashCode();
    }

    private String GetRankString()
    {
        if (rank<=10)
            return String.valueOf(rank);
        else return Ranks[rank-10];
    }
}

