package Excersise3;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;

    private Deck(int mode) {
        // ???
        if (mode == 0)
            deck = new ArrayList<Card>(52);
        else
            deck = new ArrayList<Card>(54);
        for (Card.Suit s : Card.Suit.values())
            for (Card.Rank r : Card.Rank.values())
                if (r.GetRankValue() < 15)
                    deck.add(new Card(r.GetRankValue(), s.name()));
        if (mode == 1) {
            deck.add(new Card(15, Card.Suit.HEARTS.name()));
            deck.add(new Card(15, Card.Suit.SPADES.name()));
        }
    }

    public int size() {
        return deck.size();
    }

    public static Deck CreateDeck() {
        return new Deck(0);
    }

    public static Deck CreateDeckWithJockers() {
        return new Deck(1);
    }

    public Card GetRandomCard() {
        return new Card(Card.Rank.GetRandomRank(), Card.Suit.GetRandomSuit());
    }

    public void MixDeck() {
        Random rnd = new Random();
        for (int i = 0; i < deck.size() * 2; i++) {
            Card c = deck.get(rnd.nextInt(deck.size() - 1));
            deck.remove(c);
            PushCard(c);
        }
    }

    public void SortDeck() {
        for (int i = 0; i < deck.size() - 1; i++)
            for (int j = deck.size() - 1; j > i; j--) {
                if (deck.get(j - 1).compareTo(deck.get(j)) > 0)
                    SwapCards(j - 1, j);
            }
    }

    private void SwapCards(int index1, int index2) {
        Card c1 = deck.get(index1);
        deck.set(index1, deck.get(index2));
        deck.set(index2, c1);
    }

    public Card PopCard() {
        try {
            if (!this.IsEmpty())
                return deck.remove(deck.size() - 1);
            else
                throw new Exception("Deck is empty!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void PushCard(Card card) {
        if (!IsCardInDeck(card))
            deck.add(card);
    }

    public boolean IsCardInDeck(Card card) {
        for (Card c : deck)
            if (c.equals(card))
                return true;
        return false;
    }

    public boolean IsEmpty() {
        return deck.isEmpty();
    }

    @Override
    public String toString() {
        if (this.IsEmpty()) {
            return "Deck is empty";
        }
        String res = "";
        for (Card c : deck)
            res += '\n' + c.toString();
        return res;
    }
}
