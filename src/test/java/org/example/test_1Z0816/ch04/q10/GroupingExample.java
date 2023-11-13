package org.example.test_1Z0816.ch04.q10;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Stream 分組操作
 */
public class GroupingExample {
    public static void main(String[] args) {
        // 假設有一個人員列表
        List<Person> people = List.of(
                new Person("Alice", "Accounting"),
                new Person("Bob", "HR"),
                new Person("Charlie", "IT"),
                new Person("Diana", "Accounting")
        );

        // 按部門對人員進行分組
        Map<String, List<Person>> peopleByDepartment = people.stream()
                .collect(Collectors.groupingBy(Person::getDepartment));

        // 打印分組後的結果
        peopleByDepartment.forEach((department, peopleInDepartment) ->
                System.out.println(department + ": " + peopleInDepartment));
    }

    static class Person {
        private String name;
        private String department;

        public Person(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
