//: holding/MapOfList.java
package com.example.javademo.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static net.mindview.util.Print.print;

public class MapOfList {
  public static Map<String, List<String>>
    petPeople = new HashMap<String, List<String>>();
  static {
    petPeople.put(new String("Dawn"),
      Arrays.asList(new String("Molly"),new String("Spot")));
    petPeople.put(new String("Kate"),
      Arrays.asList(new String("Shackleton"),
        new String("Elsie May"), new String("Margrett")));
    petPeople.put(new String("Marilyn"),
      Arrays.asList(
       new String("Louie aka Louis Snorkelstein Dupree"),
       new String("Stanford aka Stinky el Negro"),
       new String("Pinkola")));
    petPeople.put(new String("Luke"),
      Arrays.asList(new String("Fuzzy"), new String("Fizzy")));
    petPeople.put(new String("Isaac"),
      Arrays.asList(new String("Freckly")));
  }
  public static void main(String[] args) {
    print("People: " + petPeople.keySet());
    print("Pets: " + petPeople.values());
    for(String person : petPeople.keySet()) {
      print(person + " has:");
      for(String pet : petPeople.get(person))
        print("    " + pet);
    }
  }
} /* Output:	
People: [Person Luke, Person Marilyn, Person Isaac, Person Dawn, Person Kate]
Pets: [[Rat Fuzzy, Rat Fizzy], [Pug Louie aka Louis Snorkelstein Dupree, Cat Stanford aka Stinky el Negro, Cat Pinkola], [Rat Freckly], [Cymric Molly, Mutt Spot], [Cat Shackleton, Cat Elsie May, Dog Margrett]]
Person Luke has:
    Rat Fuzzy
    Rat Fizzy
Person Marilyn has:
    Pug Louie aka Louis Snorkelstein Dupree
    Cat Stanford aka Stinky el Negro
    Cat Pinkola
Person Isaac has:
    Rat Freckly
Person Dawn has:
    Cymric Molly
    Mutt Spot
Person Kate has:
    Cat Shackleton
    Cat Elsie May
    Dog Margrett
*///:~
