class Node
{
private int data;
private Node link;

public Node()
{
data=0;
link=null;
}
public Node(int data)
{
this.data=data;
this.link=null;
}
public void setData(int data)
{
this.data=data;
}
public void setLink(Node link)
{
this.link=link;
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


class Singlell
{
Node head;
public Singlell()
{
head=null;
}
public void append(int data)
{
Node temp=new Node(data);
if(head==null)
{
head=temp;
return;
}
Node n=head;
while(n.getLink()!=null)
n=n.getLink();
n.setLink(temp);
}

public void insertfirst(int data)
{
Node temp=new Node(data);
if(head==null)
{
head=temp;
return;
}
temp.setLink(head);
head=temp;
}

public void delfirst()
{
if(head!=null)
{
Node temp=head;
head=head.getLink();
temp.setLink(null);
return;
}
System.out.println("list is empty");
}

public void dellast() {
    if (head != null) {
        Node temp = head;
        while (temp.getLink() != null && temp.getLink().getLink() != null) {
            temp = temp.getLink();
        }
        temp.setLink(null);
        return;
    }
    System.out.println("list is empty");
}


public void display()
{
Node temp=head;
while(temp!=null)
{
System.out.println(temp.getData());
temp=temp.getLink();
}
return;
}
}

public class SLL
{
public static void main(String args[])
{
Singlell l=new Singlell();
l.append(10);
l.append(20);
l.append(30);
l.append(40);
l.insertfirst(60);
l.delfirst();
l.dellast();
l.display();
}
}