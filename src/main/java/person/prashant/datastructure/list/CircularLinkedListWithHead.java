package person.prashant.datastructure.list;

import java.util.ArrayList;
import java.util.List;

public class CircularLinkedListWithHead<T> {
    private Node head;

    public Node<T> getHead(){
        return head;
    }

    public void insert(T data){
        if(data != null){
            Node incoming = new Node(data);
            if(head != null) {
                incoming.next = head.next;
            } else {
                head = incoming;
            }
            head.next = incoming;
        }
    }

    public void insertAtHead(T data){
        if(this.head == null){
            this.head = new Node(data);
            this.head.next = this.head;
        } else if(head == head.next){
            Node newNode = new Node(data);
            newNode.next = head;
            //anyNode.next = newNode;
            head = newNode;
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
    }

    // TODO
    public void sortedInsert(){

    }

    // TODO
    public Pair splitIntoTwoHalves(){
        return null;
    }

    public List<T> getDataInList(){
        List<T> list = new ArrayList<>();
        Node<T> start = head;
        Node<T> current = head;
        if(head != null) {
            do {
                list.add(current.data);
                current = current.next;
            } while (current != start);
        }
        return list;
    }

    public boolean delete(Node target){
        if(target != null && head != null){
            if(head.data == target.data){
                head = head.next;
                return true;
            }
            Node start = head;

            while(head.next.data != target.data && head.next != start){

            }
        }
        return false;
    }

    public boolean delete(T target){
        if(target != null && head != null){
            if(head.data == target){
                head = head.next;
                return true;
            }
            Node start = head;

            while(head.next.data != target && head.next != start){

            }
        }
        return false;
    }

    // TODO
    public void deleteHead(){

    }

    public void traverse(){

    }

    public void print() {
        Node start = head;
        Node current = head;
        if(head != null) {
            do {
                System.out.println(current);
                current = current.next;
            } while (current != start);
        }
    }

    public static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }

        public T getData(){
            return data;
        }

        @Override
        public int hashCode() {
            return data.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return data.equals(obj);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    class Pair {
        public CircularLinkedListWithHead first;
        public CircularLinkedListWithHead second;
    }
}
