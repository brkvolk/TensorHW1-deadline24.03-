package Excersise1;

public class Card_C {
    private int rank; 
    private String suit;
    private static String[] Suits = {"diamonds", "clubs", "hearts", "spades"};
    private static int[] maxRank = new int[4];
    
   public Card_C(int rank, String suit) throws ExceptionInInitializerError
    {
        try {
            if(IsSuitValid(suit)) {
                    this.suit = suit;
                    this.rank = rank;
                    UpdateMaxRank(suit, rank);
                }else
                    throw new ExceptionInInitializerError("Not valid suit in constructor!");
        }catch(ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    public Card_C(String suit) {
            this(maxRank[GetMaxRankIndexBySuit(suit)]+1, suit);
    }

    private boolean IsSuitValid(String suit) {
       for(String s:Suits)  {
           if(suit.equals(s))
            return true;
        }return false;
    }

    private static void UpdateMaxRank(String suit, int rank ){
        
        try{
            int i = GetMaxRankIndexBySuit(suit);
            if(maxRank[i]<rank) {
                maxRank[i]=rank;
                return;
            }
        }catch(Exception e) {
            throw e;
        }
    }
    private static int GetMaxRankIndexBySuit(String suit)   {
        try {
            for(int i=0; i<Suits.length; i++)  
                if(suit.equals(Suits[i]))
                    return i;
            throw new Exception("Not valid suit!");
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    
    public String getInfo() {
        return "\nrank:\t" + rank +"\tsuit:\t" + suit;
    } 
}
