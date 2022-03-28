package Excersise1;

public class Card_B {
    private int rank;
    private String suit;
    static String[] Ranks = { "diamonds", "clubs", "hearts", "spades" };

    public Card_B(int rank, String suit) throws ExceptionInInitializerError {
        this.rank = rank;
        try {
            if (IsSuitValid(suit))
                this.suit = suit;
            else
                throw new ExceptionInInitializerError("Not valid suit!");
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean IsSuitValid(String suit) {
        for (String r : Ranks) {
            if (suit.equals(r))
                return true;
        }
        return false;
    }

    public String getInfo() {
        return String.format("rank:\t%d\nsuit:\t%d\n", rank, suit);
    }
}
