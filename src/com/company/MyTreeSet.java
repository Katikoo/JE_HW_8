package com.company;

import java.util.ArrayList;
import java.util.List;

public class MyTreeSet<K> {

    private MyTreeMap<K> map = new MyTreeMap<>();
    private List<K> list = new ArrayList<>();

    public void add(K k) {
        int DEFAULT_INT = 0;
        map.put(k, DEFAULT_INT);
        list.add(k);
    }

    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public void remove(K k) {
        map.remove(k);
        list.remove(k);
    }

    public int size() {
        return map.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}