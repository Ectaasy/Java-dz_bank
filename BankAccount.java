package bankDZ;
public class BankAccount {
    private Balance balance;
    private final String ownerName; 
    private final String accountNumber; 
    private final long withdrawalLimit; 

    public BankAccount(String ownerName, String accountNumber, Balance balance, long withdrawalLimit) {
        if (ownerName == null || ownerName.isEmpty()) {
            throw new IllegalArgumentException("Имя владельца не может быть пустым");
        }
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Номер счета не может быть пустым");
        }
        if (balance == null) {
            throw new IllegalArgumentException("Баланс не может быть null");
        }
        if (withdrawalLimit < 0) {
            throw new IllegalArgumentException("Лимит не может быть отрицательным");
        }
        
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.withdrawalLimit = withdrawalLimit;
    }

    public Balance getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getWithdrawalLimit() {
        return withdrawalLimit;
    }


    public void transfer(BankAccount recipient, long amount) {
        if (recipient == null) {
            throw new IllegalArgumentException("Получатель не может быть null");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Суммма перевода не может быть отрицательной");
        }
        if (amount > withdrawalLimit) {
            throw new IllegalArgumentException("Превышен лимит на вывод");
        }
        

        this.balance = this.balance.subtract(amount);

        recipient.balance = recipient.balance.add(amount);
    }

    public void deposit(long amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(long amount) {
        if (amount > withdrawalLimit) {
            throw new IllegalArgumentException("Превышен лимит на вывод");
        }
        this.balance = this.balance.subtract(amount);
    }
    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + ownerName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", withdrawalLimit=" + withdrawalLimit +
                '}';
    }
}
