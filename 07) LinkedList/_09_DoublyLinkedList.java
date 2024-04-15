public class _09_DoublyLinkedList {

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node addFirst(Node head, int data) {
        if (head == null) {
            head = new Node(data);
            return head;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;
        head = newNode;

        return head;
    }

    public Node addLast(Node head, int data) {
        if (head == null) {
            head = new Node(data);
            return head;
        }

        Node temp = head;

        while (temp.next != null) 
            temp = temp.next;

        Node newNode = new Node(data);
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = null;

        return head;
    }

    public Node removeFirst(Node head) {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return null;
        }
        
        head = head.next;
        head.prev = null;

        return head;
    }

    public Node removeLast(Node head) {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return null;
        }
        if (head.next == null) {
            head = null;
            return head;
        }

        Node temp = head;

        while (temp.next.next != null) 
            temp = temp.next;
        
        temp.next.prev = null;
        temp.next = null;

        return head;
    }

    public Node reverse(Node head) {
        if (head == null || head.next == null) 
            return head;

        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;

            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;

        return head;
    }

    public void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }

        Node temp = head;
        System.out.print("null <=> ");

        while (temp != null) {
            System.out.print(temp.data + " <=> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        _09_DoublyLinkedList ll = new _09_DoublyLinkedList();
        Node head = null;

        head = ll.addFirst(head, 0);

        for(int i=1; i<=6; i++)
            head = ll.addLast(head, i);

        ll.printLinkedList(head);
    
        head = ll.removeFirst(head);
        head = ll.removeLast(head);

        ll.printLinkedList(head);

        head = ll.reverse(head);
        
        ll.printLinkedList(head);
    }
}
