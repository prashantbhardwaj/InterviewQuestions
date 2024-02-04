package person.prashant.concepts.datastructure.list.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class CircularLinkedListWithLast<T> {
    private Node last;

    public Node<T> getLast(){
        return last;
    }

    public void insert(T data){
        if(data != null){
            Node incoming = new Node(data);
            if(last != null) {
                incoming.next = last.next;
                last.next = incoming;
                last = incoming;
            } else {
                last = incoming;
                last.next = incoming;
            }

        }
    }

    public void insertAtBeginning(T data){
        if(data != null){
            if(this.last == null){
                this.last = new Node(data);
                this.last.next = this.last;
            } else if(last == last.next){
                Node newNode = new Node(data);
                newNode.next = last.next;
                last.next = newNode;
                last = newNode;
            } else {
                Node newNode = new Node(data);
                newNode.next = last;
                last = newNode;
            }
        }
    }

    // TODO
    public Pair splitIntoTwoHalves(){
        return null;
    }

    public List<T> getDataInList(){
        List<T> list = new ArrayList<>();
        Node<T> start = last;
        Node<T> current = last;
        if(last != null) {
            do {
                list.add(current.data);
                current = current.next;
            } while (current != start);
        }
        return list;
    }

    public boolean delete(Node target){
        if(target != null && last != null){
            if(last.data == target.data && last == last.next){
                last = null;
                return true;
            }

            Node checking = last.next;
            Node previous = last;

            do{
                if(checking.data == target.data){
                    previous.next = checking.next;
                    if(checking == last){
                        last = previous;
                    }
                    return true;
                }
                previous = checking;
                checking = checking.next;
            } while (previous != last);
        }
        return false;
    }

    public boolean delete(T target){
        if(target == null){
            return false;
        }
        return delete(new Node(target));
    }

    public Node find(T data){
        Node current = last;
        if(last != null) {
            do {
                if(current.data == data){
                    return current;
                }
                current = current.next;
            } while (current != last);
        }
        return null;
    }

    public boolean contains(T data){
        Node current = last;
        if(last != null) {
            do {
                if(current.data == data){
                    return true;
                }
                current = current.next;
            } while (current != last);
        }
        return false;
    }

    public void print() {
        Node current = last;
        if(last != null) {
            do {
                System.out.println(current);
                current = current.next;
            } while (current != last);
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
        public Node<T> getNext(){
            return next;
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
        public CircularLinkedListWithLast first;
        public CircularLinkedListWithLast second;
    }
}
