package person.prashant.algo.random;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T val) {
        this.data = val;
    }
}
