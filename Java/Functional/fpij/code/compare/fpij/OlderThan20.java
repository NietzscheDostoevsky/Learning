/***
 * Excerpted from "Functional Programming in Java, Second Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/vsjava2e for more book information.
***/
package fpij;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import static java.util.stream.Collectors.*;

public class OlderThan20 {
  public static void main(String[] args) {
    final List<Person> people = Arrays.asList(
      new Person("John", 20),
      new Person("Sara", 21),
      new Person("Jane", 21),
      new Person("Greg", 35));

{  
    System.out.println("//" + "START:MUTABLE_OUTPUT");
    List<Person> olderThan20 = new ArrayList<>();
      people.stream()
            .filter(person -> person.getAge() > 20)
            .forEach(person -> olderThan20.add(person)); //BAD IDEA
    System.out.println("People older than 20: " + olderThan20);
    System.out.println("//" + "END:MUTABLE_OUTPUT");
}

{  
    System.out.println("//" + "START:COLLECT_OUTPUT");
    List<Person> olderThan20 = 
      people.stream()
            .filter(person -> person.getAge() > 20)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll); //VERBOSE
    System.out.println("People older than 20: " + olderThan20);
    System.out.println("//" + "END:COLLECT_OUTPUT");
}

{  
    System.out.println("//" + "START:COLLECT_TO_LIST_OUTPUT");
    List<Person> olderThan20 = 
      people.stream()
            .filter(person -> person.getAge() > 20)
            .collect(Collectors.toList());
    System.out.println("People older than 20: " + olderThan20);
    System.out.println("//" + "END:COLLECT_TO_LIST_OUTPUT");
}

{  
    System.out.println("//" + "START:GROUP_BY_OUTPUT");
    Map<Integer, List<Person>> peopleByAge = 
      people.stream()
            .collect(Collectors.groupingBy(Person::getAge));
    System.out.println("Grouped by age: " + peopleByAge);
    System.out.println("//" + "END:GROUP_BY_OUTPUT");
}

{  
    System.out.println("//" + "START:GROUP_BY_AGE_NAME_OUTPUT");
    Map<Integer, List<String>> nameOfPeopleByAge = 
      people.stream()
            .collect(
              groupingBy(Person::getAge, mapping(Person::getName, toList())));
    System.out.println("People grouped by age: " + nameOfPeopleByAge);
    System.out.println("//" + "END:GROUP_BY_AGE_NAME_OUTPUT");
}

{  
    System.out.println("//" + "START:OLDEST_IN_EACH_LETTER_OUTPUT");
    Comparator<Person> byAge = Comparator.comparing(Person::getAge);
    Map<Character, Optional<Person>> oldestPersonOfEachLetter = 
      people.stream()
            .collect(groupingBy(person -> person.getName().charAt(0),
               reducing(BinaryOperator.maxBy(byAge))));
    System.out.println("Oldest person of each letter:");
    System.out.println(oldestPersonOfEachLetter);
    System.out.println("//" + "END:OLDEST_IN_EACH_LETTER_OUTPUT");
}
  }
}
