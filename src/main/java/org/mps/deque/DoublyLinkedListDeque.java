package org.mps.deque;

import org.w3c.dom.Node;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        // TODO
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        // TODO
        if (size == 0) {
            DequeNode<T> newNode = new DequeNode<T>(value, null, null);
            first = newNode;
            last = newNode;
        } else {
            DequeNode<T> newNode = new DequeNode<T>(value, null, first);
            first.setPrevious(newNode);
            first = newNode;
        }
        size++;
    }

    @Override
    public void append(T value) {
        // TODO
        if (size == 0) {
            DequeNode<T> newNode = new DequeNode<T>(value, null, null);
            first = newNode;
            last = newNode;
        } else {
            DequeNode<T> newNode = new DequeNode<T>(value, null, last);
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if (size == 0) {
            throw new DoubleEndedQueueException("No es posible eliminar primer elemento. La cola está vacía");
        }
        if (size > 1) {
            first.getNext().setPrevious(null);
            first = first.getNext();
        } else {
            first = null;
            last = null;
        }
        size--;
    }

    @Override
    public void deleteLast() {
        // TODO
        if (size == 0) {
            throw new DoubleEndedQueueException("No es posible eliminar último elemento. La cola está vacía");
        }
        if (size > 1) {
            last.getPrevious().setNext(null);
            last = last.getPrevious();
        } else {
            first = null;
            last = null;
        }
        size--;
    }

    @Override
    public T first() {
        // TODO
        if (size == 0) {
            throw new DoubleEndedQueueException("No se encontró el primer elemento. La cola está vacía");
        }
        return first.getItem();
    }

    @Override
    public T last() {
        // TODO
        if (size == 0) {
            throw new DoubleEndedQueueException("No se encontró el último elemento. La cola está vacía");
        }
        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
}
