public class Account {
    public static int balance;

    //check if balance is given, boolean switch to go on
    public boolean check_balance(){
        Ticket_machine tM = new Ticket_machine();
        int topay = tM.to_pay();

        if (balance >= topay) {
            balance -= topay;
            return true;
        } else {
            return false;
        }
    }
}
