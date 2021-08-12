package com.company;

public interface StringLinkedList {

    void addFirst(String s);

    void add(String s, int index);

    void addLast(String s);

    String getFirst();

    String get(int i);

    String getLast();

    String removeFirst();

    String remove(int i);

    String removeLast();

    int size();

}