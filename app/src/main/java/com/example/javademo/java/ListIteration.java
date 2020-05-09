package com.example.javademo.java;//: holding/ListIteration.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListIteration {
    public static void main(String[] args) {
        List<String> pp = Arrays.asList("admin", "what this", "spaces", "feature", "uimian", "who that",
                "nonoN", "open");
        List<String> pets = new ArrayList<>(pp);
        ListIterator<String> it = pets.listIterator();
        while (it.hasNext()) {

            System.out.print(it.next() + ", " + it.nextIndex() +
                    ", " + it.previousIndex() + "; ");
            System.out.println();
        }
        // Backwards:
        while (it.hasPrevious()) {
            System.out.print(it.previous() + "- ");
        }
        System.out.println();
        System.out.println(pets);
        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set("");
        }
        System.out.println(pets);
    }
} /* Output:
Rat, 1, 0; Manx, 2, 1; Cymric, 3, 2; Mutt, 4, 3; Pug, 5, 4; Cymric, 6, 5; Pug, 7, 6; Manx, 8, 7;
7 6 5 4 3 2 1 0
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
[Rat, Manx, Cymric, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau]
*///:~
