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
            Node newNode = new Node(s);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
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
            first = first.getNext();
            first.setPrevious(null);
            reWriteIndex();
        }
        return first.getValue();
    }

    @Override
    public String remove(int i) {
        if (i < 0 || i > last.getIndex()) {
            throw new IllegalArgumentException();
        }
        Node prev = findNode(i - 1);
        Node curr = findNode(i);
        if (i == 0 || last.getIndex() == 0) {
            return removeFirst();
        } else if (i == last.getIndex() - 1) {
            return removeLast();
        }
        prev.setNext(curr.getNext());
        prev = curr;
        curr = prev.getNext();
        reWriteIndex();
        return curr.getValue();
    }


    @Override
    public String removeLast() {
        if (size() == 1) {
            first = null;
            last = null;
            return null;
        } else {
            last = findNode(last.getIndex() - 2);
            last.setNext(null);
        }
        return last.getValue();
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

