package SQ;

public class MyQueueL_65011338 {
    private Node head, tail;

    private class Node {
        String value;
        Node next;

        public Node(String d) {
            value = d;
            next = null;
        }
    }

    public MyQueueL_65011338() {
        head = tail = null;
    }

    public void enqueue(String d) {
        Node n = new Node(d);
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public String dequeue() {
        if (isEmpty()) return "";
        String value = head.value;
        head = head.next;
        if (head == null) {
            tail = null; // if we've dequeued the last item, we need to reset the tail as well
        }
        return value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return false; // Since it's a linked list, we assume it can never be full.
    }

    public String top() {
        if (isEmpty()) return "";
        return head.value;
    }

    public String getLast() {
        if (isEmpty()) return "";
        return tail.value;
    }

    public String dumpToString() {
        StringBuffer sb = new StringBuffer();
        Node n = head;
        while (n != null) {
            sb.append(n.value + " ");
            n = n.next;
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First->");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.value).append("->");
            temp = temp.next;
        }
        sb.append("Last");
        return sb.toString();
    }
}
