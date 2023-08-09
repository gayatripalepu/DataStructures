#include<iostream>
using namespace std;

class node
{
	public:
			int data;
			node *next;
		   node(int data)			
		   {
		   	this->data =data;
		   	this->next = NULL;
		   }
};

class cList
{
	node *head,*tail;
	public:
			cList()
			{
				head = tail = NULL;
			}
			void append(int data);
			void delfirst();
			void addfirst(int data);
			void dellast();
			void display();
};
void cList::dellast()
{
	if(head == NULL)
	return;
	node *temp = head;
	node *prev=NULL;
	do{
		prev = temp;
		temp = temp->next;
	}while(temp->next!= head);
	prev->next = head;
	delete tail;
	tail = prev;
}
void cList::addfirst(int data)
{
	node *temp = new node(data);
	if(head == NULL)
	{
		temp->next = temp;
		head = tail = temp;
		return;
	}
	temp->next = head;
	head = temp;
	tail->next= head;
}

void cList::delfirst()
{
	if(head == NULL)
	return;
	node *temp= head;
	head = head->next;
	delete temp;
	tail->next = head;
}

void cList::append(int data)
{
	node *temp = new node(data);
	if(head == NULL)
	{
		temp->next=temp;
		head=tail = temp;
		return;
	}
	temp->next = head;
	tail->next = temp;
	tail=temp;
}

void cList::display()
{
	if(head == NULL)
	return;
	node *temp = head;
	do
	{
		cout<<temp->data<<endl;
		temp = temp->next;
	}while(temp != head);
}

int main()
{
	cList c;
	c.append(10);
	c.append(20);
	c.append(30);
	c.dellast();
	c.display();
}
