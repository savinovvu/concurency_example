package main.java.ru.inbox.savinov_vu.f_paralelReactiveStream.reducing;

import java.util.Date;

public class Person implements Comparable<Person> {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int salary;
    private double coeficient;


    @Override
    public int compareTo(Person otherPerson) {
        int compareLastnames = getLastName().compareTo(otherPerson.getLastName());
        if (compareLastnames != 0) {
            return compareLastnames;
        } else {
            return getFirstName().compareTo(otherPerson.getFirstName());
        }
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Person setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public Person setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public Person setCoeficient(double coeficient) {
        this.coeficient = coeficient;
        return this;
    }
}
