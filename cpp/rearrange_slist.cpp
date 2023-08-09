#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;

    Node(int data) {
        this->data = data;
        next = NULL;
    }
};

class LinkedList {
private:
    Node* head;

public:
    LinkedList() {
        head = NULL;
    }

    void insert(int data) {
        Node* newNode = new Node(data);
        if (head == NULL) {
            head = newNode;
        } else {
            Node* temp = head;
            while (temp->next != NULL) {
                temp = temp->next;
            }
            temp->next = newNode;
        }
    }

    void rearrangeList() {
        if (head == NULL || head->next == NULL) {
            return;
        }

        Node* prev = head;
        Node* current = head->next;

        // Splitting the list into two halves
        while (current != NULL && current->next != NULL) {
            prev = prev->next;
            current = current->next->next;
        }
        Node* middle = prev->next;
        prev->next = NULL;
        // Rearranging the nodes alternatively
        Node* firstList = head;
        Node* secondList = middle;
        while (secondList != NULL) {
            Node* nextFirst = firstList->next;
            Node* nextSecond = secondList->next;

            firstList->next = secondList;
            secondList->next = nextFirst;

            firstList = nextFirst;
            secondList = nextSecond;
        }
    }

void rearrangeList1() {
        if (head == NULL || head->next == NULL) {
            return;
        }

        Node* prev = head;
        Node* current = head->next;

        // Splitting the list into two halves
        while (current != NULL && current->next != NULL) {
            prev = prev->next;
            current = current->next->next;
        }
        Node* middle = prev->next;
        prev->next = NULL;
		displayAll(head);
		displayAll(middle);
        // Reversing the second half of the list
        Node* prevNode = NULL;
        Node* currentNode = middle;
        Node* nextNode;
        while (currentNode != NULL) {
            nextNode = currentNode->next;
            currentNode->next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        middle = prevNode;
		
        // Rearranging the nodes alternatively
        Node* firstList = head;
        Node* secondList = middle;
        while (secondList != NULL) {
            Node* nextFirst = firstList->next;
            Node* nextSecond = secondList->next;

            firstList->next = secondList;
            secondList->next = nextFirst;

            firstList = nextFirst;
            secondList = nextSecond;
        }
    }

    void display() {
        Node* temp = head;
        while (temp != NULL) {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }
    
    void displayAll(Node *temp1) {
        Node* temp = temp1;
        while (temp != NULL) {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }
     void copy(const LinkedList& other) {
        if (other.head == NULL) {
            head = NULL;
        } else {
            Node* current = other.head;
            head = new Node(current->data);
            Node* temp = head;

            while (current->next != NULL) {
                current = current->next;
                temp->next = new Node(current->data);
                temp = temp->next;
            }
        }
    }
    
     void concat(const LinkedList& other) {
        if (head == NULL) {
            head = other.head;
        } else {
            Node* temp = head;
            while (temp->next != NULL) {
                temp = temp->next;
            }
            temp->next = other.head;
        }
    }
};

int main() {
    LinkedList list;
    list.insert(10);
    list.insert(20);
    list.insert(30);
    list.insert(40);
    list.insert(50);
    list.insert(60);
	
    cout << "Original list:" << endl;
    list.display();
	
	LinkedList l2;
	l2.insert(100);
	l2.copy(list);
	cout << "Duplicate list:" << endl;
	l2.display();
    
	list.rearrangeList();
    cout << "Rearranged list:" << endl;
    list.display();
	
	l2.rearrangeList1();
    cout << "Rearranged list:" << endl;
    l2.display();
    return 0;
}

