import java.util.Scanner;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteAlternateNodes {
    public static Node deleteAlternateNodes(Node head) {
        if (head == null || head.next == null) {
            return head; // Return the original list if it is empty or contains only one node
        }

        Node curr = head;
        Node prev = null;

        while (curr != null && curr.next != null) {
            prev = curr;
            curr = curr.next.next;
            prev.next = curr;
        }

        return head;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split(" ");

        Node head = null;
        Node tail = null;
        for (String value : values) {
            int num = Integer.parseInt(value);
            if (num == -1) {
                break;
            }

            Node newNode = new Node(num);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        head = deleteAlternateNodes(head);

        printList(head);
    }
}