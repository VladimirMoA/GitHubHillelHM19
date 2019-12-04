import java.util.Scanner;

public class SecondThread implements Runnable {

    static ATM atm = new ATM();

    public static boolean put(double amount) {
        System.out.println(Thread.currentThread().getName() + " - " + "пополнение - " + (atm.bankAccount += amount));
        return true;
    }

    public static boolean withdraw(double amount) {
        if ( (atm.bankAccount <= 0) || (-amount > atm.bankAccount) ) {
            System.out.println("К сожалению данная транзакция невозможна, на счету не хватает денег");
            return false;
        } else {
            System.out.println(Thread.currentThread().getName() + " - " + "снятие - " + (atm.bankAccount += amount));
            return true;
        }
    }

    public void run() {

            Scanner sc = new Scanner(System.in);
            System.out.println("Введите на сколько вы хотите пополнить счёт, " +
                    "если вы хотите снять деньги, введите сумму с минусом");
            if (sc.hasNextInt()) {
                int amount = sc.nextInt();
                if (amount > 0) {
                    put(amount);
                } else if (amount < 0) {
                    withdraw(amount);
                }
            }

    }
}
