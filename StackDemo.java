class Stack
{
    private int arr[];
    private int top;
    private int capacity;
    Stack(int size)
    {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    public void push(int x)
    {
        if (isFull())
        {
            System.out.println("Overflow");
            System.exit(-1);
        }
        arr[++top] = x;
    }
    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Underflow");
            System.exit(-1);
        }
        return arr[top--];
    }
    public int peek()
    {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }
        return -1;
    }
       
 public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Elements in the stack:");
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
    public int size() {
        return top + 1;
    }
    public boolean isEmpty() {
        return top == -1;               
    }
    public boolean isFull() {
        return top == capacity - 1;    
    }
}

class StackDemo
{
public static void main (String[] args)
{
Stack stack = new Stack(3);
stack.push(1);     
stack.push(2);      
stack.display();
stack.pop();        
stack.pop();       
stack.display();
stack.push(3);     
stack.display();    
}
}