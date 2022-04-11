import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Ticket_machine {
    final public int price = 3;
    public static int parking_time;
    public int lots_free = 50;
    private int ticket_number = 0;
    Timer timer = new Timer();

    //calculate price to pay
    public int to_pay(){
        return price * parking_time;
    }

    //check if free parking lot is given
    private int free_space(){
        if (lots_free > 0){     //switch lots full <-> empty

            timer.schedule(new TimerTask() {
                public void run() {
                    lots_free++;
                    System.out.println("+1 Parkplatz frei.");
                }
            }, parking_time * 3600000L);

            return 51 - lots_free;
        } else {
            return 0;
        }
    }

    //print the final ticket
    public void print(){
        int fs = free_space();
        if (fs == 0) {
            System.out.println("Keine freien Plätze!");
            return;
        }
        lots_free--;
        ticket_number++;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        System.out.println("Parkzeit: " + parking_time + " Stunden");
        System.out.println("Preis: " + to_pay() + "€");
        System.out.println("Parkplatznummer: " + fs);
        System.out.println("Ticketnummer: " + ticket_number + "\n\n\n");
    }
}
