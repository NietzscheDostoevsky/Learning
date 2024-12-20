/***
 * Excerpted from "Functional Programming in Java, Second Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/vsjava2e for more book information.
***/
package fpij;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

public class Compare {
  public static void printPeople(
    final String message, final List<Person> people) {
      
    System.out.println(message);
    people.forEach(System.out::println);
  }
  
  public static void main(String[] args) {
    final List<Person> people = Arrays.asList(
      new Person("John", 20),
      new Person("Sara", 21),
      new Person("Jane", 21),
      new Person("Greg", 35));

{  
    System.out.println("//" + "START:AGE_ASCEND_OUTPUT");
    List<Person> ascendingAge = 
      people.stream()
            .sorted((person1, person2) -> person1.ageDifference(person2))
            .collect(toList());
    printPeople("Sorted in ascending order by age: ", ascendingAge);
    System.out.println("//" + "END:AGE_ASCEND_OUTPUT");
}

{  
    System.out.println("//" + "START:AGE_ASCEND_MR_OUTPUT");
    List<Person> ascendingAge = 
      people.stream()
            .sorted(Person::ageDifference)
            .collect(toList());

    printPeople("Sorted in ascending order by age: ", ascendingAge);
    System.out.println("//" + "END:AGE_ASCEND_MR_OUTPUT");
}

{
    System.out.println("//" + "START:AGE_DESCEND_OUTPUT");
    printPeople("Sorted in descending order by age: ",
      people.stream()
            .sorted((person1, person2) -> person2.ageDifference(person1))
            .collect(toList()));
    System.out.println("//" + "END:AGE_DESCEND_OUTPUT");

    System.out.println("//" + "START:REVERSE_ORDER_OUTPUT");
    Comparator<Person> compareAscending = 
      (person1, person2) -> person1.ageDifference(person2);
    Comparator<Person> compareDescending = compareAscending.reversed();

    printPeople("Sorted in ascending order by age: ",
      people.stream()
            .sorted(compareAscending)
            .collect(toList())
    );
    printPeople("Sorted in descending order by age: ",
      people.stream()
            .sorted(compareDescending)
            .collect(toList())
    );
    System.out.println("//" + "END:REVERSE_ORDER_OUTPUT");

    System.out.println("//" + "START:NAME_ASCEND_OUTPUT");
    printPeople("Sorted in ascending order by name: ",
      people.stream()
            .sorted((person1, person2) -> 
               person1.getName().compareTo(person2.getName()))
            .collect(toList()));
    System.out.println("//" + "END:NAME_ASCEND_OUTPUT");
}

{
    System.out.println("//" + "START:YOUNGEST_OUTPUT");
    people.stream()
          .min(Person::ageDifference)
          .ifPresent(youngest -> System.out.println("Youngest: " + youngest));
System.out.println("//" + "END:YOUNGEST_OUTPUT");
}

{
    System.out.println("//" + "START:ELDEST_OUTPUT");
    people.stream()
          .max(Person::ageDifference)
          .ifPresent(eldest -> System.out.println("Eldest: " + eldest));
    System.out.println("//" + "END:ELDEST_OUTPUT");
}

{
    people.stream()
          .sorted((person1, person2) -> 
             person1.getName().compareTo(person2.getName()));

    printPeople("Sorted in ascending order by name: ",
      people.stream()
            .sorted(comparing((Person person) -> person.getName()))
            .collect(toList()));

    final Function<Person, String> byName = person -> person.getName();
    people.stream()
          .sorted(comparing(byName));
}

{
    System.out.println("//" + "START:SORT_NAME_AND_AGE_OUTPUT");
    
    final Function<Person, Integer> byAge = person -> person.getAge();
    final Function<Person, String> byTheirName = person -> person.getName();
    
    printPeople("Sorted in ascending order by age and name: ",
      people.stream()
            .sorted(comparing(byAge).thenComparing(byTheirName))
            .collect(toList()));
    System.out.println("//" + "END:SORT_NAME_AND_AGE_OUTPUT");
}
  }
}
