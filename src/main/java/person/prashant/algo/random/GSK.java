package person.prashant.algo.random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GSK {

    public static void main(String[] args) {
        String s1 = "2 1 3"; // 1
        String s2 = "15 7 16 1 12 N N N 2 10 14"; // 1
        String s3 = "3 2 5 1 4"; // 0
        String s4 = "1 1 1 1 1 N 1 1 1 1 1"; // 0

        Node root = buildTree(s4);
        GSK g = new GSK();

        if(root != null && g.isBSTUsingParent(root, null)){
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        if(root != null && g.isBSTUsingList(root)){
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static Node buildTree(String str){
        if(str.length() == 0 || str.charAt(0) == 'N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size() > 0 && i < ip.length){
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];

            if(!currVal.equals("N")){
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            i++;
            if(i >= ip.length){
                break;
            }
            currVal = ip[i];
            if(!currVal.equals("N")){
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    boolean isBSTUsingParent(Node<Integer> root, Node<Integer> parent)
    {
        // code here.

        boolean result = true;

        if(root.left != null){
            if(root.left.data > root.data){
                return false;
            } if(parent != null && parent.data < root.data && parent.data > root.left.data){
                return false;
            } else {
                result = isBSTUsingParent(root.left, root);
            }
        }

        if(!result){
            return result;
        }

        if(root.right != null){
            if(root.right.data <= root.data){
                return false;
            } if(parent != null && parent.data > root.data && parent.data < root.right.data){
                return false;
            } else {
                result = isBSTUsingParent(root.right, root);
            }
        }

        if(!result){
            return result;
        }

        return true;
    }

    private boolean isBSTUsingList(Node root) {
        // create a list
        // inorder traversal to fill the list
        // see if all the items in the list are in sequence

        List<Integer> allElements = new ArrayList();
        inOrderTraversal(root, allElements);

        if(allElements.size() == 0){
            return false;
        }

        if(allElements.size() == 1){
            return true;
        }

        for (int i = 1; i < allElements.size(); i++) {
            if(allElements.get(i -1) > allElements.get(i)){
                return false;
            }
        }
        return true;
    }

    private void inOrderTraversal(Node<Integer> root, List<Integer> list){
        if(root != null) {
            inOrderTraversal(root.left, list);
            list.add(root.data);
            inOrderTraversal(root.right, list);
        }
    }
}
