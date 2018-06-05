package com.velykyi.test2;

import java.util.Collection;

public class test2 {

    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o);
        }
    }

}
