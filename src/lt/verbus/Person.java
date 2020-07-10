package lt.verbus;

public class Person {
    int id;
    String name;
    String surname;

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return String.format("%d | %s %s", id, name, surname);
    }
}
