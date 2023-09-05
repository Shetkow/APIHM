package org.example.writepeople;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );

        }
        personIsChaild(persons);
        //        System.out.println(readyToArmy(persons));
        canWork(persons);

    }

    public static void personIsChaild(Collection<Person> persons) {
        long countChild = persons.stream()
                .filter(i -> i.getAge() < 18)
                .count();
        System.out.println("Количество людей младше 18 лет : " + countChild);
    }


    public static List<String> readyToArmy(Collection<Person> persons) {
        List<String> toArmy = persons.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .filter(p -> p.getAge() >= 18 && p.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        return toArmy;

    }

    public static void canWork(Collection<Person> persons) {
        List<Person> workPersons = persons.stream()
                .filter(p -> p.getEducation() == Education.HIGHER)
                .filter(p -> p.getSex() == Sex.WOMAN ? p.getAge() >= 18 && p.getAge() <= 60 : p.getAge() >= 18 && p.getAge() <= 65)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(workPersons);
    }
}
