package Excersise2;

public class Card_B
{
    private int rank; 
    private String suit;
    private static String[] Suits = {"clubs" , "diamonds",  "spades" , "hearts"};
    private static String[] Ranks = {"Jack", "Queen", "King", "Ace", "Jocker"};

    public Card_B(int rank, String suit) throws ExceptionInInitializerError {
        this.rank = rank;
        try {
            if(IsSuitValid(suit))
                this.suit = suit;
            else
                throw new ExceptionInInitializerError("Not valid suit!");
        }
        catch(ExceptionInInitializerError e)    {
            System.out.println(e.getMessage());
        }
    }
    private static boolean IsSuitValid(String suit) {
       for(String r:Suits)
       {
           if(suit.equals(r))
                return true;
       } return false;
    }
    @Override
    public String toString() {
        return "{Rank:\t" + GetRankString()+ "     Suit:\t" + this.suit + "}";
       }
       
    @Override
    public boolean equals(Object obj) {
        try{
            Card_B card = (Card_B)obj;
            return this.rank==card.rank && this.suit.equals(card.suit);
        }catch(Exception e)  {
            System.out.println(e.getMessage());
        }   return false;
       
    }
    @Override
    public int hashCode() {
        return rank + suit.hashCode();
    }

    private String GetRankString()  {
        if (rank<=10)
            return String.valueOf(rank);
        else return Ranks[rank-10];
    }

    public boolean IsCardFromStandartDeck(){
        try{
            return this.rank <= 15 && this.rank > 1 && IsSuitValid(this.suit);
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean IsStrongerThan(Card_B card)  {
        try{
            if(this.suit.equals(card.suit))
                    return this.rank > card.rank;
            else 
                throw new Exception("Can`t compare strength of cards with different suits!\t"+this.suit+" & "+card.suit);
        }catch(Exception e) {
            System.out.println(e.getMessage());            
            return false;
        }
    }

    public int Compare(Card_B card)   {
        try {
            int firstCardI = GetSuitIndex(this.suit);
            int secondCardI = GetSuitIndex(card.suit); 
            if (firstCardI > secondCardI)
                return 1;
            else if (firstCardI < secondCardI)
                return -1;
            return 0;
        } catch(Exception e)    {
            System.out.println(e.getMessage());
            return -1025635;
        }
    }

    private static int GetSuitIndex(String suit)   throws Exception   {
        try {
            for(int i=0; i < Suits.length; i++)  
                if(suit.equals(Suits[i]))
                    return i;
            throw new Exception("No such suit exists:\t"+suit);
        }catch(Throwable e) {
            throw e;
        }
    }
    
    public static int Compare(Card_B firstCard, Card_B secondCard)  {
        return firstCard.Compare(secondCard);
    } 
}

