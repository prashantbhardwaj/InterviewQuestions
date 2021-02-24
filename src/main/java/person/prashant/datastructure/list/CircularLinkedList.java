package person.prashant.datastructure.list;

public class CircularLinkedList<T> {

    class Node<T> {
        T data;
        Node<T> next;

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

    public void insert(T data){
        if(data != null){
            Node incoming = new Node();
            incoming.data = data;
            if(anyNode != null) {
                incoming.next = anyNode.next;
            } else {
                anyNode = incoming;
            }
            anyNode.next = incoming;
        }
    }

    // TODO
    public void insertAtBeginning(T data){

    }

    // TODO
    public void sortedInsert(){

    }

    // TODO
    public Pair splitIntoTwoHalves(){
        return null;
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
