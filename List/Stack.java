package List;

public class Stack {

    Node last;

    public Stack (int val) {
        Node node = new Node();
        node.prev = null;
        node.value = val;
        this.last = node;
    }

    public void push (int val) {
        Node node = new Node();
        node.value = val;
        node.prev = this.last;
        this.last = node;
    }

    public int peek () {
        if (this.last != null) {
            return this.last.value;
        }
        return -1;
    }

    public int pop () {
        Node res = this.last;
        if (this.last == null) {
            return -1;
        }
        this.last = this.last.prev;
        return res.value;
    }

    public void print () {
        Node node = this.last;
        String res = "";
        while (node != null) {
            res = node.value + " " + res;
            node = node.prev;
        }
        System.out.println(res);
    }

    class Node {
        public int value;
        public Node prev;
    }
}
