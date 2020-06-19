package List;

public class Queue {

    Node last;
    Node first;

    public Queue (int val) {
        Node node = new Node();
        node.value = val;
        node.next = null;

        this.last = node;
        this.first = node;
    }

    public void push (int val) {
        Node node = new Node();
        node.value = val;
        node.next = null;
        this.last.next = node;
        this.last = node;
    }

    public int pop () {
        Node node = this.first;
        if (this.first == null) {
            return -1;
        }

        this.first = this.first.next;
        return node.value;
    }

    public int peek () {
        if (this.first == null) {
            return -1;
        }

        return first.value;
    }

    public void print () {
        Node node = this.first;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }

        System.out.println();
    }

    class Node {
        public int value;
        public Node next;
    }
}
