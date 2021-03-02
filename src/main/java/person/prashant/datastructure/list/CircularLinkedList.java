package person.prashant.datastructure.list;

import java.util.ArrayList;
import java.util.List;

public class CircularLinkedList<T> {

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
        public CircularLinkedList first;
        public CircularLinkedList second;
    }

    private Node anyNode;

    public Node<T> getHead(){
        return anyNode;
    }

    public void insert(T data){
        if(data != null){
            Node incoming = new Node(data);
            if(anyNode != null) {
                incoming.next = anyNode.next;
            } else {
                anyNode = incoming;
            }
            anyNode.next = incoming;
        }
    }

    public void insertAtBeginning(T data){
        if(this.anyNode == null){
            this.anyNode = new Node(data);
            this.anyNode.next = this.anyNode;
        } else if(anyNode == anyNode.next){
            Node newNode = new Node(data);
            newNode.next = anyNode;
            //anyNode.next = newNode;
            anyNode = newNode;
        } else {
            Node newNode = new Node(data);
            newNode.next =anyNode;
            anyNode = newNode;
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
        Node<T> start = anyNode;
        Node<T> current = anyNode;
        if(anyNode != null) {
            do {
                list.add(current.data);
                current = current.next;
            } while (current != start);
        }
        return list;
    }

    public boolean delete(Node target){
        if(target != null && anyNode != null){
            if(anyNode.data == target.data){
                anyNode = anyNode.next;
                return true;
            }
            Node start = anyNode;

            while(anyNode.next.data != target.data && anyNode.next != start){

            }
        }
        return false;
    }

    public boolean delete(T target){
        if(target != null && anyNode != null){
            if(anyNode.data == target){
                anyNode = anyNode.next;
                return true;
            }
            Node start = anyNode;

            while(anyNode.next.data != target && anyNode.next != start){

            }
        }
        return false;
    }

    public void traverse(){

    }

    public void print() {
        Node start = anyNode;
        Node current = anyNode;
        if(anyNode != null) {
            do {
                System.out.println(current);
                current = current.next;
            } while (current != start);
        }
    }
}
