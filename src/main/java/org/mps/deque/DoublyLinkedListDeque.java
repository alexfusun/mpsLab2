package org.mps.deque;

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
    }

    @Override
    public void append(T value) {
        // TODO
        if (first == null) {
            first = new DequeNode(value)
        }
    }

    @Override
    public void deleteFirst() {
        // TODO
    }

    @Override
    public void deleteLast() {
        // TODO
    }

    @Override
    public T first() {
        // TODO
        return null;
    }

    @Override
    public T last() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
}
