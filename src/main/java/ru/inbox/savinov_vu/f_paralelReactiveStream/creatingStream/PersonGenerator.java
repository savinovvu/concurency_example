package main.java.ru.inbox.savinov_vu.f_paralelReactiveStream.creatingStream;

import java.util.*;

public class PersonGenerator {

    public static List<Person> generatePersonList(int size) {
        String firstNames[] = {"Mary", "Patricia", "Linda",
                "Barbara", "Elizabeth", "James",
                "John", "Robert", "Michael",
                "William"};
        String lastNames[] = {"Smith", "Jones", "Taylor",
                "Williams", "Brown", "Davies",
                "Evans", "Wilson", "Thomas",
                "Roberts"};

        Random random = new Random();

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Person person = new Person();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -random.nextInt(30));
            Date birthDate = calendar.getTime();
            person.setId(i)
                    .setFirstName(firstNames[random.nextInt(10)])
                    .setLastName(lastNames[random.nextInt(10)])
                    .setSalary(random.nextInt(1000000))
                    .setCoeficient(random.nextDouble() * 10)
                    .setBirthDate(birthDate);
            persons.add(person);
        }
        return persons;
    }
}
