public class ATM {

    public static synchronized void main(String[] args) {
        Thread firstThread = new TransactionThread("Первый поток");
        Thread secondThread = new TransactionThread("Второй поток");
        firstThread.start();
        secondThread.start();
    }
}
