package person.prashant.datastructure;

import org.junit.jupiter.api.Test;
import person.prashant.datastructure.list.CircularLinkedList;

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

}