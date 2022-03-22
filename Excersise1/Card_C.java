package Excersise1;
import java.io.IOException;

public class Card_C
{
    private int rank; 
    private String suit;
    private static String[] Suits = {"diamonds", "clubs", "hearts", "spades"};
    private static int[] maxRank = new int[4];
    
   public Card_C(int rank, String suit) throws ExceptionInInitializerError
    {
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

        this.rank = rank;
        UpdateMaxRank(suit, rank);
    }
    public Card_C(String suit)
    {
        Card_C(GetMaxRankIndexBySuit(suit)+1, suit);
    }

    private boolean IsSuitValid(String suit) 
    {
       for(String r:Suits)
       {
           if(suit.equals(r))
            return true;
       } 
       return false;
    }

    private static void UpdateMaxRank(String suit, int rank )
    {
        int i = GetMaxRankIndexBySuit(suit);
        if(maxRank[i]<rank)
        {
            maxRank[i]=rank;
            return;
        }
    }
    private static int GetMaxRankIndexBySuit(String suit)
    {
        for(int i=0; i<Suits.length; i++)
        {
            if(suit.equals(Suits[i]))
                return i;
        }
        return -1;
    }
}
