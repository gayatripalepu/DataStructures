#include <iostream>
using namespace std;
class Node {
public:
    int data;
    Node* xorPointer;

    Node(int value) {
        data = value;
        xorPointer = NULL;
    }
};

class XORLinkedList {
private:
    Node* head;

public:
    XORLinkedList() {
        head = NULL;
    }

    Node* XOR(Node* a, Node* b) {
        return reinterpret_cast<Node*>(reinterpret_cast<uintptr_t>(a) ^ reinterpret_cast<uintptr_t>(b));
    }

    void insert(int value) {
        Node* newNode = new Node(value);

        if (head == NULL) {
            head = newNode;
        } else {
            Node* prev = NULL;
            Node* current = head;
            Node* next = XOR(prev, current->xorPointer);

            while (next != NULL) {
                prev = current;
                current = next;
                next = XOR(prev, current->xorPointer);
            }

            current->xorPointer = XOR(prev, newNode);
            newNode->xorPointer = current;
        }
    }

    void deleteNode(int value) {
        if (head == NULL) {
            return;
        }

        Node* prev = NULL;
        Node* current = head;
        Node* next = XOR(prev, current->xorPointer);

        while (current != NULL) {
            if (current->data == value) {
                if (prev != NULL) {
                    prev->xorPointer = XOR(XOR(prev->xorPointer, current), next);
                } else {
                    head = next;
                }

                if (next != NULL) {
                    next->xorPointer = XOR(prev, XOR(current, next->xorPointer));
                }

                delete current;
                break;
            }

            prev = current;
            current = next;
            if (current != NULL) {
                next = XOR(prev, current->xorPointer);
            }
        }
    }

    void display() {
        Node* prev = NULL;
        Node* current = head;
        Node* next;

        cout << "XOR Linked List: ";
        while (current != NULL) {
            cout << current->data << " ";

            next = XOR(prev, current->xorPointer);
            prev = current;
            current = next;
        }
        cout << endl;
    }
    
    void addFirst(int value) {
        Node* newNode = new Node(value);
        newNode->xorPointer = head;

        if (head != NULL) {
            head->xorPointer = XOR(newNode, head->xorPointer);
        }

        head = newNode;
    }

    void deleteFirst() {
        if (head == NULL) {
            return;
        }

        Node* next = head->xorPointer;

        if (next != NULL) {
            next->xorPointer = XOR(head, next->xorPointer);
        }

        delete head;
        head = next;
    }

    void deleteLast() {
        if (head == NULL) {
            return;
        }

        Node* prev = NULL;
        Node* current = head;
        Node* next = XOR(prev, current->xorPointer);

        while (next != NULL) {
            prev = current;
            current = next;
            next = XOR(prev, current->xorPointer);
        }

        if (prev != NULL) {
            prev->xorPointer = XOR(prev->xorPointer, current);
        }

        delete current;
    }
    
      


};

int main() {
    XORLinkedList list;

    
    list.insert(1);
    list.insert(2);
    list.insert(3);
    list.insert(4);
    list.insert(5);

    list.display();

    
    list.deleteNode(3);

    list.display();

    return 0;
}

