package linklist;

public class MyLinkList {
    private Node head;
    private int numNodes;
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public MyLinkList(Object data) {
        this.head = new Node(data);
        numNodes++;
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i ++) {
            temp = temp.next;
        }
        holder = temp.next;
        Node addedNode = new Node(data);
        temp.next = addedNode;
        addedNode.next = holder;
        numNodes ++;
    }
    public void addFirst(Object data) {
        Node temp = head;
        Node addedNode = new Node(data);
        head = addedNode;
        addedNode.next = temp;
        numNodes ++;
    }
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index && temp.next != null; i ++) {
            temp = temp.next;
        }
        return temp;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
