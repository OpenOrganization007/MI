#include <iostream>
using namespace std;

struct Node {
  int data;
  struct Node *next;
};

typedef struct Node Node;
struct Stack {
    Node *top;
    Stack() {
        top=NULL;
    }
    
    void push(int d) {
        Node *temp =new Node();
        temp->data=d;
        temp->next=NULL;
        cout<<temp->data<<"inserted\n";
        if(top==NULL) {
            top=temp;
        }
        else {
            temp->next=top;
            top=temp;
        }
    }
    
    int pop() {
        if(top) {
            cout<<top->data<<"deleted\n";
            Node *temp =top;
            top=top->next;
            int d = temp->data;
            delete temp;
            return d;
        }
        else {
            cout<<"Stack is empty\n";
            return -1;
        }
    }
    
    void display() {
        Node *temp=top;
        while(temp) {
            cout<<"->"<<temp->data;
            temp=temp->next;
        }
    }
    
};

typedef struct Stack Stack;

struct Queue {
    Stack *s1 , *s2;
    
    Queue() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    void insert(int d) {
        while(s1->top!=NULL) {
            s2->push(s1->pop());
        }
        s1->push(d);
        while(s2->top!=NULL) {
            s1->push(s2->pop());
        }
        
    }
    
    void del() {
        s1->pop();
    }
    void traverse()
    {
         s1->display();    
    }
};

typedef struct Queue Queue;

int main()
{
   Queue *q = new Queue();
   
   q->insert(3);
   q->insert(4);
   q->insert(5);
   q->insert(6);
   q->insert(7);
   q->insert(8);
   
   q->del();
   
   q->traverse();
   
   return 0;
}



