package com.company;

class StringLinkedListImpl implements StringLinkedList {

    private Node first;
    private Node last;

    public Node findNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size() / 2) {
            Node current = first;
            for (int i = 0; i < index; i++)
                current = current.getNext();
            return current;
        } else {
            Node current = last;
            for (int i = size() - 1; i > index; i--)
                current = current.getPrevious();
            return current;
        }
    }

    private void reWriteIndex() {
        Node node = first;
        int index = 0;
        while (index < size()) {
            node.setIndex(index);
            node = node.getNext();
            index++;
        }
    }

    @Override
    public String toString() {
        Node node = first;
        String str = "StringLinkedList ";
        while (node != null) {
            str = String.format("%s  [%d]= %s",
                    str,
                    node.getIndex(),
                    node.getValue());
            node = node.getNext();
        }
        return str;
    }

    public StringLinkedListImpl() {
        first = null;
        last = null;
    }

    @Override
    public void addFirst(String s) {

        Node newNode = new Node(s);
        if (first != null) {
            Node oldFirstNode = first;
            oldFirstNode.setPrevious(newNode);
            newNode.setNext(oldFirstNode);
            first = newNode;
            reWriteIndex();
        } else {
            newNode.setNext(null);
            newNode.setPrevious(null);
            first = newNode;
            last = newNode;
            first.setIndex(0);
            last.setIndex(0);
        }
    }

    @Override
    public void add(String s, int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            addFirst(s);
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == size()) {
            addLast(s);
        } else {
            Node current = findNode(index);
            Node prev = current.getPrevious();
            Node newNode = new Node(s);
            newNode.setNext(current);
            newNode.setPrevious(current.getPrevious());
            current.setPrevious(newNode);
            prev.setNext(newNode);
            reWriteIndex();
        }
    }

    @Override
    public void addLast(String s) {
        if (last == null) {
            addFirst(s);
        } else {
            Node newNode = new Node(s);
            last.setNext(newNode);
            newNode.setPrevious(last);
            newNode.setIndex(last.getIndex() + 1);
            last = newNode;
        }
    }

    @Override
    public String getFirst() {
        return first.getValue();
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > last.getIndex()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return getFirst();
        } else if (index == last.getIndex()) {
            return getLast();
        } else {
            return findNode(index).getValue();
        }
    }

    @Override
    public String getLast() {
        return last.getValue();
    }

    @Override
    public String removeFirst() {
        if (last.getIndex() == 1) {
            first = null;
            last = null;
            return null;
        } else {
            String firstValue = first.getValue();
            first = first.getNext();
            first.setPrevious(null);
            reWriteIndex();
            return firstValue;
        }
    }

    @Override
    public String remove(int i) {
        if (i < 0 || i > last.getIndex()) {
            throw new IllegalArgumentException();
        }
        if (i == 0 || size() == 1) {
            return removeFirst();
        } else if (i == size() - 1) {
            return removeLast();
        }
        Node curr = findNode(i);
        String valueCurrent = curr.getValue();
        Node prev = curr.getPrevious();
        Node next = curr.getNext();
        prev.setNext(next);
        next.setPrevious(prev);
        reWriteIndex();
        return valueCurrent;
    }

    @Override
    public String removeLast() {
        if (size() == 1) {
            first = null;
            last = null;
            return null;
        } else {
            String lastValue = last.getValue();
            last = last.getPrevious();
            last.setNext(null);
            return lastValue;
        }
    }

    @Override
    public int size() {
        if (first == null || last == null) {
            return 0;
        } else {
            int size = 1;
            Node node = first;
            while (node.getNext() != null) {
                node = node.getNext();
                size++;
            }
            return size;
        }
    }
}

