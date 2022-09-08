package homework;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ComplexExamples {

    static class Person {
        final int id;
        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)                                  // Если ссылки на сравниваемые объекты равны
                return true;                                // то вернуть истину
            if (!(o instanceof Person person))              // Если сравниваемый объект не создан на основе Person
                return false;                               // вернуть ложь
            return getId() == person.getId()                // Если идентификаторы равны
                    && getName().equals(person.getName());  // и имена равны, вернуть истину, иначе ложь
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
            new Person(9, null),         // Добавим для теста объект в именем null
            null                                  // и просто объект null
    };

    public static void main(String[] args) {

        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            if (person != null)
                System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();


        /* Task 1. Вариант №1. С использованием Stream */
        Map<String, Long> groupPerson = Arrays.stream(RAW_DATA)
                .distinct()                                     // отбрасываем дубликаты
                .filter(Objects::nonNull)                       // отбрасываем null объекты
                .filter(person -> person.getName() != null)     // отбрасываем объекты с null именем
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));    // группируем

        // вывод в консоль
        for (Map.Entry<String, Long> item : groupPerson.entrySet()) {
            System.out.println("Key: " + item.getKey());
            System.out.println("Value: " + item.getValue());
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        /* Task 1. Вариант №2 */
        Map<String, Integer> groupPerson2 = new TreeMap<>();            // Создаем TreeMap для сортировки
        Set<Person> setPerson = new LinkedHashSet<>();                  // Создаем связный список для удаления дубликатов

        // Из массива в список и удаляем дубликаты с проверкой на null
        for (Person rawDatum : RAW_DATA) {
            if (rawDatum != null) {
                setPerson.add(rawDatum);
            }
        }

        // Проходим в цикле по элементам массива
        for (Person person : setPerson) {
            if (person.getName() != null) {                         // Если имя не null, то
                if (groupPerson2.containsKey(person.getName())) {   // Если в мапе есть уже такое имя (key),
                    int count = groupPerson2.get(person.getName()); // Считываем количество (value)
                    // Меняем в мапе значение count увеличенное на единицу
                    groupPerson2.replace(person.getName(), ++count);
                } else {
                    groupPerson2.put(person.getName(), 1);
                }
            }
        }

        // вывод в консоль
        for (Map.Entry<String, Integer> item : groupPerson2.entrySet()) {
            System.out.println("Key: " + item.getKey());
            System.out.println("Value: " + item.getValue());
        }

        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */



        /*
        Task3
            Реализовать функцию нечеткого поиска
                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */
    }
}
