package Excersise3;

public class Program {
    public static void main(String[] args) {

        Deck d = Deck.CreateDeck();
        d.MixDeck();
        System.out.println(d.toString());

        Card c1 = d.GetRandomCard();
        d.PushCard(c1);

        System.out.println(d.PopCard().toString());

        Card c2 = d.PopCard();
        System.out.println(c2.toString());
        d.PushCard(c2);
        d.PushCard(c2);

        System.out.println(d.PopCard().toString());
        System.out.println(d.PopCard().toString());

        d.SortDeck();
        System.out.println(d.toString());
        Deck d2 = Deck.CreateDeckWithJockers();
        for (int i = 0; i < d2.size; i++)
            d2.PopCard();
        System.out.println(d2.toString());
    }
}
