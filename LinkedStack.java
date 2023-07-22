class Node {
    int data;
    Node link;

    public Node(int data) {
        this.data = data;
        this.link = null;
    }
}
public class LinkedStack {
    private Node top; 
    public LinkedStack() 
    {
        this.top = null;
    }
    public boolean isEmpty() 
    {
        return top == null;
    }

    public void push(int data) 
    {
        Node temp = new Node(data);
        if(isEmpty())
        {
         top=temp;
        }
        else
        {
        temp.link = top;
        top = temp;
        }
    }
    public int pop() 
   {
        if (isEmpty()) 
        {
            System.out.println("Stack is empty");
        }
        int data = top.data;
        top = top.link;
        return data;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        return top.data;
    }
    public void display() 
    {
        if (isEmpty()) 
        {
            System.out.println("Stack is empty");
            return;
        }

        Node curr = top;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.link;
        }
    }
public static void main(String[] args) 
{
        LinkedStack stack = new LinkedStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display(); 
        stack.pop();
        stack.display();
}
}
