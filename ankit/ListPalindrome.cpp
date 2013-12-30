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
    
    void Stackdisplay() {
        Node *temp=top;
        while(temp) {
            cout<<"->"<<temp->data;
            temp=temp->next;
        }
    }
    
};

typedef struct Stack Stack;

Node *head=NULL;

Node *insert(int d) {
    Node *temp = new Node();
    temp->data=d;
    temp->next=NULL;
    if(!head) {
        head=temp;
    }
    else {
        temp->next=head;
        head=temp;
        
    }
    return head;

}

void display(Node *temp ) {
    if(temp) {
        cout<<"->"<<temp->data;
        display(temp->next);
    }
    else {
        cout<<"\n";
    }
}


bool palindrome() {
    Node *slow,*fast;
    Stack *S = new Stack();
    slow=head;
    fast=head;
    while(fast!=NULL && fast->next!=NULL) {
        S->push(slow->data);
        slow=slow->next;
        fast=fast->next->next;
        
    }
    
    //for odd length list
    if(fast!=NULL && fast->next==NULL) {
        slow=slow->next;
    }
    
    while(slow) {
        int d= S->pop();
        if(d==-1) {
            return false;
        }
        else {
            if(d==slow->data) {
                slow=slow->next;
            }
            else {
                return false;
            }
        }
    }
    return true;
}

int main() {
    insert(1);
    insert(2);
    insert(3);
    insert(3);
    insert(2);
    insert(1);
    
    if(palindrome())
    cout<<"list is palindrome\n";
    else
    cout<<"list is not palindrome\n";
    return 0;
}

