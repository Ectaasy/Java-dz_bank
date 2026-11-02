package bankDZ;
public final class Balance {
    private final long amount; 
    private final Currency currency;

    public Balance(long amount, Currency currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма не может быть меньше нуля");
        }
        if (currency == null) {
            throw new IllegalArgumentException("Валютьа не может быть null");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

  
    public Balance add(long amountToAdd) {
        if (amountToAdd < 0) {
            throw new IllegalArgumentException("НЕльзя прибавить отрицательную сумму");
        }
        return new Balance(this.amount + amountToAdd, this.currency);
    }

   
    public Balance subtract(long amountToSubtract) {
        if (amountToSubtract < 0) {
            throw new IllegalArgumentException("Нельзя вычесть отрицательную сумму");
        }
        if (amountToSubtract > this.amount) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        return new Balance(this.amount - amountToSubtract, this.currency);
    }

   
    public Balance convert(Currency newCurrency) {
        if (newCurrency == null) {
            throw new IllegalArgumentException("Валюта не может быть null");
        }
        

        long amountInRublesKopecks = this.amount * this.currency.getPriceInRublesKopecks() 
                                     / Currency.RUB.getPriceInRublesKopecks();
        

        long newAmount = amountInRublesKopecks * Currency.RUB.getPriceInRublesKopecks() 
                         / newCurrency.getPriceInRublesKopecks();
        
        return new Balance(newAmount, newCurrency);
    }

    @Override
    public String toString() {
        return amount + " " + currency.getSymbol() + " (" + currency.getCode() + ")";
    }
}