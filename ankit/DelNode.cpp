#include <iostream>
#include <map>
using namespace std;

struct Node {
    int data;
    struct Node *next;
};

typedef struct Node Node;


Node *head = NULL;
void insert(int d);
void display(Node * temp );
void del(Node *temp);


int main()
{
   insert(4);
   insert(3);
   insert(2);
   insert(3);
   insert(4);
   insert(7);
   
   display(head); 
   del(head->next->next);
   
   display(head);
   return 0;
}

void insert(int d) {
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

void del(Node *temp ) {
    Node *cpy = temp->next;
    if(!cpy){
        cout<<"last node can't be deleted\n";
    }
    else {
        cout<<temp->data<<"deleted\n";
        temp->data=cpy->data;
        temp->next=cpy->next;
        delete cpy;
    }
}
