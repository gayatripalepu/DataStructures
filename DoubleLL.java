class Node
{
private int data;
private Node next;
private Node prev;

public Node(int data)
{
	this.data =data;
	this.next = null;
	this.prev = null;
} 
public void setData(int data)
{
	this.data = data;
}
public void setNext(Node node)
{
	this.next = node;
}
public void setPrev(Node node)
{
	this.prev =node;
}
public Node getNext()
{
	return this.next;
}
public Node getPrev()
{
	return this.prev;
}
public int getData()
{
	return this.data;
}
}

class DLList
{
	private Node first;
	private Node last;
	public DLList()
	{
		first=null;
		last = null;	
	}
	public void append(int data)
	{
		Node temp = new Node(data);
		if(first == null)
		{
			first = last = temp;
			return;
		}
		temp.setPrev(last);
		last.setNext(temp);
		last = temp;
	}
	public void display()
	{
		Node temp;
		temp =	first;
		while(temp != null)
		{
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
		
}

public class DoubleLL
{
	public static void main(String args[])
	{
		DLList d = new DLList();
		d.append(10);
		d.append(20);
		d.append(30);
		d.display();
		
	}
}