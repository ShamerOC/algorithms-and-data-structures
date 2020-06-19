package List;

public class LinkedList {
    Node first;
    Node last;

    public LinkedList (int value) {
        this.first = new Node();
        this.first.next = null;
        this.first.prev = null;
        this.first.value = value;
        this.last = this.first;
    }

    public void insert (int value) {
        Node node = new Node();
        node.value = value;
        this.last.next = node;
        node.prev = this.last;
        this.last = node;
    }

    public void deleteValue (int value) {
        Node node = this.first;
        while (node != null) {
            if (node.value == value) {
                if (node.prev != null) {
                    node.prev.next = node.next;
                } else {
                    this.first = node.next;
                }
                if (node.next != null) {
                    node.next.prev = node.prev;
                } else {
                    this.last = node.prev;
                }
                return;
            }
            node = node.next;
        }
    }

    public void print () {
        Node node = first;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    static class Node {
        public int value;
        public Node next;
        public Node prev;
    }
}

