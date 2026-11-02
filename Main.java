package bankDZ;
public class Main {
    public static void main(String[] args) {

        Balance balance1 = new Balance(10000, Currency.RUB); 
        Balance balance2 = new Balance(5000, Currency.RUB);  


        BankAccount account1 = new BankAccount("Иван Иванов", "001", balance1, 5000);
        BankAccount account2 = new BankAccount("Петр Петров", "002", balance2, 3000);

        System.out.println(" Начальные данные ");
        System.out.println(account1);
        System.out.println(account2);

    
        System.out.println("\n Операции с балансом ");
        Balance newBalance = balance1.add(5000);
        System.out.println("После добавления 50 рублей: " + newBalance);

        Balance subtractedBalance = balance1.subtract(3000);
        System.out.println("После вычета 30 рублей: " + subtractedBalance);

        Balance convertedBalance = balance1.convert(Currency.USD);
        System.out.println("Конвертация в USD: " + convertedBalance);


        System.out.println("\n Перевод денег ");
        account1.transfer(account2, 2000);
        System.out.println("После перевода 20 рублей со счета 001 на 002:");
        System.out.println(account1);
        System.out.println(account2);


        System.out.println("\n Проверка лимита ");
        try {
            account1.withdraw(6000); 
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        System.out.println("\n Corner cases ");
        try {
            Balance negativeBalance = new Balance(-100, Currency.RUB);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            balance1.add(-500);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}