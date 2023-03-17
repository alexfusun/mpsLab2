package org.mps.deque;

import org.w3c.dom.Node;

import java.util.Comparator;
import java.util.Deque;
import java.util.Objects;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    /*
    @author Juan Manuel Montiel Fernández
    @author Alex Fu Sun
     */

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
            DequeNode<T> newNode = new DequeNode<T>(value, last, null);
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

    @Override
    public T get(int index){
        //TODO
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        if(index == 0){
            return first.getItem();
        }else if(index == size - 1){
            return last.getItem();
        }else{
            DequeNode<T> Node = first.getNext();
            for(int i = 1; i < index; i++){
                Node = Node.getNext();
            }
            return Node.getItem();
        }
    }

    @Override
    public boolean contains(T value){
        //TODO
        DequeNode<T> Node = first;
        while(Node.getNext() != null){
            if(Objects.equals(Node.getItem(), value)){
                return true;
            }
            Node = Node.getNext();
        }
        return false;
    }

    @Override
    public void remove(T value){
        //TODO
        DequeNode<T> Node = first;
        boolean deleted = false;

        if(Node.getItem().equals(value)) {                                      //Es el primer Nodo
            this.deleteFirst();
        } else {
            while (Node.getNext() != null && deleted == false) {
                Node = Node.getNext();
                if (Node.getItem().equals(value)) {
                    if (Node.getPrevious() != null && Node.getNext() != null) { //Es un Nodo central
                        Node.getPrevious().setNext(Node.getNext());
                        Node.getNext().setPrevious(Node.getPrevious());
                    } else {                       //Es el ultimo Nodo
                        Node.getPrevious().setNext(null);
                    }
                    Node.setPrevious(null);
                    Node.setNext(null);
                    Node.setItem(null);
                    this.size--;
                    deleted = true;
                }
            }
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        //TODO
        DequeNode<T> node = last;
        DequeNode<T> previous = last.getPrevious();

        int contador = this.size-1;             //Localiza el nodo previous

        while (contador > 0) {
            if (comparator.compare(node.getItem(), previous.getItem()) < 0) {

                if (node.getNext() == null) {
                    last = previous;
                } else {
                    previous.setNext(node.getNext());
                }

                if (previous.getPrevious() == null) {
                    first = node;
                } else {
                    node.setPrevious(previous.getPrevious());
                }

                previous.setPrevious(node);
                node.setNext(previous);
                contador++;

                if(node.getNext().getNext() != null) {
                    node = node.getNext();
                }

            } else {
                node = previous;
                previous = previous.getPrevious();
                contador--;
            }
        }
    }
}
