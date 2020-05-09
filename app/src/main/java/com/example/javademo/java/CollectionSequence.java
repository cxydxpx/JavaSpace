package com.example.javademo.java;//: holding/CollectionSequence.java

import androidx.annotation.NonNull;

import java.util.AbstractCollection;
import java.util.Iterator;

public class CollectionSequence extends AbstractCollection<String> {

    private String[] pets = new String[]{"b", "c", "a", "d", "g", "e", "f", "h"};

    @NonNull
    @Override
    public Iterator<String> iterator() {
            return new Iterator<String>() {
                private int index = 0;

                public boolean hasNext() {
                    return index < pets.length;
                }

                public String next() {
                    return pets[index++];
                }

                public void remove() { // Not implemented
                    throw new UnsupportedOperationException();
                }
            };
    }

    public int size() {
        return pets.length;
    }


    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
} /* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
*///:~
