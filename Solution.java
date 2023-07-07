import java.io.*;
import java.util.*;
import java.lang.*;
class Node {
        int data;
        Node next;

        Node(int x) 
        {
            data = x;
            next = null;
        }
    }
class LinkedList {
    Node head;
    public void insertNode(int data) {
        Node new_node = new Node(data);
        if(head==null)
        {
            new_node.next=head;
            head = new_node;
            return ; 
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=new_node;
        return ;
    }

    public void insertNode(int data,int x) {
        Node new_node = new Node(data);
        if(x==0)
        {
            new_node.next=head;
            head = new_node;
            return ;
        }
        Node temp=head;
        for(int i=0;i<x-1;i++)
        {
            temp=temp.next;
        }
        new_node.next=temp.next;
        temp.next=new_node;
        return ;
    }

    public void delete(int x)
    {
        if (head == null){
            return;
        }
        Node temp=head;
        for(int i=0;i<x-1;i++)
        {
            temp=temp.next;
        }
        System.out.println(temp.data);
        Node t=temp.next;
        temp.next=t.next;
        // free(t);
        return;
    }
    public void find(int x)
    {
        Node temp=head;
        int f=0;
        int y=0;
        while(temp!=null)
        {
            if (temp.data==x)
            {
                System.out.println(f);
                y=1;
                break;
            }
            f++;
            temp=temp.next;
        }
        if(y==0)
        {
            System.out.println(-1);
        }
    }
    public void display()
    {
        Node node = head;
        while(node!=null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        return;
    }

}
public class Solution {

    public static void main(String[] args) {
        
        LinkedList ll1=new LinkedList();
        Scanner sc=new Scanner(System.in);
        int val=sc.nextInt();
        while(val!=-1)
        {
            ll1.insertNode(val);
            val=sc.nextInt();
        }
        int val1=sc.nextInt();
        int val2=sc.nextInt();
        ll1.insertNode(val2,val1);
        ll1.display();
    }
}