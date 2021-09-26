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
            System.out.println("Добавили строку " + list.getFirst() + " в начало списка. " + list);
            list.addLast("ddd");
            System.out.println("Добавили строку " + list.getLast() + " в конец списка. " + list);
            list.add("eee", 2);
            System.out.println("Добавили строку " + list.get(2) + " по 2 индексу. " + list);
            String element = list.removeFirst();
            System.out.println("Удалили первый элемент - " + element + ".  " + list);
            String element1 = list.removeLast();
            System.out.println("Удaлили последний элемент - " + element1 + ".  " + list);
            String element2 = list.remove(2);
            System.out.println("Удалили элемент по 2 индексу - " + element2 + ".  " +  list);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}