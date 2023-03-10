package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListDequeTest {

    DoublyLinkedListDeque<Integer> list;

    @Nested
    @DisplayName("Tests for data insertion")
    class TestsForItemInsertion {

        @BeforeEach
        void setUp() {
            list = new DoublyLinkedListDeque<>();
            list.prepend(8);
            list.prepend(10);
        }

        @AfterEach
        void tearDown() {
            list = null;
        }

        //Checks that first correctly returns the last value prepended
        @Test
        @DisplayName("first() returns first element")
        void shouldReturnElementInFrontOfList() {
            list.prepend(20);
            Integer expected = 20;
            Integer returned = list.first();
            assertEquals(expected, returned);
        }

        //Check that last returns last element appended
        @Test
        @DisplayName("last() returns last element")
        void shouldReturnElementInEndOfList() {
            list.append(34);
            Integer expected = 34;
            Integer returned = list.last();
            assertEquals(expected, returned);
        }

    }

    @Nested
    @DisplayName("Tests for data deletion")
    class TestsForDataDeletion {

        @BeforeEach
        void setUp() {
            list = new DoublyLinkedListDeque<>();
            list.prepend(8);
            list.prepend(10);
            list.prepend(20);
        }

        @AfterEach
        void tearDown() {
            list = null;
        }

        //Check that deleteFirst correctly deletes first element and assigns new first
        @Test
        @DisplayName("deleteFirst() should remove first element")
        void shouldRemoveElementInFrontOfList() {
            list.deleteFirst();

            Integer expectedFirst = 10;
            Integer returnedFirst = list.first();

            Integer expectedLast = 8;
            Integer returnedLast = list.last();

            assertEquals(expectedFirst, returnedFirst);
            assertEquals(expectedLast, returnedLast);
        }

        //Check that removeLast correctly deletes last element and assigns new last
        @Test
        @DisplayName("removeLast() returns last element")
        void shouldReturnElementInEndOfList() {
            list.deleteLast();

            Integer expectedFirst = 20;
            Integer returnedFirst = list.first();

            Integer expectedLast = 10;
            Integer returnedLast = list.last();

            assertEquals(expectedFirst, returnedFirst);
            assertEquals(expectedLast, returnedLast);
        }

    }

    @Nested
    @DisplayName("Tests for empty DoublyLinkedListDeque")
    class TestsForEmptyQueue {

        @BeforeEach
        void setup() {
            list = new DoublyLinkedListDeque<>();
        }

        @AfterEach
        void tearDown() {
            list = null;
        }

        //When queue is empty, first raises an Exception
        @Test
        @DisplayName("first() method should raise DoubleEndedQueueException if queue is empty")
        void shouldReturnExceptionWhenCallingFirstFromAnEmptyQueue() {
            assertThrows(DoubleEndedQueueException.class, () -> list.first());
        }

        //When queue is empty, last raises an Exception
        @Test
        @DisplayName("last() method should raise DoubleEndedQueueException if queue is empty")
        void shouldReturnExceptionWhenCallingLastFromAnEmptyQueue() {
            assertThrows(DoubleEndedQueueException.class, () -> list.last());
        }

        //When queue is empty, deleteFirst and deleteLast raise an Exception
        @Test
        @DisplayName("deleteFirst() and deleteLast() should raise DoubleEndedQueueException if queue is emtpy")
        void shouldReturnExceptionWhenDeletingFromAnEmptyQueue() {
            assertThrows(DoubleEndedQueueException.class, () -> list.deleteFirst());
            assertThrows(DoubleEndedQueueException.class, () -> list.deleteLast());
        }

    }

    @Nested
    @DisplayName("Tests for size() method")
    class TestsForSizeMethod {

        @BeforeEach
        void setup() {
            list = new DoublyLinkedListDeque<>();
        }

        @AfterEach
        void tearDown() {
            list = null;
        }

        //Check that size returns 0 when queue is empty
        @Test
        @DisplayName("size() should return size correctly")
        void sizeOfAnEmptyQueueIsZero() {
            int expected = 0;
            int returned = list.size();

            assertEquals(expected, returned);

            list.append(10);
            list.deleteFirst();

            assertEquals(expected, returned);
        }

        //Check that size returns correct values after appending and prepending
        @Test
        @DisplayName("append() and prepend() should increase size by 1")
        void sizeAfterAppendOrPrependIncreasesOne() {
            list.append(20);

            int expected = 1;
            int returned = list.size();

            assertEquals(expected, returned);

            list.prepend(30);

            expected = 2;
            returned = list.size();

            assertEquals(expected, returned);
        }

        //Check that size correctly returns values after deleting
        @Test
        @DisplayName("deleteFirst() and deleteLast() should decrease size by 1")
        void sizeAfterDeleteDecreasesOne() {
            list.append(20);
            list.append(10);

            list.deleteFirst();

            int expected = 1;
            int returned = list.size();

            assertEquals(expected, returned);

            list.deleteLast();

            expected = 0;
            returned = list.size();

            assertEquals(expected, returned);
        }

    }

}