package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            StringLinkedList list = new StringLinkedListImpl();

            list.add("aaa", 0);
            list.add("bbb", 1);
            list.add("zzz", 2);
            System.out.println(list);


            list.addFirst("ccc");
            System.out.println("Добавили строку \"ccc\" в начало списка. " + list);
            list.addLast("ddd");
            System.out.println("Добавили строку \"ddd\" в конец списка. " + list);
            list.add("eee", 2);
            System.out.println("Добавили строку \"eee\" по 2 индексу. " + list);
            list.removeFirst();
            System.out.println("Удалили первый элемент. " + list);
            list.removeLast();
            System.out.println("Удaлили последний элемент. " + list);
//            list.remove(2);
//            System.out.println("Удалили элемент по 2 индексу. " + list);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}