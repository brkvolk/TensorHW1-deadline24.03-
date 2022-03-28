package Excersise3;

import java.util.Random;

public class Card implements Comparable {
    protected int rank;
    protected String suit;

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13),
        ACE(14), JOCKER(15);

        private final int rankValue;

        Rank(int rv) {
            rankValue = rv;
        }

        public int GetRankValue() {
            return rankValue;
        }

        public static int GetRandomRank() {
            Random rnd = new Random();
            return Rank.values()[rnd.nextInt(13) + 1].rankValue;
        }
    }

    public enum Suit {
        CLUBS(0), DIAMONDS(1), SPADES(2), HEARTS(3);

        private final int suitValue;

        Suit(int sv) {
            suitValue = sv;
        }

        public int GetSuitValue() {
            return suitValue;
        }

        public static String GetRandomSuit() {
            Random rnd = new Random();
            return Suit.values()[rnd.nextInt(4)].name();
        }
    }

    public Card(int rank, String suit) throws ExceptionInInitializerError {
        this.rank = rank;
        try {
            if (IsSuitValid(suit.toUpperCase()))
                this.suit = suit.toUpperCase();
            else
                throw new ExceptionInInitializerError("Not valid suit!");
        } catch (ExceptionInInitializerError e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean IsSuitValid(String suit) {
        for (Suit s : Suit.values()) {
            if (suit.equals(s.name()))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Rank:\t%s\tSuit:\t%s", GetRankString(), this.suit);
    }

    @Override
    public boolean equals(Object obj) {
        try {
            if (!(obj instanceof Card))
                throw new Exception();
            Card card = (Card) obj;
            return this.rank == card.rank && this.suit.equals(card.suit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return rank + suit.hashCode();
    }

    private String GetRankString() {
        try {
            for (Rank r : Rank.values())
                if (r.rankValue == rank)
                    return r.name();
            throw new Exception("No such suit");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "NoRank";
        }
    }

    public boolean IsCardFromStandartDeck() {
        try {
            return this.rank <= 15 && this.rank > 1 && IsSuitValid(this.suit);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean IsStrongerThan(Card card) {
        try {
            if (this.suit.equals(card.suit))
                return this.rank > card.rank;
            else
                throw new Exception(
                        "Can`t compare strength of cards with different suits!\t" + this.suit + " & " + card.suit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int Compare(Card card) {
        try {
            int firstCardI = GetSuitIndex(this.suit);
            int secondCardI = GetSuitIndex(card.suit);
            if (firstCardI > secondCardI)
                return 1;
            else if (firstCardI < secondCardI)
                return -1;
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    private static int GetSuitIndex(String suit) throws Exception {
        try {
            for (Suit s : Suit.values())
                if (suit.equals(s.name()))
                    return s.ordinal();
            throw new Exception("No such suit exists:\t" + suit);
        } catch (Throwable e) {
            throw e;
        }
    }

    public static int Compare(Card firstCard, Card secondCard) {
        return firstCard.Compare(secondCard);
    }

    @Override
    public int compareTo(Object o) {
        Card c = (Card) o;
        if (this.Compare(c) != 0)// compare suits
            return this.Compare(c);
        else {
            if (this.IsStrongerThan(c))
                return 1;
            else if (c.IsStrongerThan(this))
                return -1;
            return 0;
        }
    }
}
