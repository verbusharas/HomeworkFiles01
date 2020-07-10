package lt.verbus;

import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<Integer, Person> people = new ImportService().importPeople("src/databases/people.txt");
        Map<Integer, Payment> transactions = new ImportService().importPayments("src/databases/payment.txt");
        people = updateBalances(people, transactions);
        new ExportService().exportReceivers(people, "src/databases/receivers.txt");
        new ExportService().exportSenders(people, "src/databases/senders.txt");

    }

    public static Map<Integer, Person> updateBalances(Map<Integer, Person> people, Map<Integer, Payment> transactions) {
        for (Map.Entry entry : transactions.entrySet()) {
            int senderID = ((Payment) entry.getValue()).getSender();
            int receiverID = ((Payment) entry.getValue()).getReceiver();
            if (people.containsKey(senderID) && people.containsKey(receiverID)) {
                people.get(senderID).transactionOut(((Payment) entry.getValue()).getAmount());
                people.get(receiverID).transactionIn(((Payment) entry.getValue()).getAmount());
            }
        }
        return people;
    }
}
