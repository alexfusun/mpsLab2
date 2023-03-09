package org.mps.deque;

/*
    Test cases
    1.Test get methods
        1.1. getItem()
        1.2. getPrevious()
        1.3. getNext()
    2.Test set methods
        2.1. setItem()
        2.2. setNext()
        2.3. setPrevious()
    3.Test position methods
        3.1. isFirstNode()
        3.2. isLastNode()
        3.3. isNotATerminalNode()
 */

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {
    DequeNode<Integer> node1,node2,node3;
    @BeforeEach
    void setup(){
        node1 = new DequeNode<>(1,null,null);
        node2 = new DequeNode<>(2,node1,null);
        node3 = new DequeNode<>(3,node2,null);
    }

    @Nested
    @DisplayName("Test get methods")
    class TestCasesForGetters{
        @Test
        void getItem(){
            assertEquals(1, node1.getItem());
            assertEquals(2, node2.getItem());
            assertEquals(3, node3.getItem());
        }

        @Test
        void getPrevious(){
            assertNull(node1.getPrevious());
            assertEquals(node1, node2.getPrevious());
            assertEquals(node2, node3.getPrevious());
        }

        @Test
        void getNext(){
            DequeNode<Integer> newNode = new DequeNode<>(5,null,node1);

            assertEquals(node1, newNode.getNext());

            assertNull(node1.getNext());
            assertNull(node2.getNext());
            assertNull(node3.getNext());
        }
    }

    @Nested
    @DisplayName("Test set methods")
    class TestCasesForSetters{
        @Test
        void setItem(){
            node1.setItem(8);
            assertEquals(8, node1.getItem());
        }

        @Test
        void setNext(){
            DequeNode<Integer> newNode = new DequeNode<>(8,node2,null);
            node2.setNext(newNode);
            assertEquals(newNode, node2.getNext());
        }

        @Test
        void setPrevious(){
            DequeNode<Integer> newNode = new DequeNode<>(8,null,node3);
            node3.setPrevious(newNode);
            assertEquals(newNode, node3.getPrevious());
        }
    }

    @Nested
    @DisplayName("Test position methods")
    class TestCasesForPositionMethods{
        @Test
        void isFirstNode(){
            assertTrue(node1.isFirstNode());
            assertFalse(node2.isFirstNode());
            assertFalse(node3.isFirstNode());
        }

        @Test
        void isLastNode(){
            DequeNode<Integer> newNode = new DequeNode<>(5,null,node1);

            assertFalse(newNode.isLastNode());

            assertTrue(node1.isLastNode());
            assertTrue(node2.isLastNode());
            assertTrue(node3.isLastNode());
        }

        @Test
        void isNotATerminalNode(){
            DequeNode<Integer> newNode = new DequeNode<>(5,node1,node2);

            assertTrue(newNode.isNotATerminalNode());

            assertFalse(node1.isNotATerminalNode());
            assertFalse(node2.isNotATerminalNode());
            assertFalse(node3.isNotATerminalNode());
        }
    }

    @AfterEach
    void shutdown(){
        node1 = null;
        node2 = null;
        node3 = null;
    }
}