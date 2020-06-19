package List;

import java.io.SequenceInputStream;

public class Main {
    public static void main (String[] args) {
        System.out.println("linkedList");
        LinkedList linkedList = new LinkedList(2);
        linkedList.insert(1);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(7);
        linkedList.deleteValue(4);
        linkedList.print();

        System.out.println("Stack");
        Stack stack = new Stack(2);
        stack.push(1);
        stack.push(3);
        stack.push(7);
        stack.push(9);
        stack.pop();
        stack.print();

        System.out.println("Queue");
        Queue queue = new Queue(2);
        queue.push(2);
        queue.push(1);
        queue.push(3);
        queue.push(7);
        queue.pop();
        queue.print();

    }
}
