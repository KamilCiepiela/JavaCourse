public class ATM {

    public static void main(String[] args) {

    bankAccount saving = new bankAccount();

//        saving.setBalance(10000);

        saving.deposit(5000);

        if (saving.withdraw(2000)){
            System.out.println("Withdrawed.");

        }
        else
            System.out.println("Too little money. Try harder:)");
        System.out.println("Your account balance is: " + saving.getBalance());

    }
}
class bankAccount{
    public bankAccount(){
        balance = 1000;
    }

    private int balance;

    int getBalance(){
        return balance;
    }

    private boolean setBalance(int saldo){
        /*
            CONDITIONS TO MEET!!!
         */
        this.balance = saldo;

        return true;
    }

    boolean withdraw(int howMuch){

        if (balance < howMuch)
            return false;
        else
            setBalance(balance - howMuch);

        return true;
    }

    boolean deposit(int howMuch){

        setBalance(balance + howMuch);
        return true;
    }
}