package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTreeMap<K> {

    private Entry root;
    private int size = 0;
    private Map<Object, Integer> map = new HashMap<>();
    private List<Entry> list = new ArrayList<>();


    public void put(K key, int value) {
        if (containsKey(key)) {
            return;
        }
        Entry entry = new Entry();
        entry.key = key;
        entry.value = value;
        if (root == null) {
            root = entry;
        } else {
            addToTree(root, entry);
        }
        size++;
        map.put(key, value);
        list.add(entry);
    }

    private void addToTree(Entry root, Entry entry) {
        if (entry.value < root.value) {
            if (root.left == null) {
                root.left = entry;
                entry.parent = root;
                entry.isLeft = true;
            } else {
                addToTree(root.left, entry);
            }
        } else if (entry.value > root.value) {
            if (root.right == null) {
                root.right = entry;
                entry.parent = root;
                entry.isRight = true;
            } else {
                addToTree(root.right, entry);
            }
        }
    }

    public boolean containsKey(Object o) {
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            if (o.equals(entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Integer o) {
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            if (o.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public void remove(Object o) {
        if (containsKey(o) && size != 0) {
            if (size == 1) {
                clear();
            } else {
                removeFromTree(o);
                size--;
            }
        }
    }

    private void removeFromTree(Object o) {
        for (Entry entry : list) {
            if (o.equals(entry.key)) {
                if (entry.left == null && entry.right == null) {
                    if (entry.isRight) {
                        entry.parent.right = null;
                    } else if (entry.isLeft) {
                        entry.parent.left = null;
                    }
                    list.remove(entry);
                    map.remove(o);
                } else if (entry.left == null) {
                    if (entry.isRight) {
                        entry.parent.right = entry.right;
                    } else if (entry.isLeft) {
                        entry.parent.left = entry.right;
                    }
                    list.remove(entry);
                    map.remove(o);
                } else if (entry.right == null) {
                    if (entry.isRight) {
                        entry.parent.right = entry.left;
                    } else if (entry.isLeft) {
                        entry.parent.left = entry.left;
                    }
                    list.remove(entry);
                    map.remove(o);
                } else {
                    list.remove(entry);
                    map.remove(o);
                    clear();
                    map.forEach((key, value) -> put((K) key, value));
                }
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    private void clear() {
        map.clear();
        list.clear();
        size = 0;
        root = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey())
                    .append(" = ")
                    .append(entry.getValue())
                    .append(", ");
        }
        return "[" + sb.toString().substring(0, sb.toString().length() - 2) + "]";
    }

    public void print() {
        TreePrint.printNode(root);
    }
}