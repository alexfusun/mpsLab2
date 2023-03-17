package org.mps.deque;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListDequeTest {

    /*
    @author Juan Manuel Montiel Fernández
    @author Alex Fu Sun
     */

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
            list.prepend(18);
            list.prepend(20);
            list.append(44);
            Integer expected = 20;
            Integer returned = list.first();
            assertEquals(expected, returned);
        }

        //Check that last returns last element appended
        @Test
        @DisplayName("last() returns last element")
        void shouldReturnElementInEndOfList() {
            list.append(11);
            list.prepend(32);
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

        //Check that remove(T value) deletes the value if it is present on the queue and update the next and previous Nodes
        @Test
        @DisplayName("remove(T value) deletes 'value' from the queue")
        void shouldRemoveSaidElement() {
            Integer expectedNewPreviousElement = 20;
            Integer expectedNewNextElement = 8;

            list.remove(10);

            Integer newPreviousElement = list.get(0);
            Integer newNextElement = list.get(1);

            assertFalse(list.contains(10));
            assertEquals(expectedNewPreviousElement, newPreviousElement);
            assertEquals(expectedNewNextElement, newNextElement);
        }

        @Test
        void shouldRemoveSaidElementWhenNoPrevious() {
            Integer expectedNewFirst = 10;
            Integer expectedNewIndex0 = 10;

            list.remove(20);

            Integer newFirst = list.first();
            Integer newNextIndex0 = list.get(0);

            assertFalse(list.contains(8));
            assertEquals(expectedNewFirst, newFirst);
            assertEquals(expectedNewIndex0, expectedNewIndex0);
        }

        @Test
        void shouldRemoveSaidElementWhenNoNext() {

        }

        @Test
        void shouldRemoveSaidElementWhenNoPreviousAndNext() {

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

        //Check that remove(T value) returns correct values if Node containing 'value' is found
        @Test
        @DisplayName("remove(T value) should decrease size by 1 if Node is removed")
        void sizeAfterRemoveDecreasesOne() {
            list.append(20);
            list.append(10);

            list.remove(20);

            int expected = 1;
            int returned = list.size();

            assertEquals(expected, returned);
        }

        //Check that remove(T value) returns correct values if Node containing 'value' is not found
        @Test
        @DisplayName("remove(T value) should remain the same if Node is not found")
        void sizeAfterRemoveRemainsSame() {
            list.append(20);
            list.append(10);

            list.remove(15);

            int expected = 2;
            int returned = list.size();

            assertEquals(expected, returned);
        }

    }

    @Nested
    @DisplayName("Tests for get() method")
    class TestsForGetMethod{
        @BeforeEach
        void setUp() {
            list = new DoublyLinkedListDeque<>();
            list.append(3);
            list.append(2);
            list.append(1);
        }

        @AfterEach
        void tearDown() {
            list = null;
        }

        @Test
        @DisplayName("get(0) return first element")
        void returnFirstItem(){
            assertEquals(3, list.get(0));
        }

        @Test
        @DisplayName("get() return middle element")
        void returnMiddleItem(){
            assertEquals(2, list.get(1));
        }

        @Test
        @DisplayName("get(size - 1) return last element")
        void returnLastItem(){
            assertEquals(1, list.get(2));
        }

        @Test
        @DisplayName("get(int index) should throws IndexOutOfBoundsException if the index is negative")
        void shouldThrowsExceptionWithNegativeParameter(){
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        }

        @Test
        @DisplayName("get(int index) should throws IndexOutOfBoundsException if the index is equal or bigger than the list size")
        void shouldThrowsExceptionWithBigParameter(){
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));
        }
    }

    @Nested
    @DisplayName("Tests for contains() method")
    class TestsForContainsMethod{
        
        @BeforeEach
        void setup() {
            list = new DoublyLinkedListDeque<>();
            list.append(20);
            list.append(25);
            list.append(15);
            list.append(-5);
            list.append(32);
            list.append(0);
            list.append(12);
        }

        @AfterEach
        void tearDown() {
            list = null;
        }

        @Test
        void shouldSortIntegersInQueue() {
            Integer expectedFirst = -5;
            Integer expectedSecond = 0;
            Integer expectedThird = 12;
            Integer expectedFourth = 15;
            Integer expectedFifth = 20;
            Integer expectedSixth = 25;
            Integer expectedLast = 32;



            list.sort(Integer::compareTo);

            assertEquals(expectedFirst, list.first());
            assertEquals(expectedSecond, list.get(1));
            assertEquals(expectedThird, list.get(2));
            assertEquals(expectedFourth, list.get(3));
            assertEquals(expectedFifth, list.get(4));
            assertEquals(expectedSixth, list.get(5));
            assertEquals(expectedLast, list.last());


        }
    }
}
