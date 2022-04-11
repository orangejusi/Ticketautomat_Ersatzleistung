import java.util.Scanner;

public class Main {
    public static int hours;
    public static int money;
    static Account cb = new Account();
    static Ticket_machine tm = new Ticket_machine();

    public static void main(String[] args){
        while (true) {//ask for balance and parking hours
            System.out.println("Guten Tag, der Parkpreis beträgt 3€ pro Stunde." + "\n" + "Momentan sind " + tm.lots_free + " Plätze frei.");
            Scanner i = new Scanner(System.in);
            System.out.println("\nWie viele Stunden?");
            hours = i.nextInt();
            Ticket_machine.parking_time = hours;

            Scanner m = new Scanner(System.in);
            System.out.println("Wie viel Geld haben Sie?");
            money = m.nextInt();
            Account.balance = money;

            //print if balance is given
            if (cb.check_balance()) {
                System.out.println("Neuer Kontostand: " + Account.balance + "€" + "\n\n");
                tm.print();
            } else {
                System.out.println("Keine Deckung vorhanden.");
                break;      //break, so intellij is not crying about while-loop (l. 10)
            }
        }
    }
}