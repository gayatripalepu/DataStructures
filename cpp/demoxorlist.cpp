#include<iostream>
#include<stdio.h>
using namespace std;
class Node
{
	public:
			int data;
			Node *next;
			Node(int data=0)			
			{
				this->data=data;
				next=NULL;
			}
};

Node* XOR(Node* a, Node* b) {
        return reinterpret_cast<Node*>(reinterpret_cast<uintptr_t>(a) ^ reinterpret_cast<uintptr_t>(b));
    }

int main(){
	
	Node n1(10),n2(20),n3(30);
	Node *p1,*p2,*p3;
	printf("%u\n",&n1);
	printf("%u\n",&n2);
	p1= &n1;
	p2 = &n2;
	p3= &n3;
	printf("%u\n",p1);
	printf("%u\n",p2);
	Node *xp;
	xp = p1;
	p1->next = XOR(NULL,p2);
	p2->next = XOR(NULL,p1);
	p2->next = XOR(p1,p3);
	p3->next = XOR(NULL,p2);
	/*
	printf("%u\n",xp->data);
	xp = XOR(NULL,xp->next);
	printf("%u\n",xp->data);
	xp = XOR(p1,xp->next);
	printf("%u",xp->data);
	*/
	Node *prev=NULL,*next=NULL;
	while(xp != NULL)
	{
		
		cout<<xp->data<<endl;
		next = XOR(prev,xp->next);
		prev = xp;
		xp = next;
		
	}
	Node *nn = new Node(40);
	Node *p = XOR(NULL,prev->next);
	prev->next = XOR(nn,p);
	nn->next=(NULL,prev);
	
	
	
}    
    
