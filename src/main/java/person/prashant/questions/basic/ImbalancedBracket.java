package person.prashant.questions.basic;

import lombok.Builder;
import lombok.Data;
import person.prashant.utility.SolutionTester;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ImbalancedBracket {

    private static Map brackets= new HashMap();

    static {
        brackets.put("]", "[");
        brackets.put("}", "{");
        brackets.put(")", "(");
    }

    public static void main(String[] args) {
        SolutionTester.<String, Boolean>startTest("Example 1")
                .callMethod(ImbalancedBracket::isBalanced)
                .withInput("[{()}]")
                .andExpect(true);

        SolutionTester.<String, Boolean>startTest("Example 2")
                .callMethod(ImbalancedBracket::isBalanced)
                .withInput("[{()}]")
                .andExpect(true);
    }

    private static boolean isBalanced(String input){
        Stack newStack = Stack.builder().build();
        Arrays.stream(input.split(""))
                .forEach(str -> {
                    if(brackets.containsValue(str)){
                        newStack.addValue(str);
                    } else if(brackets.containsKey(str)){
                        newStack.remove(brackets.get(str));
                    }
                });
        return newStack.isEmpty();
    }


    @Builder
    @Data
    private static class Stack<E> {
        private Node<E> lastNode;

        public void addValue(E val){
            Node newNode = Node.builder().value(val).build();
            if(this.lastNode != null){
                newNode.addPreviousNode(this.lastNode);
            }
            this.lastNode = newNode;
        }

        public Node<E> peek(){
            Node result = this.lastNode;
            if(this.lastNode != null){
                this.lastNode = this.lastNode.previousNode;
            }
            return result;
        }

        public boolean pop(){
            Node result = this.lastNode;
            if(this.lastNode != null){
                this.lastNode = this.lastNode.previousNode;
            }
            return result == null;
        }

        public boolean remove(E value){
            if(this.lastNode != null && this.lastNode.getValue().equals(value)){
                this.lastNode = this.lastNode.previousNode;
                return true;
            }
            return false;
        }

        public boolean isEmpty(){
            return this.lastNode == null;
        }



        @Data
        @Builder
        private static class Node<E> {
            private Node previousNode;
            private E value;

            public void addPreviousNode(Node node){
                this.previousNode = node;
            }
        }
    }
}
