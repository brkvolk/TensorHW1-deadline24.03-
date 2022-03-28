package Excersise2;

public class Program {
    public static void main(String[] args) {
        Card_B c1 = new Card_B(9, "diamonds");
        Card_B c2 = new Card_B(9, "hearts");
        Card_B c3 = new Card_B(17, "diamonds");
        Card_B c4 = new Card_B(9, "clover");

        System.out.printf("Is card from standart Deck?\nc1:\t%b\nc2:\t%b\nc3\t%b\nc4\t%b\n",
                c1.IsCardFromStandartDeck(), c2.IsCardFromStandartDeck(), c3.IsCardFromStandartDeck(),
                c4.IsCardFromStandartDeck());

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("hashcode c1:\t%d\nToString c1:\t%s\nequals c1 & c1: \t%b\nnotequals c1 & c2:\t%b\n",
                c1.hashCode(), c1.toString(), c1.equals(c1), c1.equals(c2));

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.printf("Is stronger?\nc1 > c1:\t%b\nc1 > c2:\t%b\nc1 > c3: \t%b\nc3 > c1: \t%b\nc1 > c4:\t%b\n",
                c1.IsStrongerThan(c1), c1.IsStrongerThan(c2), c1.IsStrongerThan(c3), c3.IsStrongerThan(c1),
                c1.IsStrongerThan(c4));

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("Compare:\nc1 ^ c3:\t%d\nc1 ^ c2:\t%d\nStatic:\nc1 ^ c3:\t%d\nc2 ^ c1:\t%d\n\nc3 ^ c4:\t%d",
                c1.Compare(c3), c1.Compare(c2), Card_B.Compare(c1, c3), Card_B.Compare(c2, c1), c3.Compare(c4));
    }
}
