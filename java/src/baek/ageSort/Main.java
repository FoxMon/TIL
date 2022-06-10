package baek.ageSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() { return this.age; }
    public String getName() { return this.name; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        Person[] persons = new Person[total];

        for(int i = 0; i < persons.length; i++) {
            int age = scanner.nextInt();
            String name = scanner.next();
            persons[i] = new Person(age, name);
        }

        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getAge() - person2.getAge();
            }
        });

        for(int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].getAge() + " " + persons[i].getName());
        }
    }
}
