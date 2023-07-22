public class Queue 
{
  int size = 5;
  int arr[] = new int[size];
  int front, rear;

  Queue() 
  {
    front = -1;
    rear = -1;
  }

  boolean isFull()
 {
    if (front == 0 && rear == size - 1) 
    {
      return true;
    }
    return false;
  }

  boolean isEmpty() 
  {
    if (front == -1)
      return true;
    else
      return false;
  }

  void enQueue(int element) 
    {
    if (isFull()) 
    {
      System.out.println("Queue is full");
    }
    else {
      if (front == -1) 
      {
        front = 0;
      }
      rear++;
      arr[rear] = element;
    }
  }

  int deQueue() 
    {
    int element;
    if (isEmpty()) 
    {
      System.out.println("Queue is empty");
      return (-1);
    }
    else 
      {
      element = arr[front];
      if (front >= rear) 
      {
        front = -1;
        rear = -1;
      }
      else 
      {
        front++;
      }
      return (element);
    }
  }

  void display() 
    {
    int i;
    if (isEmpty()) 
    {
      System.out.println("Empty Queue");
    }
    else 
    {
      for (i = front; i <= rear; i++)
        System.out.println(arr[i]);
    }
  }

public static void main(String[] args) 
{
Queue q = new Queue();
q.enQueue(1);
q.enQueue(2);
q.enQueue(3);
q.enQueue(4);
q.enQueue(5);
q.display();
q.deQueue();
q.display();
}
}