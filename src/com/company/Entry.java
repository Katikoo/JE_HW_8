package com.company;

public class Entry<T extends Comparable<?>> {

    Object key;
    int value;
    Entry<T> left;
    Entry<T> right;
    Entry<T> parent;
    boolean isLeft = false;
    boolean isRight = false;
}