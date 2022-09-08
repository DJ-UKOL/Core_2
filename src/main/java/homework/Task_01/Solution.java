package homework.Task_01;

import java.util.*;
import java.util.stream.Collectors;
/*
 * Задача №1. При выполнении ДЗ стримами пользоваться не обязательно.
 * Лаконичность и красота кода при этом важны.
 * При выполнении использовал 2 варианта решения задачи.
 * В тесте добавил null элементы
 */
public class Solution {
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

    private static final Person[] RAW_DATA = new Person[]{
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
            new Person(8, "Amelia")
    };

    public static void main(String[] args) {

        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            if (person != null)
                System.out.println(person.id + " - " + person.name);
        }

        // Вывод в консоль описания
        inputHeadInfoInConsole();
        /* Вариант №1. С использованием Stream */
        Map<String, Long> groupPerson = getStringWithStream(RAW_DATA);

        // вывод в консоль результата
        inputMapInConsole(groupPerson);
        // Вывод в консоль описания
        inputHeadInfoInConsole();

        /* Вариант №2 */
        Map<String, Long> groupPerson2 = getStringWithoutStream(RAW_DATA);
        // вывод в консоль результата
        inputMapInConsole(groupPerson2);
    }

    static Map<String, Long> getStringWithStream(Person[] RAW_DATA) {
        return Arrays.stream(RAW_DATA)
                .distinct()                                     // отбрасываем дубликаты
                .filter(Objects::nonNull)                       // отбрасываем null объекты
                .filter(person -> person.getName() != null)     // отбрасываем объекты с null именем
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
    }

    static Map<String, Long> getStringWithoutStream(Person[] RAW_DATA) {
        Map<String, Long> groupPerson2 = new TreeMap<>();      // Создаем TreeMap для сортировки
        Set<Person> setPerson = new LinkedHashSet<>();         // Создаем связный список для удаления дубликатов

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
                    long count = groupPerson2.get(person.getName()); // Считываем количество (value)
                    // Меняем в мапе значение count увеличенное на единицу
                    groupPerson2.replace(person.getName(), ++count);
                } else {
                    groupPerson2.put(person.getName(), 1L);
                }
            }
        }
        return groupPerson2;
    }

    private static void inputHeadInfoInConsole() {
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();
    }

    public static void inputMapInConsole(Map<String, Long> map) {
        // вывод в консоль
        for (Map.Entry<String, Long> item : map.entrySet()) {
            System.out.println("Key: " + item.getKey());
            System.out.println("Value: " + item.getValue());
        }
    }
}
