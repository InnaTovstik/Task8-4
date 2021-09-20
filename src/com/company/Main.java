package com.company;

public class Main {

public static void main(String[] args) {

        StringLinkedList list = new StringLinkedListImpl();
        list.addFirst("hello");
        list.add("hell", 1);
        list.add("hel", 2);
        list.add("he", 3);
        System.out.println(list);
    }

}