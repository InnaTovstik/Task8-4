package com.company;

class StringLinkedListImpl implements StringLinkedList {

    private Node first;
    private Node last;
    private int size;

    @Override
    public String toString() {
        Node node = first;
        String toStr = "StringLinkedListImpl{";
        while(node != null) {
            toStr = toStr + "["
                    + node.getIndex()
                    + "]= " + node.getValue() + ", ";
            node = node.getNext(); // Move to next node.
        }
        return toStr;
    }

    public StringLinkedListImpl() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void addFirst(String s) {
        Node newNode = new Node(s);
        newNode.setNext(null);
        newNode.setPrevious(null);
        newNode.setIndex(0);
        first = newNode;
        last = newNode;
        size++;
    }

    @Override
    public void add(String s, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(s);
        } else if (index == size) {
            addLast(s);
        } else {
            Node newNode = new Node(s);
            Node oldNode = first;

            for (int i = 0; i < index; i++) {
                oldNode = oldNode.getNext();
            }
            Node oldPrevious = oldNode.getPrevious();
            oldPrevious.setNext(newNode);
            oldNode.setPrevious(newNode);
            newNode.setPrevious(oldPrevious);
            newNode.setNext(oldNode);
            newNode.setIndex(index);
            size++;
        }
    }

    @Override
    public void addLast(String s) {
        Node newNode = new Node(s);
        if (first == null) {
            addFirst(s);
        } else {
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
       }
        size++;
        last.setIndex(size);
    }

    @Override
    public String getFirst() {
        return first.getValue();
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node target = first;
        for (int i = 0; i < index; i++) {
            target = target.getNext();
        }
        return target.getValue();
    }

    @Override
    public String getLast() {
        return last.getValue();
    }

    @Override
    public String removeFirst() {
        if (size == 1) {
            first = null;
            last = null;
            size = 0;
            return null;
        } else {

        }
        return null;
    }

    @Override
    public String remove(int i) {
        if (i < 0 || i > size - 1) {
            throw new IllegalArgumentException();
        }
        Node prev = first;
        Node curr = first;
        if (i == 0 || size == 1) {
            removeFirst();
        } else if (i == size) {
            removeLast();
        } else {
            while (curr.getNext() != null || curr == last) {
                if (curr.getIndex() == i) {
                    prev.setNext(curr.getNext());
                }
            }
            size--;
        }
        prev =  curr;
        curr = prev.getNext();
        return curr.getValue();
    }


    @Override
    public String removeLast() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}

