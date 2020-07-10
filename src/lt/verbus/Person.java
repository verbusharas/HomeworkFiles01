package lt.verbus;

public class Person {
    int id;
    String name;
    String surname;
    double receivedMoney;
    double sentMoney;

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.receivedMoney = 0;
        this.sentMoney = 0;
    }

    public void transactionIn(double amount) {
        this.receivedMoney = receivedMoney + amount;
    }

    public void transactionOut(double amount) {
        this.sentMoney = sentMoney + amount;
    }

    @Override
    public String toString() {
        return String.format("%d | %s %s", id, name, surname);
    }
}
