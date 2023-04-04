import linklist.MyLinkList;

public class MainLinkList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkList ll = new MyLinkList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(6,9);
        ll.printList();
    }
}
