class Node 
{
    int data;
    Node link;
    public Node(int data) 
    {
        this.data = data;
        this.link = null;
    }
}
public class LinkedQueue 
{
    private Node front; 
    private Node rear;  
    public LinkedQueue() 
    {
        this.front = null;
        this.rear = null;
    }
    public boolean isEmpty() 
    {
        return front == null;
    }
    public void enqueue(int data) 
   {
        Node temp = new Node(data);
        if (isEmpty()) {
            front = rear = temp;
        } 
        else 
        {
            rear.link = temp;
            rear = temp;
        }
    }

    public int dequeue() 
    {
        if (isEmpty()) 
        {
           System.out.println("Queue is empty");
        }
        int data = front.data;
        front = front.link;
        if (front == null) 
        {
            rear = null; 
        }
        return data;
    }

    public int peek() 
    {
        if (isEmpty()) 
        {
           System.out.println("Queue is empty");
        }
        return front.data;
    }
    public void display() 
   {
        if (isEmpty()) 
        {
            System.out.println("Queue is empty");
            return;
        }

        Node curr = front;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.link;
        }
    }
public static void main(String[] args) 
{
        LinkedQueue queue = new LinkedQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();
        queue.dequeue();
        queue.display();
    }
}
