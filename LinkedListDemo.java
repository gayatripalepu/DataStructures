class Node
{
private int data;
private Node link;
public Node()
{
	data=0;
	link = null;
}
public Node(int data)
{
	this.data = data;
	this.link = null;
}

public void setData(int data)
{
	this.data = data;
}
public void setLink(Node link)
{
	this.link = link;
}
public int getData()
{
	return this.data;
}
public Node getLink()
{
	return this.link;
}
}

class SLList
{
Node head;
public SLList()
{
	head = null;
}
public void append(int data)
{
Node n = new Node(data);
if(head == null)
{
	head = n;
	return;
}
Node temp = head;
while(temp.getLink() != null)
temp = temp.getLink();
temp.setLink(n);
}


public void display()
{
 if(head != null)
{
	Node temp = head;
	while(temp != null)
	{
		System.out.println(temp.getData());
		temp = temp.getLink();
	}
	return;	
}
System.out.println("List is empty");
}


public SLList[] arrange() {
        SLList[] obj = new SLList[2];
        obj[0] = new SLList(); 
        obj[1] = new SLList();

        Node t1 = head;
        Node t2 = head.getLink();
        while (t2 != null) {
            t2 = t2.getLink();
            if (t2 != null) {
                t1 = t1.getLink();
                t2 = t2.getLink();
            }
        }
        obj[0].head = head;
        obj[1].head = t1.getLink();
        t1.setLink(null);

        return obj;
    }
}


public class LinkedListDemo {
    public static void main(String[] args) {
        SLList l1 = new SLList();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);
        l1.append(5);
        l1.append(6);
        l1.append(7);
        l1.append(8);

        System.out.println("Original list:");
        l1.display();

        SLList[] l2 = l1.arrange();

        System.out.println("First half:");
        l2[0].display();

        System.out.println("Second half:");
        l2[1].display();
    }
}


/*if (head == null || head.getLink() == null) {
            obj[0].head = head;
            return obj;
        }*/