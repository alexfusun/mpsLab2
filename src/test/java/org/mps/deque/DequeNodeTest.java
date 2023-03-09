package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {

    @BeforeEach
    void setup() {
        int item = 8;
        DequeNode<Integer> nodo = new DequeNode<int>(item, null, null);
    }

    @Test
    @DisplayName("")
    void setItem(){
        assertEquals(item, nodo.getItem());
    }

    @Test
    @DisplayName("")
    void getItem(){
        DequeNode<T> nodo = new DequeNode<T>(ite

        assertEquals()
    }


    @Test
    @DisplayName("")
    void setPrevious(DequeNode<T> esperado){
        assertEquals(esperado, this.previous);
    }

    @Test
    @DisplayName("")
    void setNext(DequeNode<T> esperado){
        assertEquals(esperado, this.next);
    }
}