#include<iostream>
using namespace std;

class node
{
	public:
			int data;
			node *next,*prev;
		   node(int data)			
		   {
		   	this->data =data;
		   	this->next = NULL;
		   	this->prev = NULL;
		   }
};

class DCList
{
	node *first,*last;
	public:
			DCList()
			{
				first=last=NULL;
			}
			void append(int data);
			void addfirst(int data);
			void delfirst();
			void dellast();
			void displayf();
			void displayb();
};
void DCList::dellast()
{
	if(first == NULL)
	return;
	node *temp = last;
	last = last->prev;
	last->next = first;
	first->prev = last;
	delete temp;
}
void DCList::delfirst()
{
	if(first == NULL)
	return;
	node *temp= first;
	first=first->next;
	first->prev = last;
	last->next = first;
	delete temp;
}
void DCList::addfirst(int data)
{
	node *temp = new node(data);
	if(first == NULL)
	{
		temp->prev = temp;
		temp->next =temp;
		first = last = temp;
		return;
	}
	first->prev = temp;
	temp->next = first;
	temp->prev = last;
	last->next = temp;
	first= temp;
	
}
void DCList::append(int data)
{
	node *temp = new node(data);
	if(first == NULL)
	{
		temp->next = temp;
		temp->prev = temp;
		first = last = temp;
		return;
	}
	
	last->next = temp;
	temp->prev = last;
	last = temp;
	last->next = first;
	first->prev = last;
}
void DCList::displayf()
{
	if(first == NULL)
	return;
	node *temp = first;
	do
	{
		cout<<temp->data<<endl;
		temp = temp->next;
	}while(temp!= first);
}
void DCList::displayb()
{
	if(first == NULL)
	return;
	node *temp = last;
	do
	{
		cout<<temp->data<<endl;
		temp = temp->prev;
	}while(temp!= last);
}
int main()
{
	DCList d;
	d.append(10);
	d.append(20);
	d.append(30);
	d.dellast();
	d.displayb();
}
