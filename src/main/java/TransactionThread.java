public class TransactionThread extends Thread {
    private int balance = 150;

    public TransactionThread(String name) {
        super(name);
    }

    public int getBalance() {
        return balance;
    }

    public void withdrawMoney(int amount) {
        balance -= amount;
    }

    public void putMoney(int amount) {
        balance += amount;
    }

    public void run() {
        for (int x = 0; x < 10; x++) {
            if (getBalance() < 0) {
                System.out.println("account is overdrawn!");
            }
            withdrawMoneyFromAccount((int) (Math.random()*10+1));
            putMoneyToAccount((int) (Math.random()*10+1));
        }
    }

    private synchronized void withdrawMoneyFromAccount(int amount) {
        if (getBalance() >= amount) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            withdrawMoney(amount);
            System.out.println(Thread.currentThread().getName()
                    + " -снятие - "
                    + amount);
            System.out.println(getBalance());
        } else {
            System.out.println("Вы не можете совершить операцию");
        }
    }

    private synchronized void putMoneyToAccount(int amount) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            putMoney(amount);
            System.out.println(Thread.currentThread().getName()
                    + " -пополлнение - "
                    + amount);
            System.out.println(getBalance());
    }

}
