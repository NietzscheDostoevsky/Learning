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
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.stream.Collectors.joining;
import java.util.StringJoiner;
import static fpij.Folks.friends;

public class PrintList {
  public static void main(final String[] args) {
System.out.println("//" + "START:FOREACH_OUTPUT");
    for(String name : friends) {
      System.out.print(name + ", ");
    }
    System.out.println();
System.out.println("//" + "END:FOREACH_OUTPUT");

System.out.println("//" + "START:FOR_OUTPUT");
    for(int i = 0; i < friends.size() - 1; i++) {
      System.out.print(friends.get(i) + ", ");
    }
    
    if(friends.size() > 0) 
      System.out.println(friends.get(friends.size() - 1));
System.out.println("//" + "END:FOR_OUTPUT");

System.out.println("//" + "START:JOIN_OUTPUT");
    System.out.println(String.join(", ", friends));
System.out.println("//" + "END:JOIN_OUTPUT");

System.out.println("//" + "START:MAP_JOIN_OUTPUT");
    System.out.println(
      friends.stream()
             .map(String::toUpperCase)
             .collect(joining(", ")));
System.out.println("//" + "END:MAP_JOIN_OUTPUT");

  }
}
