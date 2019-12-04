public class ATM {
    public static double bankAccount;

    public static void setBankAccount(double bankAccount) {
        ATM.bankAccount = bankAccount;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new FirstThread("Первый поток");
        Thread secondThread = new Thread(new SecondThread());
        secondThread.setName("Второй поток");
        setBankAccount(500);
        firstThread.start();
        secondThread.sleep(4000);
        secondThread.start();
    }
}
