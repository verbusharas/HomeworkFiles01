package lt.verbus;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ImportService {
    public Map<Integer, Person> importPeople(String pathToFile) {
        Map<Integer, Person> people = new HashMap<>();
        try (BufferedReader peopleReader = Files.newBufferedReader(Paths.get(pathToFile))) {
            String line;
            peopleReader.readLine(); //prašokama pirma eilutė su stulpelių pavadinimais
            while ((line = peopleReader.readLine()) != null) {
                String[] argumentsInLine = line.split(", ");
                people.put(Integer.valueOf(argumentsInLine[0]), new Person(Integer.valueOf(argumentsInLine[0]), argumentsInLine[1], argumentsInLine[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    public HashMap<Integer, Payment> importPayments(String pathToFile) {
        Map<Integer, Payment> transactions = new HashMap<>();
        try (BufferedReader paymentReader = Files.newBufferedReader(Paths.get(pathToFile))) {
            String line;
            paymentReader.readLine(); //prašokama pirma eilutė su stulpelių pavadinimais
            while ((line = paymentReader.readLine()) != null) {
                String[] argumentsInLine = line.split(", ");
                transactions.put(Integer.valueOf(argumentsInLine[0]),
                        new Payment(Integer.valueOf(argumentsInLine[0]), Double.valueOf(argumentsInLine[1]), Integer.valueOf(argumentsInLine[2]), Integer.valueOf(argumentsInLine[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
