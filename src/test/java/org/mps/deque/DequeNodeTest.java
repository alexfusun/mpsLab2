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

        //Checks that return the item value
        @Test
        @DisplayName("getItem() returns item value")
        void getItem(){
            assertEquals(1, node1.getItem());
            assertEquals(2, node2.getItem());
            assertEquals(3, node3.getItem());
        }

        //Checks that returns the previous value
        @Test
        @DisplayName("getPrevious() returns previous value")
        void getPrevious(){
            assertNull(node1.getPrevious());
            assertEquals(node1, node2.getPrevious());
            assertEquals(node2, node3.getPrevious());
        }

        //Checks that returns the next value
        @Test
        @DisplayName("getNext() returns next value")
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

        //Checks that the item value change to the given value
        @Test
        @DisplayName("setItem() sets a new value for item")
        void setItem(){
            node1.setItem(8);
            assertEquals(8, node1.getItem());
        }

        //Checks that the next value change to the given value
        @Test
        @DisplayName("setNext() sets a new value for next")
        void setNext(){
            DequeNode<Integer> newNode = new DequeNode<>(8,node2,null);
            node2.setNext(newNode);
            assertEquals(newNode, node2.getNext());
        }

        //Checks that the previous value change to the given value
        @Test
        @DisplayName("setPrevious() sets a new value for previous")
        void setPrevious(){
            DequeNode<Integer> newNode = new DequeNode<>(8,null,node3);
            node3.setPrevious(newNode);
            assertEquals(newNode, node3.getPrevious());
        }
    }

    @Nested
    @DisplayName("Test position methods")
    class TestCasesForPositionMethods{

        //Checks that returns true only if the node is the first
        @Test
        @DisplayName("isFirstNode() method returns true if the given node it is the first")
        void isFirstNode(){
            assertTrue(node1.isFirstNode());
            assertFalse(node2.isFirstNode());
            assertFalse(node3.isFirstNode());
        }

        //Checks that returns true only if the node is the last
        @Test
        @DisplayName("isLastNode() method returns true if the given node it is the last")
        void isLastNode(){
            DequeNode<Integer> newNode = new DequeNode<>(5,null,node1);

            assertFalse(newNode.isLastNode());

            assertTrue(node1.isLastNode());
            assertTrue(node2.isLastNode());
            assertTrue(node3.isLastNode());
        }

        //Checks that returns true only if the node is not a terminal node
        @Test
        @DisplayName("isNotATerminalNode() method returns true if the given node it is not a terminal node")
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