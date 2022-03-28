package Excersise3;

public class Program {
    public static void main(String[] args) {

        Deck d = Deck.CreateDeck();
        d.MixDeck();
        System.out.printf("Mixed deck:\n%s\n", d.toString());

        Card c1 = d.GetRandomCard();
        System.out.printf("Get rangom card:\n%s\n", c1.toString());

        d.PushCard(c1);
        System.out.printf("Try to push it to deck:\n%s\n", d.toString());

        System.out.printf("Pop card:\n%s\n", d.PopCard().toString());
        System.out.printf("updated deck:\n%s\n", d.toString());

        Card c2 = d.PopCard();
        System.out.printf("\nPop and push *2:\n%s\n", c2.toString());
        d.PushCard(c2);
        d.PushCard(c2);
        System.out.printf("\nupdated deck:\n%s\n", d.toString());

        System.out.printf("\npop twice :\n%s\n%s\n%s\n", d.PopCard().toString(), d.PopCard().toString(), d.toString());

        d.SortDeck();
        System.out.printf("\nSorted deck:\n%s\n", d.toString());

        Deck d2 = Deck.CreateDeckWithJockers();
        System.out.printf("\nDeck with jockers:\n%s\n", d2.toString());

        int n = d2.size();
        for (int i = 0; i < n; i++)
            d2.PopCard();

        System.out.printf("\n%s\n", d2.toString());

    }
}
