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
    
    bool isEmpty() {
        if(top!=NULL)
           return false;
           
        return true;   
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

Stack *Ascending, *tempS;
void insert(int d);
void del();

int main() {
    
    Ascending = new Stack();
    tempS = new Stack();
    
    insert(3);
    insert(8);
    insert(7);
    insert(6);
    
    Ascending->display();
    
    return 0;
}

void insert(int d ){
    if(Ascending->isEmpty()) {
        Ascending->push(d);
    }
    else {
        if(Ascending->top->data > d) {
            while (!Ascending->isEmpty() && Ascending->top->data >= d)
            {
                int data = Ascending->pop();
                if(data!=-1) {
                    tempS->push(data);
                }
            }
            Ascending->push(d);
            while(!tempS->isEmpty()) {
                Ascending->push(tempS->pop());
            }            
        }
        else {
            Ascending->push(d);
        }
    }
    
}

void del() {
    Ascending->pop();
}