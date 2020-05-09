package com.example.javademo.java;//: holding/SimpleIteration.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class SimpleIteration {
    public static void main(String[] args) {
        List<String> pp = Arrays.asList("admin", "what this", "spaces", "feature","uimian","who that",
                "nonoN");
        List<String> pets = new ArrayList<>(pp);
        Iterator<String> it = pets.iterator();
        while (it.hasNext()) {
            String p = it.next();
            System.out.print("" + p + " ");
        }
        System.out.println();
        // A simpler approach, when possible:
        for (String p : pets)
            System.out.print("" + p + " ");
        System.out.println();
        // An Iterator can also remove elements:
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }
}
/* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 8:Cymric 9:Rat 10:EgyptianMau 11:Hamster
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 8:Cymric 9:Rat 10:EgyptianMau 11:Hamster
[Pug, Manx, Cymric, Rat, EgyptianMau, Hamster]
*///:~
