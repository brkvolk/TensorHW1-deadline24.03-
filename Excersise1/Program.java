package Excersise1;

public class Program {
    public static void main(String[] args)
    {
        Card_C c1 = new Card_C(6, "diamonds");
        Card_C c2 = new Card_C(7, "clover");
        Card_C c3 = new Card_C("diamonds");
        System.out.print(
            c1.getInfo()+
            c2.getInfo()+
            c3.getInfo()
        );
    }
}
