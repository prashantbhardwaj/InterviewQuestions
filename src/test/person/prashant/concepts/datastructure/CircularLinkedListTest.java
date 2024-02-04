package person.prashant.concepts.datastructure;

import org.junit.jupiter.api.Test;
import person.prashant.concepts.datastructure.list.linkedlist.CircularLinkedList;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    @Test
    void testInsert() {
        CircularLinkedList<String> circularLinkedList = new CircularLinkedList<String>();
        circularLinkedList.print();
        circularLinkedList.insert("1");
        circularLinkedList.print();
        circularLinkedList.insert("2");
        circularLinkedList.print();
        circularLinkedList.insert("3");
        circularLinkedList.print();
        circularLinkedList.insert("4");
        circularLinkedList.print();
        //circularLinkedList.delete("4");
    }

    @Test
    void testInsertAtBeginning() {
        CircularLinkedList<String> circularLinkedList = new CircularLinkedList<String>();
        circularLinkedList.print();
        circularLinkedList.insertAtBeginning("1");
        assertEquals("1", circularLinkedList.getHead().getData());
        circularLinkedList.insertAtBeginning("2");
        assertEquals("2", circularLinkedList.getHead().getData());
        circularLinkedList.insertAtBeginning("abcd");
        assertEquals("abcd", circularLinkedList.getHead().getData());
    }

    @Test
    void testDeleteNode() {
        CircularLinkedList<String> circularLinkedList = new CircularLinkedList<String>();
        circularLinkedList.print();
        circularLinkedList.insertAtBeginning("1");
        circularLinkedList.insertAtBeginning("2");
        circularLinkedList.insertAtBeginning("abcd");
        assertTrue(circularLinkedList.getDataInList().contains("2"));

        circularLinkedList.delete(new CircularLinkedList.Node("2"));
        assertFalse(circularLinkedList.getDataInList().contains("2"));

    }


}