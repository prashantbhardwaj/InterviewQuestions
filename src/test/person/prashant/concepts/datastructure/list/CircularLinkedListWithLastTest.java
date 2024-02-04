package person.prashant.concepts.datastructure.list;

import org.junit.jupiter.api.Test;
import person.prashant.concepts.datastructure.list.linkedlist.CircularLinkedListWithLast;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListWithLastTest {

    @Test
    void testInsert() {
        CircularLinkedListWithLast<String> circularLinkedList = new CircularLinkedListWithLast<String>();
        circularLinkedList.print();

        circularLinkedList.insert("1");
        assertEquals("1", circularLinkedList.getLast().getData());

        circularLinkedList.insert("2");
        assertEquals("2", circularLinkedList.getLast().getData());
        assertEquals("1", circularLinkedList.getLast().getNext().getData());

        circularLinkedList.insert("abcd");
        assertEquals("abcd", circularLinkedList.getLast().getData());
        assertEquals("1", circularLinkedList.getLast().getNext().getData());
        assertEquals("2", circularLinkedList.getLast().getNext().getNext().getData());
    }

    @Test
    void testDeleteNode() {
        CircularLinkedListWithLast<String> circularLinkedList = new CircularLinkedListWithLast<String>();

        circularLinkedList.insert("random");
        circularLinkedList.delete(new CircularLinkedListWithLast.Node("random"));
        assertNull(circularLinkedList.getLast());

        circularLinkedList.insert("1");
        circularLinkedList.insert("2");
        circularLinkedList.insert("3");
        circularLinkedList.insert("4");
        circularLinkedList.insert("5");
        circularLinkedList.insert("6");

        // delete data which doesn't exist
        boolean result1 = circularLinkedList.delete(new CircularLinkedListWithLast.Node("unknown"));
        assertFalse(result1);

        // delete from middle
        boolean result2 = circularLinkedList.delete(new CircularLinkedListWithLast.Node("3"));
        assertTrue(result2);
        assertFalse(circularLinkedList.getDataInList().contains("3"));
        assertEquals("6", circularLinkedList.getLast().getData());
        assertEquals("1", circularLinkedList.getLast().getNext().getData());
        assertEquals("2", circularLinkedList.getLast().getNext().getNext().getData());
        assertEquals("4", circularLinkedList.getLast().getNext().getNext().getNext().getData());
        assertEquals("5", circularLinkedList.getLast().getNext().getNext().getNext().getNext().getData());

        // delete from last
        boolean result3 = circularLinkedList.delete(new CircularLinkedListWithLast.Node("6"));
        assertTrue(result3);
        assertFalse(circularLinkedList.getDataInList().contains("6"));
        assertEquals("5", circularLinkedList.getLast().getData());
        assertEquals("1", circularLinkedList.getLast().getNext().getData());
        assertEquals("2", circularLinkedList.getLast().getNext().getNext().getData());
        assertEquals("4", circularLinkedList.getLast().getNext().getNext().getNext().getData());

        // delete from beginning
        boolean result4 = circularLinkedList.delete(new CircularLinkedListWithLast.Node("1"));
        assertTrue(result4);
        assertFalse(circularLinkedList.getDataInList().contains("1"));
        assertEquals("5", circularLinkedList.getLast().getData());
        assertEquals("2", circularLinkedList.getLast().getNext().getData());
        assertEquals("4", circularLinkedList.getLast().getNext().getNext().getData());

        // delete remaining all
        boolean result5 = circularLinkedList.delete(new CircularLinkedListWithLast.Node("4"));
        assertTrue(result5);
        assertFalse(circularLinkedList.getDataInList().contains("4"));
        assertEquals("5", circularLinkedList.getLast().getData());
        assertEquals("2", circularLinkedList.getLast().getNext().getData());

        // delete remaining all
        assertTrue(circularLinkedList.contains("2"));
        boolean result6 = circularLinkedList.delete(new CircularLinkedListWithLast.Node("2"));
        assertTrue(result6);
        assertFalse(circularLinkedList.contains("2"));
        assertEquals("5", circularLinkedList.getLast().getData());

        // delete remaining all
        assertTrue(circularLinkedList.contains("5"));
        boolean result7 = circularLinkedList.delete(new CircularLinkedListWithLast.Node("5"));
        assertTrue(result7);
        assertFalse(circularLinkedList.contains("5"));
        assertNull(circularLinkedList.getLast());

    }

}